package mvn.abby;

import com.abbyy.ocrsdk.Client;
import com.abbyy.ocrsdk.Task;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class PassportProcessor {

    Client restClient;

    public static void main(String[] args) throws Exception {

        System.out.println("Process documents telegram-->AbbyOCR.\n");
        PassportProcessor mrz = new PassportProcessor();

//        mrz.performMrzRecognition("../../INFO/MRZ/passport.jpg", "result.xml");

//        mrz.performMrzRecognition("../../INFO/MRZ/passport.jpg");

        int sz = 144092;
        String surl="https://api.telegram.org/file/bot110712323:AAFopijizY0vAkYvze-LwHLMgNWzdx_ekRg/photo/file_5.jpg";

        /*
                     https://api.telegram.org/file/bot110712323:AAFopijizY0vAkYvze-LwHLMgNWzdx_ekRg/photo/file_7.jpg
         */
        URL url = new URL(surl);
        mrz.performMrzRecognition(sz,url);
    }


    public PassportProcessor() {
        restClient = new Client();
        // replace with 'https://cloud.ocrsdk.com' to enable secure connection
        restClient.serverUrl = "http://cloud.ocrsdk.com";
        restClient.applicationId = "TelegramBot";
        restClient.password = "HIgPzV0l0e6UJ9kLW9qayrS+";
    }

    private void performMrzRecognition(int imageSize, URL url) throws Exception {

        Task task = restClient.processMrz(imageSize,  url );
        System.out.println("waitForCompletion");
        task = waitForCompletion(task);   //  ЖДЕМ

        if (task.Status == Task.TaskStatus.Completed) {
            ResultFields res = new ResultFields(getInput(task));
            System.out.println(res.getFieldByType("LastName"));
            System.out.println(res.getFieldByType("GivenName"));
            System.out.println(res.getFieldByType("BirthDate"));
            System.out.println(res.getFieldByType("DocumentNumber"));


        } else if (task.Status == Task.TaskStatus.NotEnoughCredits) {
            System.out.println("Not enough credits to process document. Please add more pages to your application's account.");
        } else {
            System.out.println("Task failed");
        }
    }

    private void performMrzRecognition(String fileName)
            throws Exception {

        Task task = restClient.processMrz( fileName );
        System.out.println("waitForCompletion");
        task = waitForCompletion(task);

        if (task.Status == Task.TaskStatus.Completed) {
            ResultFields res = new ResultFields(getInput(task));
            System.out.println(res.getFieldByType("LastName"));
            System.out.println(res.getFieldByType("GivenName"));
            System.out.println(res.getFieldByType("BirthDate"));
            System.out.println(res.getFieldByType("DocumentNumber"));

        } else if (task.Status == Task.TaskStatus.NotEnoughCredits) {
            System.out.println("Not enough credits to process document. "
                    + "Please add more pages to your application's account.");
        } else {
            System.out.println("Task failed");
        }
    }


    /**
     * Wait until task processing finishes
     */
    private Task waitForCompletion(Task task) throws Exception {

        while (task.isTaskActive()) {
           Thread.sleep(5000);
            System.out.println("Waiting..");
            task = restClient.getTaskStatus(task.Id);
        }
        return task;
    }

    public InputStream getInput(Task task) throws Exception {
        if (task.Status != Task.TaskStatus.Completed) {
            throw new IllegalArgumentException("Invalid task status");
        }

        if (task.DownloadUrl == null) {
            throw new IllegalArgumentException(
                    "Cannot download result without url");
        }

        System.out.println("download URL:"+task.DownloadUrl);
        URL url = new URL(task.DownloadUrl);
        URLConnection connection = url.openConnection();
        // do not use
        // authenticated
        // connection

             return   connection.getInputStream();
    }
}
