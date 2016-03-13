package mvn.tgBot.processControll;

import mvn.tgBot.db.User;
import mvn.tgBot.tgExchange.Header;
import mvn.tgBot.tgObjects.Photo;
import mvn.tgBot.tgObjects.Result;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 07/03/16
 * Time: 09:05
 */
@Component
public class PhotoProcessor extends StageMaster {

 @Autowired
 Header header;

    @Value("${tg.url}/${tg.bot}:${tg.token}/")
    String httpAddress;

    RestTemplate rest = new RestTemplate();

    private Log log = LogFactory.getLog(PhotoProcessor.class);

//    String[][] menu = {
//            {"1","2"},
//            {"4","3"}
//    };
    String msg="Скоро фото паспорта будет обрабатываться для получения паспортных данных";

    @Override
    public void process(User user, Result r) {
//
//        ResponseEntity resp=null;
//
//        String fileId = findBiggestImage(r.getMessage().getPhoto());
//        String body="{\"file_id\":\"" + fileId +"\"}";
//        log.trace("get photo-name from Telegram-cloud, file_id:"+fileId);
//        HttpEntity<String> request = new HttpEntity<String>(body, header);
//
//        resp = rest.exchange(httpAddress + "getFile", HttpMethod.POST, request, GetFileResult.class);
//        ResponseEntity<Updates> resp = tgbot.getAllMessage(currentUpdateId);
//        Updates updates = resp.getBody();
//
//
//        if( resp.

    }

    @Override
    public void sendMessage(User user, Result r) {
        Long chatId = user.getChatId();
        tgbot.sendText(chatId,msg);
//        tgbot.sendMenuON(chatId,msg,menu);
    }

   private String findBiggestImage(List<Photo> photos) {

       String fileId="";
       Long sz=0L;
       for(Photo photo :photos) {
           Long sz2 = photo.getFile_size();
           if(sz2>sz) {
               sz = sz2;
               fileId =  photo.getFile_id();
           }
       }
       return fileId;
   }


}
