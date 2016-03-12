package mvn.tgBot.utils;

import mvn.tgBot.db.User;
import mvn.tgBot.db.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CheckDB  implements CommandLineRunner {

    private Log log = LogFactory.getLog(CheckDB.class);

    @Value("${vitaly}")
    Long vitaly;

    @Value("${db.create}")
    boolean createDb;


    @Autowired
    private UserRepository db;

//    @Override
    public void run(String... args) throws Exception {

// @TODO переделать процедуру проверки работоспособности БД
//       if(createDb)     restoreDb();                             //      !!!!!!  Очистка БД !!!!!!!!
//        for (User user : this.db.findAll()) {
//            log.debug(user);
//            if(user.getCard()!=null) {
//                for (Card card : user.getCard()) {
//                    log.debug(card.getCn());
//                }
//            }
//        }
        Long vitaly =    113724846L;
        User us1 = this.db.findByChatId(vitaly); // vitaly
        if(us1!=null) {
            log.debug("FindUserByChatId=" + us1);
            String fname = us1.getFirstName();
            log.debug("DB-Find user by chatId:(" + vitaly + ")=>" + fname);
        }
    }

  public void restoreDb() {


    }
}
