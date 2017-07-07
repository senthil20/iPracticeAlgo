package ds.arrays;

/**
 * Created by senthil on 12/8/16.
 */
public class ShuffleArray_LeetCode {


    public int[] nums;
    public int[] reset;

    public ShuffleArray_LeetCode(){

    }

    public ShuffleArray_LeetCode(int[] nums) {
        this.nums = nums;
        this.reset = java.util.Arrays.copyOf(nums, nums.length);
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        //nums = java.util.ArraysBasics.copyOf(reset, reset.length);
        return reset;
    }

    /** Returns a random shuffling of the array. */

    public int[] shuffle() {
        if(nums == null || nums.length == 0) return nums;
        return splitArray(nums, 0, nums.length-1);
    }

    public int[] splitArray(int[] nums, int s, int e) {

        if(s == e) return nums;
        int mid = (s+e)/2;
        splitArray(nums, s, mid);
        splitArray(nums, mid+1, e);
        swap(nums, s, e);
        return nums;
    }

    /*public int[] shuffle() {
        return splitArray();
    }

    public int[] splitArray() {
        int s = 0;
        int e = nums.length-1;
        int mid = (s+e)/2;
        swap(nums, 0, mid);
        swap(nums, mid+1, e);
        return nums;
    }*/

    public void swap(int[] nums, int s, int e) {
        int t = nums[s];
        nums[s] = nums[e];
        nums[e] = t;
    }

    public static void main(String st[])
    {

        int[] nums = {-6, 10, 184, 100, 50, -70};
        ShuffleArray_LeetCode solution = new ShuffleArray_LeetCode(nums);

        System.out.println("\n" +"Reset");
        for(int val : solution.reset())
            System.out.print(val + " ");

        System.out.println("\n" + "Shuffle");
        for(int val : solution.shuffle())
            System.out.print(val + " ");

        System.out.println("\n" +"Reset");
        for(int val : solution.reset())
            System.out.print(val + " ");

        System.out.println("\n" + "Shuffle");
        for(int val : solution.shuffle())
            System.out.print(val + " ");

        System.out.println("\n" +"Reset");
        for(int val : solution.reset())
            System.out.print(val + " ");

        System.out.println("\n" + "Shuffle");
        for(int val : solution.shuffle())
            System.out.print(val + " ");
    }
}
