package ds.arrays;

import java.lang.reflect.Array;
import java.util.*;

//I have to re-work on it.
public class SubsetSummation {

    //Solution 1
    public boolean groupSum1(int[] arr, int target) {
        return groupSum1(0, arr, target);
    }

    public boolean groupSum1(int start_index, int[] arr, int target) {
        if (start_index >= arr.length)
            return (target == 0);
        else {
            //recursive case 1: include the 1st number, check the remaining
            if (groupSum1(start_index + 1, arr, target - arr[start_index]))
                return true;
            //recursive case 2: does not include the 1st number, check the remaining
            if (groupSum1(start_index + 1, arr, target))
                return true;
        }
        return false;
    }

    //Solution 2
    public static List<Integer> findSubsetSum(int[] numbers, int sum) {
        ArrayList<Integer> subset = new ArrayList<Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (findSubsetSum(numbers, i, subset, sum)) {
                return subset;
            }
        }
        return null;
    }

    private static boolean findSubsetSum(int[] numbers, int index,
                                         ArrayList<Integer> subset, int sum) {
        if (index >= numbers.length) {
            return false;
        }
        if (sum - numbers[index] == 0) {
            subset.add(numbers[index]);
            return true;
        }
        if (sum - numbers[index] < 0) {
            return false;
        }
        sum -= numbers[index];
        for (int i = index + 1; i < numbers.length; i++) {
            if (findSubsetSum(numbers, i, subset, sum)) {
                subset.add(numbers[index]);
                return true;
            }
        }
        return false;
    }

    //Solution 3
    public static boolean groupSum(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return true;
            } else if (arr[i] < target) {
                int tmp = arr[i];
                arr[i] = Integer.MAX_VALUE;
                boolean found = groupSum(arr, target - tmp);
                if (found) {
                    return true;
                }
                arr[i] = tmp;
            }
        }
        return false;
    }

    public static void main(String a[]) {
        SubsetSummation ss = new SubsetSummation();
        List<Integer> list = findSubsetSum(new int[]{5, 9, 7, 1, 3, 6}, 10);
        System.out.println(list);
    }

}
