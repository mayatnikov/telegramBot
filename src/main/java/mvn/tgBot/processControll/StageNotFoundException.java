package mvn.tgBot.processControll;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 17/02/16
 * Time: 22:15
 *  стадия не найдена в списке стадий обработки - КРИВОЙ СЦЕНАРИЙ
 */
public class StageNotFoundException extends Exception  {
    public StageNotFoundException() { super(); }
    public StageNotFoundException(String message) { super(message); }
    public StageNotFoundException(String message, Throwable cause) { super(message, cause); }
    public StageNotFoundException(Throwable cause) { super(cause); }
}

