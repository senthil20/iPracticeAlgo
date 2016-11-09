package ds.hashing;

import java.util.HashSet;
import java.util.Set;

/**
 A number can be broken into different sub-sequence parts.
 Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
 And this number is a colorful number, since product of every digit of a sub-sequence are different.
 That is, 3 2 4 5 (3*2)=6 (2*4)=8 (4*5)=20 (3*2*4)= 24 (2*4*5)= 40
 But 326 is not a colorful number as it generates 3 2 6 (3*2)=6 (2*6)=12.
 You have to write a function that tells if the given number is a colorful number or not.
 */
public class ColorfulNumbers {

    public int colorful(int a) {

        String s = String.valueOf(a);

        Set<Integer> set = new HashSet<>();

        int temp = 0;

        while (temp < s.length()) {
            //If consecutive Integer is same return 0
            if (set.contains(s.charAt(temp) - '0')) return 0;
            set.add(s.charAt(temp) - '0');
            temp++;
        }

        int i = 0;
        int j = 1;
        int n = s.length();

        int val1 = 0;
        int val2 = 0;

        while (j < n) {

            val1 = s.charAt(i) - '0';
            val2 = s.charAt(j) - '0';

            if (set.contains(val1*val2))
                return 0;

            set.add(val1 * val2);

            i++;
            j++;
        }
        return 1;
    }

    public static void main(String a[]) {
        ColorfulNumbers cn = new ColorfulNumbers();
        System.out.println(cn.colorful(123));
    }
}
