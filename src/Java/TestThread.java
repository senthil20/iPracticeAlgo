package Java;

public class TestThread {

    public void run() {
        System.out.println("Test Thread run");
    }

    public static void main(String a[]) {
        TestThread thread = new TestThread();
        //thread.start();
    }

}
