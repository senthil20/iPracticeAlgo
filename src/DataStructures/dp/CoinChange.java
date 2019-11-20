package DataStructures.dp;

public class CoinChange {

    //Using recursion
    public static int coinChange(int[] coins, int total) {
        return coinChange(coins, 0, total);
    }

    public static int coinChange(int[] coins, int index, int total) {
        if (index > coins.length - 1 || total < 0) return 0;
        if (total == 0) return 1;

        int sum1 = coinChange(coins, index, total - coins[index]);
        int sum2 = coinChange(coins, index + 1, total);

        return sum1 + sum2;
    }

    //Using recursion
    public static int coinChange1(int[] coins, int total) {
        return coinChange1(coins, 0, total);
    }

    public static int coinChange1(int[] coins, int index, int total) {
        if (index > coins.length - 1 || total < 0) return 0;
        if (total == 0) return 1;

        int sum = 0;
        for (int i = index; i < coins.length; i++) {
            sum += coinChange1(coins, i, total - coins[i]);
        }
        return sum;
    }

    //Using DP
    public static int coinChange2(int[] coins, int total) {

        int[] combinations = new int[total + 1];
        combinations[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j < combinations.length; j++) {
                if (j >= coins[i]) {
                    combinations[j] += combinations[j - coins[i]];
                }
            }
        }
        return combinations[combinations.length - 1];
    }

    public static void main(String a[]) {
        int result = coinChange1(new int[]{1, 5, 10}, 10);
        System.out.println(result);
        int result2 = coinChange2(new int[]{1, 5, 10}, 10);
        System.out.println(result2);
    }
}
