package ds.arrays;

import java.util.*;
import java.util.Arrays;


public class LongestSeqUnSortedArray {

    //Solution from Sam - byte-by-byte.com
    public int consecutive(int[] a) {

        HashSet<Integer> values = new HashSet();
        for (int i : a) {
            values.add(i);
        }

        int maxLength = 0;
        for (int i : values) {
            // If it is not the leftmost value in the sequence, don't bother
            if (values.contains(i - 1)) {
                continue;
            }
            int length = 0;

            // Iterate through sequence
            while (values.contains(i++)) {
                length++;
            }
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }


    public int longestSequence(int[] a) {

        if (a == null || a.length == 0) return 0;

        Arrays.sort(a);

        int max = 0;
        int currMax = 1;

        int s = 1;
        int e = a.length;

        while (s < e) {
            if (a[s] == a[s-1] + 1) currMax++;
            else {
                max = Math.max(max, currMax);
                currMax = 1;
            }
            s++;
        }
        return Math.max(max, currMax);
    }

    public static void main(String a[]) {
        LongestSeqUnSortedArray la = new LongestSeqUnSortedArray();
        System.out.println(la.consecutive(new int[]{4, 2, 1, 6, 5}));
        System.out.println(la.longestSequence(new int[]{1, 1001, 1002}));
    }
}
