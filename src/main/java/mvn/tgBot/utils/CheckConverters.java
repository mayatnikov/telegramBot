package mvn.tgBot.utils;

import mvn.tgBot.tgObjects.MarkdownMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CheckConverters implements CommandLineRunner {

    private Log log = LogFactory.getLog(CheckConverters.class);

    @Autowired
    private Pojo2Json pojo2Json;

    @Value("${vitaly}")
    Long chatId;

    @Override
   public void run(String... args) throws Exception {

     if(pojo2Json!=null) {
         MarkdownMessage m = new MarkdownMessage();
         m.setChat_id(chatId);
         m.setParse_mode("Markdown");
         m.setText("this is test message\nsecond part of message");
         log.debug(m);
         log.debug(pojo2Json.getStr(m));

         MarkdownMessage m2 = new MarkdownMessage();
         m2.setChat_id(chatId);
         m2.setParse_mode(null);
         m2.setText("this is tes message\nsecond part of message");
         log.debug(m2);
         log.debug(pojo2Json.getStr(m2));
     }
     else log.error("Pojo2Json parser not initialized!");
   }
}

/*
@ComponentScan("mvn.tgBot")
@EnableAutoConfiguration
@Configuration
@EnableScheduling
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

 */