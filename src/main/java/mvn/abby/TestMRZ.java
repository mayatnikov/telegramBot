package mvn.abby;

import com.abbyy.ocrsdk.Client;
import com.abbyy.ocrsdk.Task;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class TestMRZ {

    Client restClient;

    public static void main(String[] args) throws Exception {

        System.out.println("Process documents using ABBYY Cloud OCR SDK.\n");
        TestMRZ mrz = new TestMRZ();
//        mrz.performMrzRecognition("../../INFO/MRZ/passport.jpg", "result.xml");
        mrz.performMrzRecognition("../../INFO/MRZ/passport.jpg");

    }


    public  TestMRZ() {
        restClient = new Client();
        // replace with 'https://cloud.ocrsdk.com' to enable secure connection
        restClient.serverUrl = "http://cloud.ocrsdk.com";
        restClient.applicationId = "TelegramBot";
        restClient.password = "HIgPzV0l0e6UJ9kLW9qayrS+";
    }


    private void performMrzRecognition(String in)
            throws Exception {

        Task task = restClient.processMrz( in );
        System.out.println("waitForCompletion");
        task = waitForCompletion(task);

        if (task.Status == Task.TaskStatus.Completed) {
            ResultFields res = new ResultFields(getInput(task));
            System.out.println(res.getFieldByType("LastName"));

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
           Thread.sleep(2500);
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
