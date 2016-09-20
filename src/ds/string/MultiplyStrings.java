package ds.string;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by senthil on 14/9/16.
 */
public class MultiplyStrings {

    public String multiplyStrings(String a, String b) {

        int aIndex = 0;
        int bIndex = b.length() - 1;
        int[] str = new int[a.length() + b.length()];
        String result = "";

        while (bIndex >= 0) {

            int carry = 0;
            int newCarry = 0;

            aIndex = a.length() - 1;

            int bVal = Integer.valueOf("" + b.charAt(bIndex));

            while (aIndex >= 0) {
                int aVal = Integer.valueOf("" + a.charAt(aIndex));

                int total = aVal * bVal + carry;
                int q = total % 10;
                carry = total / 10;

                int newTotal = str[aIndex + bIndex + 1] + newCarry + q;
                int newQ =  newTotal % 10;
                newCarry = newTotal / 10;

                str[aIndex + bIndex + 1] = newQ;

                aIndex--;
            }

            str[bIndex] = carry + newCarry;
            bIndex--;
        }

        for (int i = 0; i < str.length; i++) {
            result += str[i];
        }

        int t = 0;
        while (t < result.length() - 1 && result.charAt(t) == '0')
            t++;

        return result.substring(t, result.length());
    }

    public static void main(String a[]) {
        MultiplyStrings ms = new MultiplyStrings();
        System.out.println(ms.multiplyStrings("1000000", "0000010"));
    }
}
