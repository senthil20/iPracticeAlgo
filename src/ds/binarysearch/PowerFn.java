package ds.binarysearch;

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

    public static void main(String a[]) {
        PowerFn fn = new PowerFn();
        System.out.println(fn.power(4,5));
    }
}
