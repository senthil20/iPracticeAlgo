package DataStructures.binarysearch;

/**
 * Created by senthil on 20/8/16.
 */
public class PowerFn {

    public long power1(long key, long n) {

        if(n < 1) return 1;
        return key*power1(key, n-1);
    }

    public long power(long key, long n) {

        if(n < 1) return 1;

        if(n % 2 == 0) {
            long result = power(key, n/2);
            return result * result;
        }
        else {
            return key * power(key, n-1);
        }
    }

    public long powerMod(long key, long n, int mod) {

        if(n < 1) return 1;

        if(n % 2 == 0) {
            long result = power(key, n/2);
            return (result * result) % mod;
        }
        else {
            return (key % mod) * (power(key, n-1) % mod);
        }
    }

    public static double pow(double x, int n) {
        boolean isNeg = false;
        double result = 1;
        if (n < 0) {
            isNeg = true;
            n = -n;
        }
        while (n > 0) {
            if (n % 2 != 0) {
                result = result * x;
            }
            x = x * x;
            n = n / 2;
        }
        return isNeg ? 1 / result : result;
    }
    public static void main(String a[]) {
        PowerFn fn = new PowerFn();
        System.out.println(fn.power(4,5));
    }
}
