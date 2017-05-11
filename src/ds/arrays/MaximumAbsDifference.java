package ds.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 You are given an array of N integers, A1, A2 ,…, AN. Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N.
 f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.

 A=[1, 3, -1]

 f(1, 1) = f(2, 2) = f(3, 3) = 0
 f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
 f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
 f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5

 So, we return 5
 */
public class MaximumAbsDifference {
     // 0    1   2    3   4   5   6    7   8   9
    //-70, -64, -6, -56, 64, 61, -57, 16, 48, -98

    public int maxArr(ArrayList<Integer> A) {
        if (A == null || A.size() < 2) return 0;
        int max = Math.abs(A.get(0) - A.get(1)) + Math.abs(0 - 1);
        for (int i = 2; i < A.size(); i++) {
            max = Math.max(max, Math.abs(A.get(i - 2) - A.get(i)) + Math.abs((i - 2) - i));
            max = Math.max(max, Math.abs(A.get(i - 1) - A.get(i)) + Math.abs((i - 1) - i));
        }
        return max;
    }

    public static void main(String a[]) {
        MaximumAbsDifference m = new MaximumAbsDifference();
        ArrayList<Integer> list = new ArrayList();
        list.add(1);
        list.add(3);
        list.add(-1);
        System.out.println(m.maxArr(list));
    }

}
