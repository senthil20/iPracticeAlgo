package ds.binarysearch;

import java.util.ArrayList;

/**
 * Created by senthil on 9/8/16.
 */
public class BS {

    /*int getMax(int A[], int n) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (A[i] > max) max = A[i];
        }
        return max;
    }

    int getSum(int A[], int n) {
        int total = 0;
        for (int i = 0; i < n; i++)
            total += A[i];
        return total;
    }

    int getRequiredPainters(int A[], int n, int maxLengthPerPainter) {
        int total = 0, numPainters = 1;
        for (int i = 0; i < n; i++) {
            total += A[i];
            if (total > maxLengthPerPainter) {
                total = A[i];
                numPainters++;
            }
        }
        return numPainters;
    }

    int partition(int A[], int n, int k) {
        int lo = getMax(A, n);
        int hi = getSum(A, n);

        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            int requiredPainters = getRequiredPainters(A, n, mid);
            if (requiredPainters <= k)
                hi = mid;
            else
                lo = mid+1;
        }
        return lo;
    }*/



    private long getMax(ArrayList<Integer> c) {
        int max = Integer.MIN_VALUE;

        for(int i=0; i < c.size(); i++) {
            max = Math.max(max, c.get(i));
        }
        return max;
    }

    private long getTotal(ArrayList<Integer> c) {
        int total = 0;
        for(int i=0; i < c.size(); i++) {
            total = total + c.get(i);
        }
        return total;
    }

    private int getNoOfPainters(ArrayList<Integer> c, int maxLengthPerPainter) {
        int total = 0;
        int noPainters = 1;
        int n = c.size();
        for (int i = 0; i < n; i++) {
            total += c.get(i);
            if (total > maxLengthPerPainter) {
                total = c.get(i);
                noPainters++;
            }
        }
        return noPainters;
    }

    public int paint(int a, int b, ArrayList<Integer> c) {

        long l = getMax(c);
        long h = getTotal(c);

        while(l < h) {
            int m = (int)(l+h)/2;
            int p = getNoOfPainters(c, m);
            if(p <= a) {
                h = m;
            }
            else {
                l = m + 1;
            }
        }
        return (int)((l * b) % 10000003);
    }

    public static void main(String args[]) {
        BS bs = new BS();
        int a[] = new int[]{100, 200, 300, 400, 500, 600, 700, 800, 900};
        //System.out.println(bs.partition(a, a.length, 3));
        ArrayList<Integer> c = new ArrayList<>();
        c.add(1);
        c.add(10);
        System.out.println(bs.paint(2, 5, c));
    }
}
