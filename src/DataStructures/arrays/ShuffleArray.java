package DataStructures.arrays;

/**
 * Created by senthil on 12/8/16.
 */
public class ShuffleArray {

    public void splitArray(int a[], int s, int e) {
        /*if(s == e) return;
        int mid = (s+e)/2;
        splitArray(a, s, mid);
        splitArray(a, mid+1, e);
        swap(a, s, e);*/
        int mid = (s+e)/2;
        swap(a, 0, mid);
        swap(a, mid+1, e);
    }

    public void swap(int[] a, int s, int e) {
        while(s < e) {
            int t = a[s];
            a[s] = a[e];
            a[e] = t;
            s++;
            e--;
        }
    }

    public static void main(String sr[]) {
        ShuffleArray s = new ShuffleArray();
        int a[] = new int[]{9,4,-1,4,31,7,8,9,11,2,3,4,5,73};
        //int a[] = new int[]{5,1,2,6,4,3};
        //int a[] = new int[]{3,4,6,2,1,5};
        s.splitArray(a, 0, a.length-1);
        for(int val : a) System.out.print(val + " ");
        s.splitArray(a, 0, a.length-1);
        System.out.println();
        for(int val : a) System.out.print(val + " ");
    }
}
