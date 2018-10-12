package mvn.tgBot.tgControl;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 06/03/16
 * Time: 18:33
 */
public class MessageBody {
    Long chat_id;
    String text;
    ReplayMarkup reply_markup;
    ParseMode parse_mode;

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

    public ReplayMarkup getReply_markup() {
        return reply_markup;
    }

    public void setReply_markup(ReplayMarkup reply_markup) {
        this.reply_markup = reply_markup;
    }

    public ParseMode getParse_mode() {
        return parse_mode;
    }

    public void setParse_mode(ParseMode parse_mode) {
        this.parse_mode = parse_mode;
    }
}
