package mvn.tgBot.soap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.xxx.model.common.MessageHeaderType;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 13/02/16
 * Time: 22:24
 */


@Component
public class TgMessageHeader  {
    private Log log = LogFactory.getLog(TgMessageHeader.class);

    @Value("${soap.user}")
    String user;

    @Value("${soap.password}")
    String password;

    private final AtomicLong counter = new AtomicLong();

    public TgMessageHeader() {
        log.debug("created");
    }

    public MessageHeaderType getHeader() {
        MessageHeaderType  hdr = new MessageHeaderType();
            hdr.setUser(user);
            hdr.setPassword(password);
            log.debug("p="+user+"/"+password);
        hdr.setIntegrationID("tg-"+System.currentTimeMillis()+"-"+counter.incrementAndGet());
        return hdr;
    }
}
