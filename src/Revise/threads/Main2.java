package Revise.threads;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main2 {

    DoubleTurnstile dblTurnstile = new DoubleTurnstile();

    public class DoubleTurnstile{
        Semaphore  resourceSemaphore = new Semaphore(1);    // main semaphore protecting resource that has to be accessed sequentially
        volatile boolean  lowPriorRunReq    = false; // low priority task run request
        volatile boolean lowPriorPauseReq   = false; // low priority task pause request (it uses notify)
        private Object notifyWait = new Object();
        Lock       groupLock         = new ReentrantLock();  // group lock (used to acquire lowPriorRunFlag always correctly)
        volatile boolean lowPriorRunFlag = false;  // low priority task run flag

        private void myWaitNotify(){
            synchronized (notifyWait){
                try {
                    notifyWait.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        private void myNotify(){
            synchronized (notifyWait){
                notifyWait.notify();
            }
        }
        // call highPriorityLeaves() after used shared resources
        public void highPriorityEnter() {
            groupLock.lock();
            //if (lowPriorRunFlag){ // "if" is not necessary but correct
            lowPriorPauseReq = true;
            //}
            resourceSemaphore.acquireUninterruptibly();
            groupLock.unlock();
        }
        // call exactly once for each previous highPriorityEnter()
        public void highPriorityLeaves() {
            resourceSemaphore.release();
            groupLock.lock();
            if(lowPriorPauseReq == true){
                lowPriorPauseReq = false;
                myNotify();
            }
            groupLock.unlock();
        }

        public void lowPriorityLoopEnter() {
            while(true){
                if((lowPriorRunReq == true)
                        && (lowPriorPauseReq == false)) break;
                myWaitNotify();
            }
            groupLock.lock();
            resourceSemaphore.acquireUninterruptibly();
            lowPriorRunFlag = true;
            groupLock.unlock();
        }

        public boolean lowPriorityLoop_ShallEnd() {
            return (lowPriorRunReq == false)
                    || (lowPriorPauseReq == true);
        }
        public void lowPriorityLoop_Leaves() {
            lowPriorRunFlag = false;
            resourceSemaphore.release();
        }

        public void masterLowPriorityRunEn(boolean shallRun) {
            lowPriorRunReq = shallRun;
            myNotify();
        }
    }

    public class PrioritySingleTaskThread extends Thread {
        int id;
        public PrioritySingleTaskThread(int id){this.id=id;}
        @Override
        public void run() {
            prn("High Priority Task created");
            dblTurnstile.highPriorityEnter();
            accessResource("high priority task",true, id);
            dblTurnstile.highPriorityLeaves();
            prn("High Priority Task closed");
        }
    }

    public class LowPriorityContinuousThread extends Thread {
        public int id = 0;
        @Override
        public void run() {
            while(true){
                dblTurnstile.lowPriorityLoopEnter();
                accessResource("low priority init",false,id++); // here it is initialization and I want to happen only on request from priority thread
                while(true){
                    accessResource("low priority task",false,id++);
                    if(dblTurnstile.lowPriorityLoop_ShallEnd() == true){
                        accessResource("low priority de-init",false,id++); //de-initialization & I want to happen only on request from priority thread
                        dblTurnstile.lowPriorityLoop_Leaves();
                        break;
                    }

                }
            }
        }
    }

    //-------------------------------------------------------------------------
    //-- following functions are meant only for testing
    AtomicInteger clashDetector = new AtomicInteger(0); // only for testing purposes
    int hiPriorityCnt; // only for testing purposes
    int loPriorityCnt; // only for testing purposes
    int lastLowPriorityId=-1;
    int lastHiPriorityId=-1;
    int hiPriorityOutOfOrder=0;

    public void accessResource(String from,boolean hiPriority, int id) {
        prn("Resource used from " + from+" id: "+id);
        if(hiPriority){
            if( (id - lastHiPriorityId) < 1) {
                // note if id - lastHiPriorityId=+2 (one sample over-jumped) it will be detected
                // when returned to the over-jumped sample,
                // or at the end of the test one sample missing will be detected
                // so no injustice will escape it's punishment ;)
                // On the other hand if we want strictly ==1 then one error will be reported 3 times -
                // 1st when ID: 1->3
                // 2nd when ID: 3->2 // correct error
                // 3rd when ID: 2->4
                System.out.println("High priority jumped over each other - it's not nice but it can happen");
                hiPriorityOutOfOrder++;
            }
            lastHiPriorityId = id;
            hiPriorityCnt++;
        }
        else{
            if( (id - lastLowPriorityId) < 1) {
                System.out.println("LowPriorityLoop request swapped - you are a bad programmer :((((((");
                System.exit(-1);
            }
            lastLowPriorityId = id;
            loPriorityCnt++;
        }
        if (clashDetector.addAndGet(1) > 1) {
            System.out.println("Clash detected - you are a bad programmer :((((((");
            System.exit(-1);
        }
        sleepRandom(5);
        clashDetector.getAndAdd(-1);
    }

    public void sleepRandom(long maxMiliSec) {
        mySleep((long) (Math.random() * maxMiliSec));
    }

    public void mySleep(long miliSec) {
        try {
            Thread.sleep(miliSec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void prn(String s) {
        System.out.println(s);
    }

    public void test() {
        int idHiPriority = 0;
        LowPriorityContinuousThread lowPriorThrd = new LowPriorityContinuousThread();
        lowPriorThrd.start();
        for (long i = 0; i < (long) 1e3; i++) {
            dblTurnstile.masterLowPriorityRunEn(true);
            for (int j = 0; j < Math.random() * 100; j++) {
                sleepRandom(10);
                new PrioritySingleTaskThread(idHiPriority++).start();
            }
            //sleepRandom(20);
            dblTurnstile.masterLowPriorityRunEn(false);

            for (int j = 0; j < Math.random() * 20; j++) {
                sleepRandom(10);
                new PrioritySingleTaskThread(idHiPriority++).start();
            }
            //sleepRandom(20);
        }
        mySleep(500);
        boolean testOk = true;
        if(hiPriorityCnt != idHiPriority){
            System.out.println(String.format("Error hiPriorityCnt(%d) != idHiPriority(%d)",
                    hiPriorityCnt, idHiPriority));
            testOk = false;
        }
        if(loPriorityCnt != lowPriorThrd.id){
            System.out.println(String.format("Error loPriorityCnt(%d) != lowPriorThrd.id(%d)",
                    loPriorityCnt, lowPriorThrd.id));
            testOk = false;
        }
        System.out.println("High priority tasks performed: "+hiPriorityCnt);
        System.out.println("High priority out of order: "+hiPriorityOutOfOrder);
        System.out.println("Low priority tasks performed: "+loPriorityCnt);
        if(testOk){
            System.out.println("Test2 OK :)))))))))))))))))))))");
        }else{
            System.out.println("Test Failed :(((((((((((((((((((((");
        }
        mySleep(200);
        System.exit(0);
    }

    public static void main(String[] args) throws Exception {
        new Main2().test();
    }
}