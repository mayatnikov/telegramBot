package mvn.tgBot.tgExchange;

import mvn.tgBot.tgObjects.Result;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 18/11/15
 * Time: 17:10
 */
public class ResponseToSend {
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
