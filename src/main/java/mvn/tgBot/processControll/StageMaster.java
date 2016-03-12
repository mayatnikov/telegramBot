package mvn.tgBot.processControll;

import mvn.tgBot.db.User;
import mvn.tgBot.db.UserRepository;
import mvn.tgBot.tgControl.Messenger;
import mvn.tgBot.tgObjects.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 17/02/16
 * Time: 21:44
 * Общий класс описания стадии обработки
 */
public class StageMaster  implements StageInt {

    String name;
    String nextStageName;
    String msg;
    String descr;


    @Autowired UserRepository db;
    @Autowired StageList stageList;
    @Autowired Messenger tgbot;

    public String toString() { return name; }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void process(User user, Result r) throws StageNotFoundException {

    }

    @Override
    public void sendMessage(User user, Result r) {

    }
}