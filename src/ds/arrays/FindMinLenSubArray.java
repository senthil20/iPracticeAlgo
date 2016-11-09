package ds.arrays;

import java.util.*;

public class FindMinLenSubArray {

    // WRONG!!! Have to re-work
    // Problem from Quora
    public int findRangeAndLength(int[] a) {

        if (a == null || a.length == 0) return -1;

        Deque<Integer> deque = new ArrayDeque<>();

        int s = 0;
        int e = a.length;
        int min = findMin(a);
        int minIndex = 0;
        int count = 0;
        boolean isExists = false;

        while (s < e) {
            if (deque.contains(a[s])) {
                if (deque.peekFirst() == a[s] && count == 0) {
                    deque.removeFirst();
                }
                else {
                    if (!isExists && a[s] != min) {
                        isExists = true;
                    }
                    minIndex = (minIndex == 0) ? s : minIndex;
                    count++;
                }
            }
            else {
                if (isExists) return -1;
                minIndex = 0;
                count = 0;
            }
            deque.addLast(a[s]);
            s++;
        }
        //remove all min values from deque
        while (count > 0) {
            deque.removeLast();
            count--;
        }
        return deque.size();
    }

    public int findMin(int a[]) {
        int min = Integer.MAX_VALUE;
        for (int val : a) {
            min = val < min ? val : min;
        }
        return min;
    }

    public static void main(String a[]) {
        FindMinLenSubArray fmin = new FindMinLenSubArray();
        //fmin.findRangeAndLength(new int[]{-1,-1,-1,-1});
        fmin.findRangeAndLength(new int[]{1, 2, 4, 1, 1, 3, 2, 1, 1, 1, 1, 2, 3, 4});
        //fmin.findRangeAndLength(new int[]{1, 3, 7, 1, 1, 5, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1});
        //fmin.findRangeAndLength(new int[]{1,});
    }
}
