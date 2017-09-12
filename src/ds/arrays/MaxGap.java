package ds.arrays;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.max;
import static java.lang.StrictMath.min;

/**
 * Created by senthil on 20/8/16.
 */
public class MaxGap {

    //
    public int maxArr(ArrayList<Integer> A) {
        if (A == null || A.size() < 2) return 0;
        int max = Math.abs(A.get(0) - A.get(1)) + Math.abs(0 - 1);
        for (int i = 2; i < A.size(); i++) {
            max = Math.max(max, Math.abs(A.get(i - 2) - A.get(i)) + Math.abs((i - 2) - i));
            max = Math.max(max, Math.abs(A.get(i - 1) - A.get(i)) + Math.abs((i - 1) - i));
        }
        return max;
    }

    public int maxIndexDiff(int arr[], int n)
    {
        int maxDiff;
        int i, j;

        int RMax[] = new int[n];
        int LMin[] = new int[n];

        /* Construct LMin[] such that LMin[i] stores the minimum value
           from (arr[0], arr[1], ... arr[i]) */
        LMin[0] = arr[0];
        for (i = 1; i < n; ++i)
            LMin[i] = min(arr[i], LMin[i - 1]);

        /* Construct RMax[] such that RMax[j] stores the maximum value
           from (arr[j], arr[j+1], ..arr[n-1]) */
        RMax[n - 1] = arr[n - 1];
        for (j = n - 2; j >= 0; --j)
            RMax[j] = max(arr[j], RMax[j + 1]);

        /* Traverse both arrays from left to right to find optimum j - i
           This process is similar to merge() of MergeSort */
        i = 0; j = 0; maxDiff = -1;
        while (j < n && i < n)
        {
            if (LMin[i] <= RMax[j])
            {
                maxDiff = max(maxDiff, j - i);
                j = j + 1;
            }
            else
                i = i + 1;
        }

        return maxDiff;
    }

    public int maximumGap(final List<Integer> a) {

        if(a == null || a.size() < 2) return 0;

        int n = a.size();


        List<Integer> min = java.util.Arrays.asList(new Integer[n]);
        List<Integer> max = java.util.Arrays.asList(new Integer[n]);


        min.set(0, a.get(0));
        max.set(n-1, a.get(n-1));

        for(int i = 1; i < n; i++) {
            min.set(i, Math.min(a.get(i), min.get(i-1)));
        }

        for(int j = n-2; j >= 0; --j) {
            max.set(j, Math.max(a.get(j), max.get(j+1)));
        }

        int s = 0;
        int e = 0;

        int diff = -1;

        while(s < n && e < n) {
            if(min.get(s) < max.get(e)) {
                diff = Math.max(diff, (e-s));
                e++;
            }
            else {
                s++;
            }
        }
        return diff;
    }

    public static void main(String a[]) {
        MaxGap gp = new MaxGap();
        System.out.println(gp.maxIndexDiff(new int[]{1, 3, -1}, 3));
         /*List<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(100);
        list.add(100);
        list.add(100);
        list.add(100);
        fg.maximumGap(list);*/
    }
}