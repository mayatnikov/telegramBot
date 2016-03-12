package mvn.tgBot.utils;


import mvn.tgBot.tgControl.Messenger;
import mvn.tgBot.tgObjects.Me;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
public class CheckTelegram implements CommandLineRunner {

    private Log log = LogFactory.getLog(CheckTelegram.class);

    @Autowired
    Messenger messanger;
    @Autowired
    Pojo2Json pojo2Json;
    @Value("${vitaly}")
    Long chatId;

    public void run(String... args) {
        ResponseEntity<Me> i_am = messanger.echoMe();
        Me me = i_am.getBody();
        String fname = me.getResult().getFirst_name();

        if (!fname.equals("RobotMayatnikov")) log.error("It is not MayatnikovRobot!");
        else log.info("Check Robot first name:" + fname + "<---------OK");

        String hello = "Bot:" + fname + " start o restart\n *Привет!*\n я запустился!";
        messanger.sendMardown(chatId, hello);
    }
}
