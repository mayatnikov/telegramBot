package mvn.tgBot.processControll;

import mvn.abby.PassportProcessor;
import mvn.tgBot.db.EnsuredType;
import mvn.tgBot.db.User;
import mvn.tgBot.tgControl.Messenger;
import mvn.tgBot.tgObjects.Photo;
import mvn.tgBot.tgObjects.Result;
import mvn.tgBot.utils.Regexp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 07/03/16
 * Time: 09:05
 */
@Service
public class PhotoProcessor  {

    @Autowired
    Messenger tgbot;


    @Value("${tg.url}/file/${tg.bot}:${tg.token}/")
    String httpAddress;

    @Value("${abbyy.applicationId}")
    String applicationId;
    @Value("${abbyy.url}")
    String abbyyURL;
    @Value("${abbyy.password}")
    String abbyPassword;

//    https://api.telegram.org/file/bot<token>/<file_path>

    private Log log = LogFactory.getLog(PhotoProcessor.class);

    @Async
 public Future<String> process(User user, Result r) {

        Long chatId = user.getChatId();
        tgbot.sendText(chatId,"старт сканирования...");
        String wait4Stage = user.getWait4Stage();
        log.debug("Photo request from stage:"+ wait4Stage);
        if (!wait4Stage.equals("s1-24a")) {
            tgbot.sendText(user.getChatId(),"фото обрабатываются только на стадии ввода данных тех кто будет застрахован!");
            return new AsyncResult<String>("bad");
        }

// ----------------- обработка фото
        FileInfo fileInfo = findBiggestImage(r.getMessage().getPhoto());
        log.debug("File id:" + fileInfo.nm );

        String fileLink =  tgbot.getFileLink(fileInfo.nm);
        log.debug("fileLink:"+fileLink);

//     PassportProcessor passportProcessor = new PassportProcessor();
     PassportProcessor passportProcessor = new PassportProcessor(abbyyURL,applicationId, abbyPassword);
     String UrlStr = httpAddress + fileLink;
        try {
            URL url = new URL(UrlStr);
            long fsz = fileInfo.sz;
            int fszi = (int) fsz;
            EnsuredType men = passportProcessor.performMrzRecognition(fszi, url);
            String year=  men.getBirthday().substring(0,2);
            String mon=  men.getBirthday().substring(2,4);
            String day=  men.getBirthday().substring(4,6);
            String birthday = Regexp.filterDate(day+"/"+mon+"/"+year);
            String[][] menu = new String[1][1];
            menu[0][0] = men.getFirstName()+" "+men.getLastName()+" "+birthday+" "+men.getPasport();

            tgbot.sendMenuON(user.getChatId(), "скан паспорта",menu );

        } catch (MalformedURLException e) {
            log.error(e.getMessage());
            tgbot.sendText(chatId,"Ошибка обмена с сервером обработки изображений - Сервер обработки изображений временно не доступен. Повторите попытку позднее или воспользуйтесь ручным вводо");
        } catch (NullPointerException e) {
            log.error(e.getMessage());
            tgbot.sendText(chatId,"Ошибка при распознавании изображения - Не удалось распознать изображение. Попробуйте использовать другую фотографию.");
        } catch (Exception e) {
            log.error(e.getMessage());
            tgbot.sendText(chatId,"Ошибка ообработки изображения");
        }
     return new AsyncResult<String>("ok");
    }

   private FileInfo findBiggestImage(List<Photo> photos) {

       String fileId="";
       Long sz=0L;
       for(Photo photo :photos) {
           Long sz2 = photo.getFile_size();
           if(sz2>sz) {
               sz = sz2;
               fileId =  photo.getFile_id();
           }
       }
       return new FileInfo(fileId,sz);
   }

  class FileInfo {
      public String nm;
      public Long sz;

      public FileInfo(String nm,Long sz) {
          this.nm =nm;
          this.sz= sz;
      }

  }


}
