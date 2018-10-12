package mvn.tgBot.utils;


import mvn.tgBot.db.UnknownUser;
import mvn.tgBot.db.UnknownUserRepository;
import mvn.tgBot.db.User;
import mvn.tgBot.db.UserRepository;
import mvn.tgBot.tgObjects.From;
import mvn.tgBot.tgObjects.Result;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckNewUser {

    private Log log = LogFactory.getLog(CheckNewUser.class);

    @Autowired
    private UserRepository db;
    @Autowired
    UnknownUserRepository xdb;

    public User proc(Long chatId, Result r) {
        if(db!=null) {
            User us = db.findByChatId(chatId);
            if(us==null) {
                log.info("Lets remember it");
                UnknownUser xuser = xdb.findByChatId(chatId);
                if(xuser == null) rememberIt(r);
                us = new User();
                us.setNewUser(true);
                us.setId("t"+r.getMessage().getChat().getId());
                us.setChatId(r.getMessage().getChat().getId());
                us.setUserName(r.getMessage().getFrom().getUsername());
                us.setFirstName(r.getMessage().getFrom().getFirst_name());
                us.setLastName(r.getMessage().getFrom().getLast_name());
            }
            else us.setNewUser(false);
            return us;
        }
        return null;
    }

//
    private void rememberIt(Result r) {
        Long chatId = r.getMessage().getChat().getId();
        From from = r.getMessage().getFrom();

        UnknownUser xUser = new UnknownUser(chatId,from.getFirst_name(), from.getLast_name(), from.getUsername(), chatId);
        xdb.save(xUser);
        log.info("New X user:" + from.getUsername() + " chatId=" + chatId);
    }
}

