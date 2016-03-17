package mvn.tgBot.tgControl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import mvn.tgBot.tgExchange.Header;
import mvn.tgBot.tgExchange.ResponseToSend;
import mvn.tgBot.tgObjects.GetFileResult;
import mvn.tgBot.tgObjects.Updates;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


/*
http://stackoverflow.com/questions/32909653/poolinghttpclientconnectionmanager-does-not-release-connections

 */
@Component
public class Messenger {

    @Value("${tg.url}/${tg.bot}:${tg.token}/")
    String httpAddress;

    private Log log = LogFactory.getLog(Messenger.class);

    RestTemplate rest = new RestTemplate();

@Autowired Header header;


    public ResponseEntity  getFile(String fileId) {
//        ResponseEntity resp=null;
//        String body="{\"file_id\":\"" + fileId +"\"}";
//        log.trace("get photo-name from Telegram-cloud, file_id:"+fileId);
//        HttpEntity<String> request = new HttpEntity<String>(body, header);
//
//
//        String body="{\"offset\":\"" + offset +"\"}";
//        log.trace("get all messages from Telegram-cloud, offset:"+offset);
//        HttpEntity<String> request = new HttpEntity<String>(body, header);
//        resp = rest.exchange(httpAddress + "getUpdates", HttpMethod.POST, request, Updates.class);
        return null;
    }


    public ResponseEntity  getAllMessage(Long offset) {
        ResponseEntity resp=null;
        String body="{\"offset\":\"" + offset +"\"}";
        log.trace("get all messages from Telegram-cloud, offset:"+offset);
        HttpEntity<String> request = new HttpEntity<String>(body, header);
        resp = rest.exchange(httpAddress + "getUpdates", HttpMethod.POST, request, Updates.class);
        return resp;
    }

    public ResponseEntity  echoMe() {
        String command = "getMe";
        log.trace("Start:" + command);
        ResponseEntity resp;
        HttpEntity<String> request = new HttpEntity<String>(header);
        resp = rest.exchange(httpAddress + command, HttpMethod.GET, request, mvn.tgBot.tgObjects.Me.class);
        return resp;
    }

    public ResponseEntity sendText(Long id, String txt) {
        MessageBody m = new MessageBody();
        m.setChat_id(id);
        m.setText(txt);
        String mbody = pojo2Json(m);
        return (sendMessage(mbody));
    }

 /*

"\ud83d\ude25" - disappointed_relieved
  */

    static String emErr = "\ud83d\ude25 ";
    public ResponseEntity sendMistake(Long chatId, String s) {
           return  sendText(chatId,emErr + s );
    }

    public ResponseEntity sendMistake(Long chatId) {
        String msg =  emErr + "Не понял команду, выберите из доступных вариантов";
        return  sendText(chatId,msg);
    }


    public ResponseEntity  sendMardown(Long id, String markdown) {
        MessageBody m = new MessageBody();
        m.setChat_id(id);
        m.setText(markdown);
        m.setParse_mode(ParseMode.markdown);
        String mbody = pojo2Json(m);
        return (sendMessage(mbody));
    }

    public ResponseEntity  sendHtml(Long id, String htmlStr) {
        MessageBody m = new MessageBody();
        m.setChat_id(id);
        m.setText(htmlStr);
        m.setParse_mode(ParseMode.HTML);
        String mbody = pojo2Json(m);
        return (sendMessage(mbody));
    }

    public ResponseEntity sendMenuOff(Long id, String txt) {
        MessageBody m = new MessageBody();
        m.setChat_id(id);
        m.setText(txt);
        ReplayMarkup rpm = new ReplayMarkup();
        rpm.setHide_keyboard(true);
        m.setReply_markup(rpm);
        String mbody = pojo2Json(m);
        return (sendMessage(mbody));
    }

    public ResponseEntity sendMenuON(Long id, String msg, String [][] menu) {
        MessageBody m = new MessageBody();
        m.setChat_id(id);
        m.setText(msg);
        {
            ReplayMarkup rpm = new ReplayMarkup();
            rpm.setKeyboard(menu);
            rpm.setResize_keyboard(true);
            rpm.setOne_time_keyboard(false);
            m.setReply_markup(rpm);
        }
        String mbody = pojo2Json(m);
        return (sendMessage(mbody));
    }


    public String getFileLink(String fileId) {

        String body="{\"file_id\":\"" + fileId +"\"}";
        log.trace("get photo-name from Telegram-cloud, file_id:"+fileId);
        HttpEntity<String> request = new HttpEntity<String>(body, header);
        ResponseEntity resp=null;
        resp = rest.exchange(httpAddress + "getFile", HttpMethod.POST, request, GetFileResult.class);
        GetFileResult getFileResult = (GetFileResult) resp.getBody();
        String fileLink = getFileResult.getResult().getFile_path();
        log.debug("File link:"+fileLink);
        return fileLink;
    }


    private ResponseEntity  sendMessage(String msgBody) {
        String command="sendMessage";
        log.trace("Send message body:"+  msgBody);
        ResponseEntity resp=null;
        HttpEntity<String> request = new HttpEntity<String>(msgBody,header);
        resp = rest.exchange(httpAddress + command, HttpMethod.POST, request, ResponseToSend.class);
//            rest.exchange("http://localhost:8080/cgi/" + "printenv.pl", HttpMethod.POST, request, String.class);
        return resp;
    }

    private String pojo2Json(MessageBody m) {
        Gson gson = new GsonBuilder().create();          // .setPrettyPrinting()
        java.lang.String answer = gson.toJson(m);
        return answer;
    }


}
