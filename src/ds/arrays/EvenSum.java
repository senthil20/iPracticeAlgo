package ds.arrays;

/**
 * Created by User on 22-07-2017.
 */
public class EvenSum {

    public static boolean splitArray(int[] arr) {
        if (arr.length ==0)
            return false;
        // Sum up the array
        int arr_sum = 0;
        for (int item: arr)
            arr_sum+= item;
        // If sum is an odd number, it is impossible to split the array of elements evenly.
        if (arr_sum%2 != 0)   return false;
        // If sum is an even number, check if the summation to half is possible.
        return groupSum(0,arr,arr_sum/2);
    }

    public static boolean groupSum(int start_index, int[] arr, int target) {
        // Base case: there is no number left.
        if (start_index >= arr.length)
            return (target == 0);
        else {
            // Recursive case 1: include the 1st number, check the remaining
            if (groupSum(start_index+1,arr,target-arr[start_index]))
                return true;
            // Recursive case 2: does not include the 1st number, check the remaining
            if (groupSum(start_index+1,arr,target))  return true;
        }
        return false;
    }

    public static void main(String a[]) {
        System.out.println(splitArray(new int[]{1,2,3,4,5,6}));
    }
}
