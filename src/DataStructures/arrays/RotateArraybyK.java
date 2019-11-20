package DataStructures.arrays;

/**
 * Created by senthil on 20/9/16.
 */
public class RotateArraybyK {

    public void rotateArrayPartitionSwap(int[] a, int k) {

    }

    public void rotateArrayLeftByK(int []a, int k) {

        if(a == null || a.length == 0 || k == 0) return;

        for (int i = 0; i < k; i++) {
            int s = 0;
            int e = a.length - 1;
            int temp = a[s];

            while (s < e) {
                a[s] = a[s+1];
                s++;
            }
            a[s] = temp;
        }
    }

    public void rotateArrayRightByK(int []a, int k) {

        if(a == null || a.length == 0 || k == 0) return;

        for (int i = 0; i < k; i++) {
            int s = 1;
            int e = a.length - 1;

            while (e > 0) {
                int temp = a[e];
                a[e] = a[e-1];
                a[e-1] = temp;
                e--;
            }
        }
    }

    public static void main(String a[]) {

        RotateArraybyK ra = new RotateArraybyK();
        ra.rotateArrayRightByK(new int[]{1,2,3,4,5,6,7}, 3);
        ra.rotateArrayLeftByK(new int[]{1,2,3,4,5,6,7}, 3);
    }
}
