package Java;

/**
 * Created by User on 16-07-2017.
 */
public class Test4 {

    class Inner {
        void test() {
            /*if (Test.this.flag) {
                sample();
            }*/
        }
    }
    private boolean flag = true;

    public void sample() {
        System.out.println("sample");

    }

    public Test4() {

        (new Inner()).test();
    }

    public static void main(String a[]) {

        new Test4();
    }
}
