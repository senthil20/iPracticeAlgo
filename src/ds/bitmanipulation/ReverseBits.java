package ds.bitmanipulation;

import ds.string.ReverseWords;

/**
 * Created by senthil on 18/9/16.
 */
public class ReverseBits {

    public long reverseBits(long n) {

        long res = 0;
        long mask = 1;
        for (int i= 0; i < 32; i++) {
            if ((n & mask) > 0) res = res + 1;
            if (i != 31) res <<= 1;
            mask <<= 1;
        }
        return res;

        /*for (int i = 0; i < 16; i++) {
            n = swapBits(n, i, 32 - i - 1);
        }

        return n;*/
    }

    public int swapBits(int n, int i, int j) {
        int a = (n >> i) & 1;
        int b = (n >> j) & 1;

        if ((a ^ b) != 0) {
            return n ^= (1 << i) | (1 << j);
        }

        return n;
    }

    public static void main(String a[]) {
        ReverseBits rb = new ReverseBits();
        System.out.println(rb.reverseBits(43261596));
    }
}
