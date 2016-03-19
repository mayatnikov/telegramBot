package mvn.tgBot.processControll;

import mvn.tgBot.db.EnsuredType;
import mvn.tgBot.db.User;
import mvn.tgBot.tgObjects.Result;
import mvn.tgBot.utils.Age;
import mvn.tgBot.utils.Regexp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 17/02/16
 * Time: 22:46
 * Stage: ввод данных тех кто застрахован по полису
 */
@Component
public class S1_24 extends StageMaster implements StageInt {

    @Autowired
    Regexp regexp;

    private Log log = LogFactory.getLog(S1_24.class);

    public S1_24() {
        name = "s1-24";
        nextStageName = "s1-24a";
        msg = "Замечательно, самое сложное прошли, осталось немного - указать данные тех, кто будет застрахован по этому полису:\n" +
                "Примечание:\n" +
                ""+Age.get[0]+" - взрослые\n" +
                ""+Age.get[1]+" - пожилые\n" +
                " "+Age.get[2]+" - дети";
        descr = "данные застрахованных";
    }

    String msg2 = "Для каждого укажите \nимя и фамилию на латинице, дату рождения, номер паспорта \nв таком формате:\n IVAN IVANOV 25.05.1985 745865452\n";

    @Override
    public void process(User user, Result r) throws StageNotFoundException {
        String txt = r.getMessage().getText();
        Long chatId = user.getChatId();
        String nStage = nextStageName;

        if (txt.toUpperCase().contains("ЗАПОЛНИЛ")) {
            int ensuredQuant = user.getChildNumber()+ user.getOldNumber()+ user.getEnsuredNumber();
            int ensuredSize = user.getEnsured().size();
            if(ensuredQuant != ensuredSize) {
                tgbot.sendMistake(chatId, "Не указаны данные застрахованных.");
                nStage=name;  // никуда не переходим пока всех не заполнит
            }
            else {
//                  if(false )  { // user.getEnsured().get(root)!=null ) {
//                if (user.getEnsured().get(root) != null) {
//                    log.debug("root user was found");
//                    user.setFirstNameEng(user.getEnsured().get(root).getFirstName());  // запомнить англ фио
//                    user.setLastNameEng(user.getEnsured().get(root).getLastName());  // запомнить англ фио
//                    user.setPassport(user.getEnsured().get(root).getPasport());  // запомнить номер паспорта
                    // сохранить всех заполенных в массиве для последующего использования
                    saveAllEnsured(user);
//                }
                nStage = "s1-25";
            }
        }
        else  {
            // в запросе по нажатой кнопке должен быть индекс участника вида 1:necktie: .....
            // выделим его и сформируем key = i1_[возраст]
            String[] data = Regexp.filterIndexCol(txt);
            user.setEnsuredCurrentKey(data[0] + ":" + data[1]+":");  // сохр текущий индекс в профиле клиента

            if(data[0].matches("[0-9]")) nStage = "s1-24a";
            else { nStage = name; tgbot.sendMistake(user.getChatId()); }
        }
        StageInt next = stageList.getStage(nStage);
        user.setWait4Stage(nStage);     // запомнить след шаг для данного ChatID
        next.sendMessage(user, r);     // отправить сообщение от следующей стадии обработки
        db.save(user);
    }

// добавить всех страхемых в исторический массив EnsuredAll
    private void saveAllEnsured(User user) {
        HashMap<String, EnsuredType> all = user.getEnsuredAll();
        if(all== null) all = new <String, EnsuredType>HashMap();   // создать если его еще нет
        HashMap<String, EnsuredType> lst = user.getEnsured();
        for(String key : lst.keySet()) {
            EnsuredType us1 = lst.get(key);
            all.put(us1.getFirstName()+":"+us1.getLastName(),us1);
        }
        user.setEnsuredAll(all);
    }

    @Override
    public void sendMessage(User user, Result r) {

        // @TODO поставить ограничение по максимальному количеству людей !
        String[][] cmenu = generateMenu(user,r);
        Long chatId = user.getChatId();
        tgbot.sendMenuON(chatId, msg, cmenu);
    }

    // создание меню на основе накопленных данных
    private String[][] generateMenu(User user, Result r) {
        log.debug("start create menu");

        int n1 = user.getEnsuredNumber();
        int n2 = user.getOldNumber();
        int n3 = user.getChildNumber();
        int[] nn = {n1,n2,n3};
        int maxLen = n1 + n2 + n3;
        String[][] cmenu = new String[maxLen + 1][1];
        int id=0;
        cmenu[id++][0] = "Я заполнил данные на всех участников!";

        HashMap<String, EnsuredType> all = user.getEnsured();  // это все уже заполненные
        dumpEnsured(all);

        String currentKey = user.getEnsuredCurrentKey();  // текущий пользователь ( id:рожа: )
        String  currentUser;
        if(currentKey== null) {
            currentKey="?";
            currentUser="? ? ? ?";
        }
        else {
            currentUser = r.getMessage().getText();  // данные о текущем пользователе ( FN LN BD DOC );
        }
        log.trace("currentKey:{"+currentKey+"}");
        log.trace("currentUser:{"+currentUser+"}");
//        EnsuredType us = all.get("1:"+Age.get[0]+":");

        String tail = " Не заполнено";
//        ---- зрелые
        for (int tuk=0;tuk<3;tuk++) {     // цикл по трем возрастным группам
            for (int tik = 1; tik < nn[tuk]+1; tik++)  {
                if(currentKey.contains(tik+":"+Age.get[tuk])) {  // это строка по текущему пользователю
                    cmenu[id++][0] = "" + tik + ":"+Age.get[tuk]+": " + currentUser;
                }
                else if (all.get(tik+":"+Age.get[tuk]+":")!= null) {   // запись заполнена в списке страхуемых
                    EnsuredType men = all.get(tik+":"+Age.get[tuk]+":");
                    cmenu[id++][0] = tik+":"+Age.get[tuk]+": " + men.toString();
                }
                else {                                            // не заполненная строка
                    cmenu[id++][0] = "" + tik + ":"+Age.get[tuk]+": " + tail;
                }
            }

        }
    return cmenu;
    }

    private void dumpEnsured(HashMap<String, EnsuredType> all) {
        for(String key : all.keySet()) {
            log.trace("key="+" страхуемый="+ all.get(key));
        }
    }
}
