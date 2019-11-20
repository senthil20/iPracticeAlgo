package Revise.threads;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Comparator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class SimpleThread {

    class QueueExecutorThread {

        private int QUEUE_SIZE = 10;
        private int POOL_SIZE = 10;

        private ExecutorService priorityJobPoolExecutor;

        private PriorityBlockingQueue<QueueJob> priorityQueue = new PriorityBlockingQueue<QueueJob>(
                QUEUE_SIZE,
                new Comparator<QueueJob>() {
                    @Override
                    public int compare(QueueJob o1, QueueJob o2) {
                        return o2.priority - o1.priority;
                    }
                });

        public void addJob(QueueJob job) {
            priorityQueue.add(job);
        }

        public void executeQueue() {

            priorityJobPoolExecutor = Executors.newFixedThreadPool(POOL_SIZE);

            while (!priorityQueue.isEmpty()) {
                try {
                    priorityJobPoolExecutor.execute(priorityQueue.take());
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }

    class QueueJob implements Runnable {

        String jobName;
        String URL = "";
        int priority;

        QueueJob(String jobName, String url, int priority) {
            this.jobName = jobName;
            this.URL = url;
            this.priority = priority;
        }

        @Override
        public void run() {
            System.out.println("Job: " + jobName + " Priority: " + priority);
            try {
                download();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void download() throws Exception {


            URL url = new URL(URL);
            InputStream is = url.openStream();

            FileOutputStream fos = new FileOutputStream(new File("F:\\test" + jobName + "Output.txt"));

            byte[] buffer = new byte[4096];
            int bytesRead = 0;

            while ((bytesRead = is.read(buffer)) != -1) {
                if (this.priority != 1) {
                    Thread.sleep(5000);
                }
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("Executed Thread: " + this.jobName + ", Priority: " + this.priority);

            fos.close();
            is.close();
        }
    }

    QueueExecutorThread queueExecutor = new QueueExecutorThread();

    public static void main(String a[]) {
        new SimpleThread().execute();
    }

    public void execute() {

        String url = "http://unec.edu.az/application/uploads/2014/12/pdf-sample.pdf";
        url = "http://stackoverflow.com/";

        QueueJob job1 = new QueueJob("J1", url, 3);
        QueueJob job2 = new QueueJob("J2", url, 2);
        QueueJob job3 = new QueueJob("J3", url, 4);
        QueueJob job4 = new QueueJob("J4", url, 1);
        QueueJob job5 = new QueueJob("J5", url, 3);
        QueueJob job6 = new QueueJob("J6", url, 1);
        QueueJob job7 = new QueueJob("J7", url, 7);

        queueExecutor.addJob(job1);
        queueExecutor.addJob(job2);
        queueExecutor.addJob(job3);
        queueExecutor.addJob(job4);
        queueExecutor.addJob(job5);
        queueExecutor.addJob(job6);
        queueExecutor.addJob(job7);

        queueExecutor.executeQueue();
    }

}
