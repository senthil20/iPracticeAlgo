package ds.bitmanipulation;

/**
 * Created by senthil on 12/9/16.
 */
public class PowerOf2 {

    public boolean powerOf2(int n) {

        return (n > 0 && (n & (n-1)) == 0);
    }

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        int count = 0;

        while (n > 0) {
            count += (n & 1);
            n = n >> 1;
        }

        return count == 1;
    }

    public int maxOnes(int n) {
        int count = 0;
        if (n <= 0) {
            return 0;
        }

        while (n > 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public boolean powerOfTwo(int n) {

        //int i = n;
        //int j = ~n;
        //int k = i & j;

        return n > 0 && (n & (~n)) == 0;
    }

    public static void main(String a[]) {

        PowerOf2 pw2 = new PowerOf2();
        //System.out.println(pw2.powerOf2(257));
        System.out.println(pw2.maxOnes(257));
        //System.out.println(pw2.isPowerOfTwo(257));
        pw2.powerOfTwo(3);
    }
}
