package Java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by User on 16-07-2017.
 */
public class ExecutorExample {

    static int x = 0;
    public static void test() {
        for (int i = 0; i < 10000000; i++) {
            x = x + 1;
        }
        System.out.println(Thread.currentThread().getName());
        System.out.println("Value of x: " + x);
    }
    public static void main(String a[]) {

        ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.submit(() -> {
            test();
        });

    }
}
