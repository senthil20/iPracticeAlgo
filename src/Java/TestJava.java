package Java;

import java.util.ArrayList;

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

    public static boolean buddyStrings(String A, String B) {
        if (A == null || A.length() == 0 || B == null || B.length() == 0) return false;
        if (A.equals(B)) return false;
        int a = 0;
        int a1 = A.length();
        int b = 0;
        int b1 = B.length();
        int count = 0;
        StringBuilder sb = new StringBuilder(A);
        while (a < a1 && b < b1) {
            if (A.charAt(a) != B.charAt(b)) {
                count++;
                sb.setCharAt(a, B.charAt(b));
                A = sb.toString();
            }
            if (count == 2 && A.equals(B)) {
                return true;
            }
            else if (count == 2 && !A.equals(B)) {
                return false;
            }
            a++;
            b++;
        }
        return true;
    }

    public static boolean arithmeticBoggle(int magicNumber, ArrayList<Integer> numbers) {
        if (numbers.size() == 0) return false;
        return arithmeticBoggle(magicNumber, numbers, 0, 0);
    }

    public static boolean arithmeticBoggle(int magicNumber, ArrayList<Integer> numbers, int index, int temp) {
        /*if (index >= numbers.size() && magicNumber != temp)
            return false;
        if (magicNumber !=0 && magicNumber == temp) {
            return true;
        }
        boolean b1 = arithmeticBoggle(magicNumber, numbers, index + 1, temp + numbers.get(index));
        boolean b2 = false;
        if (!b1)
            b2 = arithmeticBoggle(magicNumber, numbers, index + 1, temp - numbers.get(index));
        return b1 || b2;*/

        if (index > numbers.size() - 1 && magicNumber != temp) return false;
        if (magicNumber == temp) return true;
        boolean r1 = arithmeticBoggle(magicNumber, numbers, index + 1, temp + numbers.get(index));
        boolean r2 = arithmeticBoggle(magicNumber, numbers, index + 1, temp - numbers.get(index));
        return r1 || r2;
    }

    static boolean findTotalWays(ArrayList<Integer> numbers, int i, int k)
    {
        if (i >= numbers.size() && k != 0)
            return false;
        if (k == 0) {
            return true;
        }
        boolean b1 = findTotalWays(numbers, i + 1, k - numbers.get(i));
        boolean b2 = findTotalWays(numbers, i + 1, k + numbers.get(i));
        return b1 || b2;
    }

    public static void main(String a[]) {
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        //boolean total = findTotalWays(list, 0, 2);
        //System.out.print(total);
        boolean result = arithmeticBoggle(2, list);
        System.out.print(result);
        //boolean result = buddyStrings("aa", "aa");
        //TestJava.testB();

    }
}
