package mvn.tgBot.processControll;

import mvn.tgBot.db.EnsuredType;
import mvn.tgBot.db.User;
import mvn.tgBot.tgObjects.Result;
import mvn.tgBot.utils.Regexp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

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
                "замечание: 1_*)-взрослые 2_*)-пожилые 3_*)-дети ";
        descr = "данные застрахованных";
    }

    String msg2 = "Для каждого укажите \nимя и фамилию на латинице, дату рождения, номер паспорта \nв таком формате:\n IVAN IVANOV 25.05.1985 745865452\n";


    @Override
    public void process(User user, Result r) throws StageNotFoundException {
        String txt = r.getMessage().getText().toUpperCase();
        Long chatId = user.getChatId();
        String nStage = nextStageName;
        if (txt.contains("ЗАПОЛНИЛ")) {
            if(user.getEnsured().get("1_0")!=null ) user.setPassport(user.getEnsured().get("1_0").getPasport());  // запомнить номер паспорта
            nStage = "s1-25";
        }
        else {
            // в запросе по нажатой кнопке должен быть индекс участника вида 1.2) .....
            // выделим его и сформируем key = i1_i2
            String[] data = regexp.filterIndexCol(txt);
            user.setEnsuredCurrentKey(data[0] + "_" + data[1]);  // сохр текущий индекс в профиле клиента
            nStage = "s1-24a";
        }
        StageInt next = stageList.getStage(nStage);
        user.setWait4Stage(nStage);     // запомнить след шаг для данного ChatID
        next.sendMessage(user, r);     // отправить сообщение от следующей стадии обработки
        db.save(user);
    }

    //        отправить сообщение клиенту
//        используется из стадии предыдущей этой
    @Override
    public void sendMessage(User user, Result r) {

        // @TODO поставить ограничение по максимальному количеству людей !
        String[][] cmenu = generateMenu(user);
        Long chatId = user.getChatId();
        tgbot.sendMenuON(chatId, msg, cmenu);
    }

    // создание меню на основе накопленных данных
    private String[][] generateMenu(User user) {
        log.debug("start create menu");
        StringBuffer sb = new StringBuffer();
        sb.append(msg2);
        sb.append("\n");
        int n1 = user.getEnsuredNumber();
        int n2 = user.getOldNumber();
        int n3 = user.getChildNumber();
        int maxLen = n1 + n2 + n3;
        log.debug("number of humans in request=" + maxLen);
        String[][] cmenu = new String[maxLen + 1][1];
        cmenu[0][0] = "Я заполнил данные на всех участников!";

        int id = 1;
        try {
            HashMap<String, EnsuredType> hm = user.getEnsured();
            List<String> l1 = new ArrayList();
            List<String> l2 = new ArrayList();
            List<String> l3 = new ArrayList();
            // сформировать список заполненных строк
            if (hm != null)
                for (String key : hm.keySet()) {
                    EnsuredType human = hm.get(key);
                    if (human != null) {
                        String age = (human.getAge() == null) ? "1_0" : human.getAge();
                        String fname = (human.getFirstName() == null) ? "_____" : human.getFirstName();
                        String lname = (human.getLastName() == null) ? "____" : human.getLastName();
                        String bd = (human.getBirthday() == null) ? "____" : human.getBirthday();
                        String doc = (human.getPasport() == null) ? "____" : human.getPasport();
                        String stmp = age + ") "+lname+" "+fname+" "+bd+" "+doc;
                        log.trace("item for menu=" + stmp);
                        boolean canAdd = false;
                        if (age.startsWith("1")) {
                            l1.add(stmp);
                        } else if (age.startsWith("2")) {
                            l2.add(stmp);
                        } else if (age.startsWith("3")) {
                            l3.add(stmp);
                        }
                    }
                }
            // -- end if
// заполнить строки меню
            String tail = ") не заполнено";
            {
                log.trace("id=" + id + " n1=" + n1);
                Iterator<String> it = l1.iterator();
                for (int tik = 0; tik < n1; tik++) {
                    if (it.hasNext()) cmenu[id++][0] = it.next();
                    else cmenu[id++][0] = "1_" + tik + tail;
                    log.trace(cmenu[id - 1][0]);
                }
            }
            {
                log.trace("id=" + id + " n2=" + n2);
                Iterator<String> it = l2.iterator();
                for (int tik = 0; tik < n2; tik++) {
                    if (it.hasNext()) cmenu[id++][0] = it.next();
                    else cmenu[id++][0] = "2_" + tik + tail;
                    log.trace(cmenu[id - 1][0]);
                }
            }
            {
                log.trace("id=" + id + " n3=" + n3);
                Iterator<String> it = l3.iterator();
                for (int tik = 0; tik < n3; tik++) {
                    if (it.hasNext()) cmenu[id++][0] = it.next();
                    else cmenu[id++][0] = "3_" + tik + tail;
                    log.trace(cmenu[id - 1][0]);
                }
            }
        } catch (IndexOutOfBoundsException e) {
            log.error(e.getMessage());
        }
    return cmenu;
    }
}
