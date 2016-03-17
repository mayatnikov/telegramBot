package mvn.tgBot.tgObjects;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 10/03/16
 * Time: 17:52
 */
public class GetFileResult {
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
