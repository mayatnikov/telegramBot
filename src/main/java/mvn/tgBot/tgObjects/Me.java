package mvn.tgBot.tgObjects;

/**
 *  ответ на на запрос getMe
 */
public class Me {
    boolean ok;
    Result result;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

}
