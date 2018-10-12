package mvn.tgBot.tgControl;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 06/03/16
 * Time: 18:36
 */
public class ReplayMarkup {
    String [][] keyboard;
    boolean resize_keyboard;
    boolean one_time_keyboard;
    boolean hide_keyboard;

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

    public boolean isHide_keyboard() {
        return hide_keyboard;
    }

    public void setHide_keyboard(boolean hide_keyboard) {
        this.hide_keyboard = hide_keyboard;
    }
}
