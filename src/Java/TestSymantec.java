package Java;

import java.util.Scanner;

public class TestSymantec {

    public static void test() {
        System.out.println("test");
    }

    public static void main(String a[]) {
        Scanner sc = new Scanner(System.in);
        int val = sc.nextInt();
        System.out.println("val is: " + val);
        String s = sc.next();
        System.out.println("sc next is: " + s);
        String str = sc.next();
        System.out.println("str is: " + str);
        int count = 2;
        for (int i = 0; i < count; i++) {
            String temp = sc.next();
            System.out.println("temp is: " + temp);
        }
    }
}
