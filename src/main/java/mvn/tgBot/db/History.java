package mvn.tgBot.db;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 23/02/16
 * Time: 09:10
 */
public class History extends User{

    public void replaceId() {
        this.setId(this.getId() +(new Date().getTime()));
    }

}
