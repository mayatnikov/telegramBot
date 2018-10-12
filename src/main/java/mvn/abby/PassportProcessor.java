package mvn.abby;

import com.abbyy.ocrsdk.Client;
import com.abbyy.ocrsdk.Task;
import mvn.tgBot.db.EnsuredType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


public class PassportProcessor {
    private Log log = LogFactory.getLog(PassportProcessor.class);

    Client restClient;

    public PassportProcessor() {
        restClient = new Client();
        // replace with 'https://cloud.ocrsdk.com' to enable secure connection
        restClient.serverUrl = "http://cloud.ocrsdk.com";
        restClient.applicationId = "TelegramBot";
        restClient.password = "xxxxxxxgxxxxxxxxxxxxxxxxx";
    }

    public PassportProcessor(String surl,String appId,String passwd) {
        restClient = new Client();
        // replace with 'https://cloud.ocrsdk.com' to enable secure connection
        restClient.serverUrl = surl;  // "http://cloud.ocrsdk.com";
        restClient.applicationId = appId;
        restClient.password = passwd;
    }


    public EnsuredType performMrzRecognition(int imageSize, URL url) throws Exception {

        Task task = restClient.processMrz(imageSize,  url );
        log.debug("waitForCompletion");
        task = waitForCompletion(task);   //  ЖДЕМ
        EnsuredType men = new EnsuredType();

        if (task.Status == Task.TaskStatus.Completed) {
            ResultFields res = new ResultFields(getInput(task));
            String verified = res.getFieldByType("DocumentNumberVerified");
            if(verified.equals("true")) {
                log.trace("LN:" + res.getFieldByType("LastName"));
                men.setLastName(res.getFieldByType("LastName"));
                log.debug("FN:" + res.getFieldByType("GivenName"));
                men.setFirstName(res.getFieldByType("GivenName"));
                log.debug("BD:" + res.getFieldByType("BirthDate"));
                men.setBirthday(res.getFieldByType("BirthDate"));
                log.debug("DOC:" + res.getFieldByType("DocumentNumber"));
                men.setPasport(res.getFieldByType("DocumentNumber"));
            }
            else throw new Exception("Ошибка при распознавании изображения - Не удалось распознать изображение. Попробуйте использовать другую фотографию.");

        } else if (task.Status == Task.TaskStatus.NotEnoughCredits) {
            log.error("Not enough credits to process document. Please add more pages to your application's account.");
            throw new Exception("Not enough credits to process document. Please add more pages to your application's account.");
        } else {
            log.error("performMrzRecognition Task failed");
            throw new Exception("performMrzRecognition Task failed");
        }
        return men;
    }
 /*

"Ошибка обмена с сервером обработки изображений" - "Сервер обработки изображений временно не доступен. Повторите попытку позднее или воспользуйтесь ручным вводо"
"Ошибка при распознавании изображения" - "Не удалось распознать изображение. Попробуйте использовать другую фотографию."
  */
    /**
     * Wait until task processing finishes
     */
    private Task waitForCompletion(Task task) throws Exception {

        while (task.isTaskActive()) {
           Thread.sleep(5000);
            log.debug("Waiting..");
            task = restClient.getTaskStatus(task.Id);
        }
        return task;
    }

    public InputStream getInput(Task task) throws Exception {
        if (task.Status != Task.TaskStatus.Completed) {
            throw new IllegalArgumentException("Invalid task status");
        }

        if (task.DownloadUrl == null) {
            throw new IllegalArgumentException( "Cannot download result without url");
        }

        log.debug("download URL:"+task.DownloadUrl);
        URL url = new URL(task.DownloadUrl);
        URLConnection connection = url.openConnection();
        // !!!!! do not use  authenticated  connection
       return   connection.getInputStream();
    }
}