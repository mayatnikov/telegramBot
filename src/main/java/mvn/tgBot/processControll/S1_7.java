package mvn.tgBot.processControll;

import mvn.tgBot.db.RegionType;
import mvn.tgBot.db.User;
import mvn.tgBot.tgObjects.Result;
import mvn.tgBot.utils.CheckDates;
import mvn.tgBot.utils.Regexp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 17/02/16
 * Time: 22:46
 * Stage: ввод даты возврата
 */
@Component
public class S1_7 extends StageMaster implements StageInt {

    @Autowired  Regexp regexp;
    @Autowired CheckDates checkDates;

    private Log log = LogFactory.getLog(S1_7.class);

    public S1_7() {
        name = "s1-7";
        nextStageName=""; // специально так как переход условно на разные шаги
        msg =  "Когда возвращаетесь? \n" +
                "Введите дату в виде ДД/ММ/ГГГГ";
        descr="дата возврата";
    }
    String errMessage="Ошибка при вводе даты окончания: " +
            "период страхования не может превышать 90 дней";
    @Override
    public void process(User user, Result r) throws StageNotFoundException {
        String txt = r.getMessage().getText().toUpperCase();
        Long chatId = user.getChatId();
        String dateStart = user.getDateFrom();
        String dateStop = regexp.filterDate(txt);

        try {
            if( checkDates.checkDateStop(dateStart,dateStop) ) {
                String stg;
                user.setDateTo(dateStop);                        // !!!!!!

    // Определение следующего stage по региону и стране

                if(user.getRegionType()!= null && user.getRegionType().equals(RegionType.SHENGEN))
                    stg= "s1-10"; // на ввод число взрослых при финляндии и шенген
                else if(user.getCountryName()!= null && user.getCountryName().toUpperCase().contains("ФИНЛЯН"))
                    stg="s1-8"; // <----ввод даты по Финляндии
                else
                    stg = "s1-11";     // на ввод число взрослых при НЕ финляндии и НЕ шенген

                StageInt next = stageList.getStage(stg);
                next.sendMessage(user,r);     // отправить сообщение от следующей стадии обработки
                user.setWait4Stage(stg);     // на ввод даты для посольства Финляндии
            }
            else {
                log.error("stage:"+name+" ошибка ввода:"+txt);
                tgbot.sendText(chatId, "stage:"+descr+" cmd:"+txt+" - ошибка в формате или превышение допустимого периода 90 дней!");
            }
        } catch (ParseException e) {
            // сообщение о ошибке ввода
            e.printStackTrace();
        }
        db.save(user);
    }

    //        отправить сообщение клиенту
//        используется из стадии предыдущей этой
    @Override
    public void sendMessage(User user, Result r) {
        Long chatId = user.getChatId();
        tgbot.sendMenuOff(chatId,msg);
    }
}

