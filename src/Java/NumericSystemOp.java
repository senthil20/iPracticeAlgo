package Java;

import java.util.HashMap;
import java.util.Map;

/**
 *Numbers

 Numbers in Java can be written in many different forms. Depending on the prefix or suffix we use,
 we can declare it’s base (binary, hex, octal), and even it’s type (int, long, float).

 Alterations in the base:

 With literal prefixes we can define 4 different numeric bases, and they are: Octal, Hexadecimal, Decimal and Binary.

 We can represent an Octal number by adding the 0 prefix to it.
 We can represent a Hexadecimal number by adding the 0x prefix to it.
 When we don’t add any prefix, the number is treated as a decimal number.

 And with Java 7  we have a new literal prefix to represent binary base, which is the 0b prefix.

 public vodi numberSystem(){
     int decimal = 100;   // 100 em decimal.
     int octal = 0144;    // decimal 100 represented in octal base.
     int hex = 0x64;      // decimal 100 represented in hexadecimal base.
     int bin = 0b1100100; // decimal 100 represented in binary base
     // Only works in Java 7 version or higher.
     System.out.println(decimal); // Prints '100'
     System.out.println(octal);   // Prints '100'
     System.out.println(hex);     // Prints '100'
     System.out.println(bin);     // Prints '100'
 }
 *
 * For the computer information is stored in bytes, each one formed by 8 on/off values called bits.
   Those on/off values can be seen in base 2 a 0 and 1, grouped by 3 as octal (base 8) numbers, by 4 as hexadecimal (base 16) numbers.
   As you dont have enough different digits in base 10, to represent the extra digits over 9 are used letters from A to F, so 15 decimal is F and 16 decimal is 10 hexadecimal.
   So you can represent the value of a byte with an 8 digit binary number, with a digital number between 0 and 255, or an hexadecimal number between 0 and FF.
   Why using other base to represent them? Because there are operations that take into account specific bits on a byte, in decimal they are not as obvious as in binary or hexadecimal.
 */
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
        StringBuffer hex = new StringBuffer();
        int val = 0;
        while (d > 0) {
            int digit = d % 16;// rightmost digit
            hex.append(digits.charAt(digit));
            d = d / 16;
        }
        return hex.reverse().toString();
    }



    //decimal string to a custom base 7 notation.
    public String dec2Base7(int dec) {
        String octal = Integer.toOctalString(dec);/* public String hex2Binary(String hex) {
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

    public String itoa(int num, int base) {
        if (num == 0) return "";
        boolean isNeg = false;
        if (num < 0 && base == 10) {
            isNeg = true;
            num = -num;
        }
        StringBuffer sb = new StringBuffer();
        while (num > 0) {
            int rem = num % base;
            int temp = (rem > 9)? (rem-10) + 'a' : rem + '0';
            num = num / base;
        }
        if (isNeg) sb.append("-");
        return sb.reverse().toString();
    }
    public static void main(String a[]) {
        NumericSystemOp ns = new NumericSystemOp();
        //System.out.println(ns.decimal2Hex(1234));
        //System.out.println(ns.hex2Decimal("4D2"));
        //ns.dec2Base7(1234);
        System.out.println(ns.itoa(1234, 16));
        System.out.println(ns.itoa(1234, 8));
        System.out.println(ns.itoa(1234, 2));
        System.out.println(ns.itoa(1234, 10));
    }
}
