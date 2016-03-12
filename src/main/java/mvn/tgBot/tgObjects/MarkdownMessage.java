package mvn.tgBot.tgObjects;

import mvn.tgBot.utils.Pojo2Json;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 23/11/15
 * Time: 20:48
 */
public class MarkdownMessage {
    Long chat_id;
    String text;
    String parse_mode;

    @Autowired
    private Pojo2Json pojo2Json;


    public Long getChat_id() {
        return chat_id;
    }

    public void setChat_id(Long chat_id) {
        this.chat_id = chat_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getParse_mode() {
        return parse_mode;
    }

    public void setParse_mode(String parse_mode) {
        this.parse_mode = parse_mode;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        if(chat_id!=null) sb.append("\"chat_id\":"+chat_id);
        if(text!=null) sb.append(",\"text\":\""+text+"\"");
        if(parse_mode!=null) sb.append(",\"parse_mode\":\""+parse_mode+"\"");
        sb.append("}");
        return (sb.toString());
    }

    public String toJson() {                    // !! не работает
        return pojo2Json.getStr(this);
    }

    public MarkdownMessage() {}
    public MarkdownMessage(Long chatId,String msg) {
        chat_id = chatId;
        text=msg;
        parse_mode="Markdown";
    }

}
