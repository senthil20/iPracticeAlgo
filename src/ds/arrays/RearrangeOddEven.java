package ds.arrays;

/**
 * Created by senthil on 20/8/16.
 */
public class RearrangeOddEven {

    public void rearrange(int[] a) {
        if(a == null || a.length == 0) return;
        int n = a.length;
        int e = 0;
        int o = 1;

        while(e < n && o < n) {
            while(e < n && (a[e] % 2 == 0)) {
                e = e + 2;
            }

            while(o < n && (a[o] % 2 == 1)) {
                o = o + 2;
            }

            if(e < n && o < n) {
                swap(a, e, o);
            }
        }
        System.out.println(a);
    }

    public void swap(int a[], int e, int o) {
        int t = a[e];
        a[e] = a[o];
        a[o] = t;
    }

    public static void main(String a[]) {
        RearrangeOddEven oe = new RearrangeOddEven();
        oe.rearrange(new int[]{1,3,5,2,4,6});
    }
}
