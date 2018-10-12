package mvn.tgBot.utils;

import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 22/11/15
 * Time: 12:14
 */
@Component
public class Sequancer {

    private Long seq;

    public Sequancer() {
        seq =new Long(0);
    }

    public Long getNext() {
        if( seq ==null) { seq = new Long(0); }
        seq++;
        return seq;
    }
}
