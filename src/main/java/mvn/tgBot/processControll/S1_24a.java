package mvn.tgBot.processControll;

import mvn.tgBot.db.EnsuredType;
import mvn.tgBot.db.User;
import mvn.tgBot.tgObjects.Result;
import mvn.tgBot.utils.Age;
import mvn.tgBot.utils.CheckDates;
import mvn.tgBot.utils.Regexp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 17/02/16
 * Time: 22:46
 * Stage: ввод данных тех кто застрахован по полису
 */
@Component
public class S1_24a extends StageMaster implements StageInt {


    private Log log = LogFactory.getLog(S1_24a.class);

    public S1_24a() {
        name = "s1-24a";
        nextStageName = "s1-24";
        msg = "Введите имя и фамилию на латинице, дату рождения, номер паспорта \nв таком формате:\n IVAN IVANOV 25.05.1985 745865452\n";
        descr = "данные застрахованных";
    }

    @Override
    public void process(User user, Result r) throws StageNotFoundException {
        String txt = r.getMessage().getText();
//        Long chatId = user.getChatId();
        String key = user.getEnsuredCurrentKey();
//        if (key != null) key = regexp.filterReplaseDot(key);
        if(key==null) {
            log.error("unknown key for HashMap<key,Ensured>");
            key = "1:necktie:";
        }
        log.debug("key=" + key);
        if (user.getEnsured() == null) user.setEnsured(new HashMap());
        String[] men = Regexp.filterUserData(txt);
        String birthday="";
        String passport="";
        StringBuffer msgOut = new StringBuffer();
        boolean isError=false;

        if(men.length!=4) {
            msgOut.append("Ошибка при вводе количество слов <4" );
            isError=true;
        }
        else {
            birthday = (men[2] != null) ? Regexp.filterDate(men[2]) : "?";
            passport = (men[3] != null) ? Regexp.filterPassport(men[3]) : "?";

            if (!isCorrectClient(men)) {
                msgOut.append("Недопустимые символы в фамилии и имени:" + men[0] + "|" + men[1]);
                isError = true;
            }
            try {
                if (!isCorrectBirthday(key, birthday)) {
                    msgOut.append("\nОшибка\n при вводе Дня рождения, учтите возрастную группу, получено:" + birthday);
                    isError = true;
                }
            } catch (ParseException e) {
                msgOut.append("\nНе возможно сформировать дату из:" + birthday);
                isError = true;
            }
            if (!isCorrectPassport(passport)) {
                msgOut.append("\nОшибка при вводе номера паспорта:" + passport + "\n");
                isError = true;
            }
        }
        if (isError) {
            msgOut.append("\nВвод таком формате:\n IVAN IVANOV 25/05/1985 745865452");
            tgbot.sendMistake(user.getChatId(), msgOut.toString());
        }
        else {  // все проверки пройдены
            String [] clientOut = {men[0],men[1],birthday,passport};
            user.getEnsured().put(key, new EnsuredType(clientOut, key));
            StageInt next = stageList.getStage(nextStageName);
            next.sendMessage(user, r);     // отправить сообщение от следующей стадии обработки
            user.setWait4Stage(nextStageName);     // запомнить след шаг для данного ChatID
            db.save(user);
        }
    }

    //
    private boolean isCorrectClient(String[] men) {
        return (men[0]!=null
                && men[1]!=null
                && men[0].length()>1
                && men[1].length()>1
                &&  Regexp.isLatin(men[0])
                &&  Regexp.isLatin(men[1])
        );
    }

    /**
     * Проверка возраста при заданной возрастной группе
     * @param key
     * @param birthday
     * @return
     * @throws ParseException
     */
    private boolean isCorrectBirthday(String key, String birthday) throws ParseException {
        boolean ok=false;
        log.trace("Check date for key="+key);
        int age = CheckDates.getAge(Regexp.filterDate(birthday));
        if(key.contains(Age.get[0])){
            ok = ( age >=12 && age<= 60);
        }
        else if(key.contains(Age.get[1])) {
            ok = (age>60 && age < 75);
        }
        else if(key.contains(Age.get[2])) {
            ok = (age<12 && age>0);
        }
        return ok;
    }

    private boolean isCorrectPassport(String passport) {
        int len = passport.length();
        boolean digOnly = Regexp.isDigital(passport);
        return(len ==9  && digOnly);
    }


    //        отправить сообщение клиенту
//        используется из стадии предыдущей этой
    @Override
    public void sendMessage(User user, Result r) {
        Long chatId = user.getChatId();
        String note="";
        if(user.getEnsuredCurrentKey().contains(Age.get[0])) note =" возраст от 12 до 60";
        else if(user.getEnsuredCurrentKey().contains(Age.get[1])) note =" возраст от 61 до 74";
        else if(user.getEnsuredCurrentKey().contains(Age.get[2])) note =" возраст до 12";

        String[][] usersMenu =  getAllUserMenu(user);
        String mmm =   msg + "участник=" + user.getEnsuredCurrentKey()+note;
        if(usersMenu==null)   tgbot.sendMenuOff(chatId,mmm);
        else tgbot.sendMenuON(chatId, mmm,usersMenu );
    }

    private String[][] getAllUserMenu (User us) {
        HashMap<String, EnsuredType> all = us.getEnsuredAll();
        if(all==null) return null;
        int sz=all.size();

        String[][] ret = new String[sz][1];
        int tik=0;
        for( String key : all.keySet()    ) {
            EnsuredType ens = all.get(key);
            ret[tik++][0] = ens.getFirstName()+" "+ens.getLastName()+" "+ens.getBirthday()+" "+ens.getPasport();
        }
        return ret;
    }

}
