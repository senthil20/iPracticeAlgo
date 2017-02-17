package ds;

/**
 * Created by sydgsk9 on 12/15/2016.
 */
public class TestJava {

    public void testA() {

    }
    public static void testB() throws ArithmeticException {
    try {
        System.out.println("111");
        int i = 9/0;
        System.out.println("222");
    }
    catch(Exception e) {
         e.printStackTrace();
    }
    finally {
        System.out.println("333");
    }
    }
    public static void main(String a[]) {
        TestJava.testB();

    }
}
