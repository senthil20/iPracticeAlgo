package revise.threads;

import java.io.*;
import java.net.URL;
import java.util.Comparator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;

class QueueTurnstile {

    Semaphore queueSemaphore = new Semaphore(1);
    volatile boolean lowPriorityTaskPaused = false;
    private Object notifyWait = new Object();

    public void highPriorityTaskStarts() {
        lowPriorityTaskPaused = true;
        queueSemaphore.acquireUninterruptibly();
    }

    public void highPriorityTaskEnds() {
        queueSemaphore.release();

        if (lowPriorityTaskPaused == true) {
            lowPriorityTaskPaused = false;
            notifyTasks();
        }
    }

    public void lowPriorityTaskStarts() {
        while (true) {
            if (!lowPriorityTaskPaused) break;
            waitTasks();
        }
        queueSemaphore.acquireUninterruptibly();
        lowPriorityTaskPaused = false;
    }

    public void lowPriorityTaskEnds() {
        lowPriorityTaskPaused = false;
        queueSemaphore.release();
    }

    private void waitTasks() {
        synchronized (notifyWait) {
            try {
                notifyWait.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void notifyTasks() {
        synchronized (notifyWait) {
            notifyWait.notify();
        }
    }
}

class Job implements Runnable {

    String jobName;
    String URL = "";
    int priority; //1 being the highest
    QueueTurnstile queueTurnstile;

    Job(String jobName, String url, int priority, QueueTurnstile queueTurnstile) {
        this.jobName = jobName;
        this.URL = url;
        this.priority = priority;
        this.queueTurnstile = queueTurnstile;
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

        FileOutputStream fos = new FileOutputStream("C:\\" + jobName + ".pdf");

        byte[] buffer = new byte[4096];
        int bytesRead = 0;

        if (this.priority == 1) {
            queueTurnstile.highPriorityTaskStarts();
            while ((bytesRead = is.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            queueTurnstile.highPriorityTaskEnds();
        } else {
            queueTurnstile.lowPriorityTaskStarts();
            while ((bytesRead = is.read(buffer)) != -1) {
                while (true) {
                    if (!queueTurnstile.lowPriorityTaskPaused) {
                        fos.write(buffer, 0, bytesRead);
                    } else if ((bytesRead = is.read(buffer)) == -1) {
                        break;
                    }
                }
            }
            queueTurnstile.lowPriorityTaskEnds();
        }
        fos.close();
        is.close();
    }
}

class QueueExecutor {

    private int QUEUE_SIZE = 10;
    private int POOL_SIZE = 5;

    private ExecutorService priorityJobPoolExecutor;

    private PriorityBlockingQueue<Job> priorityQueue = new PriorityBlockingQueue<Job>(
            QUEUE_SIZE,
            new Comparator<Job>() {
                @Override
                public int compare(Job o1, Job o2) {
                    return o1.priority - o2.priority;
                }
            });

    public void addJob(Job job) {
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


public class QueueSchedulerMain {

    QueueTurnstile queueTurnstile = new QueueTurnstile();
    QueueExecutor queueExecutor = new QueueExecutor();

    public static void main(String a[]) {
        new QueueSchedulerMain().execute();
    }

    public void execute() {

        String url = "http://unec.edu.az/application/uploads/2014/12/pdf-sample.pdf";
        url = "http://stackoverflow.com/";

        Job job1 = new Job("J1", url, 3, queueTurnstile);
        Job job2 = new Job("J2", url, 1, queueTurnstile);
        Job job3 = new Job("J3", url, 2, queueTurnstile);
        Job job4 = new Job("J4", url, 5, queueTurnstile);
        Job job5 = new Job("J5", url, 3, queueTurnstile);
        Job job6 = new Job("J6", url, 1, queueTurnstile);
        Job job7 = new Job("J7", url, 4, queueTurnstile);

        queueExecutor.addJob(job1);
        queueExecutor.addJob(job2);
        queueExecutor.addJob(job3);
        queueExecutor.addJob(job4);
        queueExecutor.addJob(job5);

        queueExecutor.executeQueue();
    }
}