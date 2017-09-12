package ds.arrays;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
   For example, given the array [-2, 1, -3, 4, -1, 2, 1, -5, 4],
   The contiguous subarray [4, -1, 2, 1] has the largest sum = 6.
 */

public class MaximumSumSubArray {

    public int maxSubArray(int[] A) {
        int max = 0;
        int sum = 0;
        for (int val : A) {
            sum += val;
            if (sum < 0) sum = 0;
            //sum = Math.max(val, sum + val);
            max = Math.max(max, sum);
        }
        return max;
    }
    public static void main(String a[]) {
        MaximumSumSubArray ms = new MaximumSumSubArray();
        ms.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});

    }
}
