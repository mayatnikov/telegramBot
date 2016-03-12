package mvn.tgBot.tgExchange;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 19/11/15
 * Time: 13:54
 */
public class Reply_markup {
    String[][] keyboard;
    boolean resize_keyboard;
    boolean one_time_keyboard;


    public Reply_markup(String[][] keyboard, boolean resize_keyboard, boolean one_time_keyboard) {
        this.keyboard = keyboard;
        this.resize_keyboard = resize_keyboard;
        this.one_time_keyboard = one_time_keyboard;
    }

    public String[][] getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(String[][] keyboard) {
        this.keyboard = keyboard;
    }

    public boolean isResize_keyboard() {
        return resize_keyboard;
    }

    public void setResize_keyboard(boolean resize_keyboard) {
        this.resize_keyboard = resize_keyboard;
    }

    public boolean isOne_time_keyboard() {
        return one_time_keyboard;
    }

    public void setOne_time_keyboard(boolean one_time_keyboard) {
        this.one_time_keyboard = one_time_keyboard;
    }
}
