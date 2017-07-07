package ds.MiscJava;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Topics String encoding/decoding
 * Other Hex to Bin to Oct converter programs
 *
 */

/**
 * https://www.quora.com/How-would-one-explain-character-encoding-and-different-kinds-of-encodings-to-a-non-technical-person
 *
 */
public class StringConverter {

    static public String byteToHex(byte b) {
        // Returns hex String representation of byte b
        char hexDigit[] = {
                '0', '1', '2', '3', '4', '5', '6', '7',
                '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
        };
        char[] array = { hexDigit[(b >> 4) & 0x0f], hexDigit[b & 0x0f] };
        return new String(array);
    }

    static public String charToHex(char c) {
        // Returns hex String representation of char c
        byte hi = (byte) (c >>> 8);
        byte lo = (byte) (c & 0xff);
        return byteToHex(hi) + byteToHex(lo);
    }

    public static void printBytes(byte[] array, String name) {
        for (int k = 0; k < array.length; k++) {
            System.out.println(name + "[" + k + "] = " + "0x" +
                    StringConverter.byteToHex(array[k]));
        }
    }

    /**
     You can convert directly via the String(byte[], String) constructor and getBytes(String) method.
     Java exposes available character sets via the Charset class. The JDK documentation lists supported encodings.

     90% of the time, such conversions are performed on streams, so you'd use the Reader/Writer classes.
     You would not incrementally decode using the String methods on arbitrary byte streams - you would leave yourself open to bugs involving multibyte characters.
     */
    public static void main(String[] args) throws UnsupportedEncodingException {

        System.out.println(System.getProperty("file.encoding"));
        String t = "334324sdfsdf";
        Charset.forName("UTF-8").encode(t);

        String str = "~hi this is to test$";
        byte[] b = str.getBytes("UTF-8");

        String temp = new String(b, "UTF-8");



        String original = new String("A" + "\u00ea" + "\u00f1"
                + "\u00fc" + "C");

        System.out.println("original = " + original);
        System.out.println();

        try {
            byte[] utf8Bytes = original.getBytes("UTF8");
            byte[] defaultBytes = original.getBytes();

            String roundTrip = new String(utf8Bytes, "UTF8");
            System.out.println("roundTrip = " + roundTrip);

            /*System.out.println();
            printBytes(utf8Bytes, "utf8Bytes");
            System.out.println();
            printBytes(defaultBytes, "defaultBytes");*/
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    } // main
}
