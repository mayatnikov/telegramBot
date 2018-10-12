package mvn.tgBot.processControll;

import mvn.tgBot.db.User;
import mvn.tgBot.tgObjects.Result;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 17/02/16
 * Time: 21:35
 * интерфейс - стадия обработки бизнес процесса
 */

public interface StageInt {
    String getName();
    void process(User user, Result r) throws StageNotFoundException;
    void sendMessage(User user, Result r);
}
