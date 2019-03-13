package ds.dp;

/**
 * There are n houses build in a line, each of which contains some value in it.
 * A thief is going to steal the maximal value of these houses,
 * but he can’t steal in two adjacent houses because owner of the stolen houses will tell his two neighbour left and right side.
 * What is the maximum stolen value.
 * Examples:
 *
 * Input  : hval[] = {6, 7, 1, 3, 8, 2, 4}
 * Output : 19
 * Thief will steal 6, 1, 8 and 4 from house.
 *
 * Input  : hval[] = {5, 3, 4, 11, 2}
 * Output : 16
 * Thief will steal 5 and 11
 */

public class HouseRobber {

    //dp
    public static int rob(int[] A) {
        if (A == null || A.length == 0) return 0;
        if (A.length == 1) return A[0];
        if (A.length == 2) return Math.max(A[0], A[1]);
        int[] dp = new int[A.length];
        dp[0] = A[0];
        dp[1] = Math.max(A[0], A[1]);
        for (int i = 2; i < A.length; i++) {
            dp[i] = Math.max(A[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[A.length - 1];
    }

    //greedy
    public static int rob1(int[] A) {
        if (A == null || A.length == 0) return 0;
        if (A.length == 1) return A[0];
        if (A.length == 2) return Math.max(A[0], A[1]);
        int[] dp = new int[A.length];
        int val1 = dp[0];
        int val2 = Math.max(A[0], A[1]);
        for (int i = 2; i < A.length; i++) {
            int temp = Math.max(A[i] + val1, val2);
            val1 = val2;
            val2 = temp;
        }
        return val2;
    }


    public static void main(String a[]) {
        //int result = rob(new int[]{5, 3, 4, 11, 2});
        int result = rob1(new int[]{6, 7, 1, 3, 8, 2, 4});
        System.out.println(result);
    }
}
