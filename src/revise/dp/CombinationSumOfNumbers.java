package revise.dp;


public class CombinationSumOfNumbers {

    public static int combinationSum4(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return 0;

        int[] dp = new int[target+1];

        dp[0]=1;

        for(int i=0; i<=target; i++){
            for(int num: nums){
                if(i+num<=target){
                    dp[i+num]+=dp[i];
                }
            }
        }

        return dp[target];
    }

    public static void main(String a[]) {

        int A[] = new int[]{10, 20, 5};
        int result = combinationSum4(A, 1000);
        System.out.println(result);
    }
}
