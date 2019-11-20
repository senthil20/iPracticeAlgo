package DataStructures.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 Find the Minimum length Unsorted Subarray, sorting which makes the complete array sorted
 Given an unsorted array arr[0..n-1] of size n, find the minimum length subarray arr[s..e]
 such that sorting this subarray makes the whole array sorted.

 Examples:
 1) If the input array is [10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60], your program should be able to
 find that the subarray lies between the indexes 3 and 8.

 2) If the input array is [0, 1, 15, 25, 6, 7, 30, 40, 50], your program should be able to find that
 the subarray lies between the indexes 2 and 5.
 */
public class MinimumlengthUnsortedSubarray {

    //10,20,40,50,30,15,95,70,90,100
    private static ArrayList<Integer> findRangeAndLength(ArrayList<Integer> a) {
        ArrayList<Integer> result = new ArrayList<>();
        int s = 0;
        int e = a.size() - 1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        //starting position
        for (int i = 0; i < a.size(); i++) {
            if (i > 0 && a.get(i - 1) > a.get(i)) {
                s = i - 1;
                break;
            }
        }
        if (s == 0) return null; //since it's sorted already
        //ending position
        for (int i = a.size() - 1; i >= 0; i--) {
            if (i > 0 && a.get(i - 1) > a.get(i)) {
                e = i;
                break;
            }
        }
        //find min and max in the range
        for (int i = s; i <= e; i++) {
            min = Math.min(min, a.get(i));
            max = Math.max(max, a.get(i));
        }
        //check for lower and higher range
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > min) {
                s = i;
                break;
            }
        }
        for (int i = a.size() - 1; i > 0; i--) {
            if (a.get(i) < max) {
                e = i;
                break;
            }
        }
        result.add(s);
        result.add(e);
        return result;
    }

    public static ArrayList<Integer> buildList(int[] A) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int val : A) {
            result.add(val);
        }
        return result;
    }
    public static void main(String a[]) {
        List<Integer> index = MinimumlengthUnsortedSubarray.findRangeAndLength(buildList(new int[]{16, 6, 18, 17, 13, 6, 18, 16, 6, 15, 15, 18, 16, 13, 16, 16, 6, 18, 15, 15}));
        //List<Integer> index = MinimumlengthUnsortedSubarray.findRangeAndLength(buildList(new int[]{4, 15, 4, 4, 15, 18, 20}));
        //List<Integer> index = MinimumlengthUnsortedSubarray.findRangeAndLength(new int[]{1, 3, 2, 4, 5});
        //List<Integer> index = MinimumlengthUnsortedSubarray.findRangeAndLength(new int[]{10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60});
        //fmin.findRangeAndLength(new int[]{-1,-1,-1,-1});
        //MinimumlengthUnsortedSubarray.findRangeAndLength(new int[]{1, 2, 4, 1, 1, 3, 2, 1, 1, 1, 1, 2, 3, 4});
        //fmin.findRangeAndLength(new int[]{1, 3, 7, 1, 1, 5, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1});
        //fmin.findRangeAndLength(new int[]{1,});
    }
}
