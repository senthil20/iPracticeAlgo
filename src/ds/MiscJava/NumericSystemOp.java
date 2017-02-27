package ds;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NumericSystemOp {
    static Map<Integer, Character> map = null;
    static {
        map = new HashMap<>();
        map.put(10, 'a');
        map.put(11, 'b');
        map.put(12, 'c');
        map.put(13, 'd');
        map.put(14, 'e');
        map.put(15, 'f');
    }

    public int hex2Decimal(String s) {
        String digits = "0123456789ABCDEF";
        s = s.toUpperCase();
        int val = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int d = digits.indexOf(c);
            val = 16*val + d;
        }
        return val;
    }

    public String decimal2Hex(int d) {
        String digits = "0123456789ABCDEF";
        if (d == 0) return "0";
        String hex = "";
        int val = 0;
        while (d > 0) {
            int digit = d % 16;                // rightmost digit
            hex = digits.charAt(digit) + hex;  // string concatenation
            d = d / 16;
        }
        return hex;
    }

   /* public String hex2Binary(String hex) {
        int decimal = Integer.parseInt(hex, 16);
        String bin = Integer.toBinaryString(decimal);
        System.out.println(bin);
        String digits = "0123456789ABCDEF";
        int val = 0;
        for (int i = 0; i < hex.length(); i++) {
            char c = hex.charAt(i);

        }
        return bin;
    }*/

    //decimal string to a custom base 7 notation.
    public String dec2Base7(int dec) {
        String octal = Integer.toOctalString(dec);
        String toBase16 = Integer.toString(dec, 16);
        String toBase8 = Integer.toString(dec, 8);
        return octal;
    }

    public String decToHex(int num) {
        //Scanner sc = new Scanner(System.in);
        //int num = sc.nextInt();
        //String str = Integer.toHexString(num);
        //System.out.println(str);
        StringBuffer sb = new StringBuffer();
        boolean isNeg = false;
        if (num < 0) {
            num = -num;
            isNeg = true;
        }
        while (num > 0) {
            int rem = num % 16;
            if (rem > 9) {
                sb.append(map.get(rem));
            }
            else
                sb.append(rem);
            num = num / 16;
        }
        System.out.println(sb.reverse().toString());
        return sb.reverse().toString();
    }

    public static void main(String a[]) {
        NumericSystemOp ns = new NumericSystemOp();
        //System.out.println(ns.decimal2Hex(1234));
        //System.out.println(ns.hex2Decimal("4D2"));
        ns.dec2Base7(1234);
    }
}
