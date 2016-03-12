package mvn.tgBot.processControll;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 17/02/16
 * Time: 21:59
 * описание последовательности стадий обработки заявки
 */
@Component
public class StageList {
    private Log log = LogFactory.getLog(StageList.class);
    @Autowired S1_0 s1_0;
    @Autowired S1_1 s1_1;
    @Autowired S1_2 s1_2;
    @Autowired S1_3 s1_3;
    @Autowired S1_4a s1_4a;
    @Autowired S1_4b s1_4b;
    @Autowired S1_4c s1_4c;
    @Autowired S1_6 s1_6;
    @Autowired S1_7 s1_7;
    @Autowired S1_8 s1_8;
    @Autowired S1_10 s1_10;
    @Autowired S1_11 s1_11;
    @Autowired S1_12 s1_12;
    @Autowired S1_13 s1_13;
    @Autowired S1_14 s1_14;
    @Autowired S1_14a s1_14a;
    @Autowired S1_15 s1_15;
    @Autowired S1_15a s1_15a;
    @Autowired S1_16 s1_16;
    @Autowired S1_17 s1_17;
    @Autowired S1_18 s1_18;
    @Autowired S1_19 s1_19;
    @Autowired S1_20 s1_20;
    @Autowired S1_21 s1_21;
    @Autowired S1_22 s1_22;
    @Autowired S1_23 s1_23;
    @Autowired S1_24 s1_24;
    @Autowired S1_24a s1_24a;
    @Autowired S1_25 s1_25;
    @Autowired S1_26 s1_26;
    @Autowired S1_27 s1_27;
    @Autowired S1_END s1_end;

    HashMap<String,StageInt> stages;

    private void createStageSequence() {
        stages = new HashMap();
        stPut(s1_0);
        stPut(s1_1);
        stPut(s1_2);
        stPut(s1_3);
        stPut(s1_4a);
        stPut(s1_4b);
        stPut(s1_4c);
        stPut(s1_6);
        stPut(s1_7);
        stPut(s1_8);
        stPut(s1_10);
        stPut(s1_11);
        stPut(s1_12);
        stPut(s1_13);
        stPut(s1_14);
        stPut(s1_14a);
        stPut(s1_15);
        stPut(s1_15a);
        stPut(s1_16);
        stPut(s1_17);
        stPut(s1_18);
        stPut(s1_19);
        stPut(s1_20);
        stPut(s1_21);
        stPut(s1_22);
        stPut(s1_23);
        stPut(s1_24);
        stPut(s1_24a);
        stPut(s1_25);
        stPut(s1_26);
        stPut(s1_27);
        stPut(s1_end);
    }

    public StageInt getStage(String name) throws StageNotFoundException {
        if (stages == null) {
            // это первое обращение - создадим список стадий
            log.debug("start of create stage list");
            createStageSequence();
            log.debug("end of create stage list");
        }
        // найти и вернуть класс обработки стадии
        log.debug("Get stage:" + name);
        StageInt st = stages.get(name);
        if (st == null) {
            log.error("stage not found:"+name);
// @TODO Exception почему то не обрабатывается в MessageDispatcher - РАЗОБРАТЬСЯ !
            new StageNotFoundException("stage name:" + name);
        }
        return st;
    }

    private void stPut(StageInt si) {
        log.debug("Add stage:" + si.getName());
        stages.put(si.getName(), si);
    }
}
