package ds.bitmanipulation;

/**
 * Given a 32 bit integer input x, swap its odd and even bits and return the resulting integer.
 * (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on).

 For example:

 x = 5, Binary code = 0101
 swapOddEvenBits(5) --> 10
 Binary representation of 10 = 1010
 */
public class BitSwapping {

    public int swapOddEvenBits1(int x) {
        String binaryStr = Integer.toBinaryString(x);
        String output = String.format("%4s", binaryStr).replace(' ', '0');
        char[] ch = output.toCharArray();
        String swap = swap(ch, 0, ch.length - 1);
        return Integer.parseInt(swap, 2);
    }

    public String swap(char[] ch, int start, int end) {
        while (start < end) {
            int temp = ch[start];
            ch[start] = ch[end];
            ch[end] = (char)temp;
            start++;
            end--;
        }
        return new String(ch);
    }

    public static int swapOddEvenBits(int x){
        return ((x & 0xaaaaaaaa) >> 1 | ((x & 0x5555555) << 1));
    }
    public static void main(String a[]) {
        BitSwapping bs = new BitSwapping();
        System.out.println(bs.swapOddEvenBits(121));
    }
}
