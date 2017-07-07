package ds.arrays;

/**
 For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}.
 So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
 So the output should be 5.
 */
public class CoinChange {
    //from geeksforgeeks
    public static int count( int A[], int m, int n ) {
        //If n is 0 then there is 1 solution (do not include any coin)
        if (n == 0)
            return 1;
        //If n is less than 0 then no solution exists
        if (n < 0)
            return 0;
        //If there are no coins and n is greater than 0, then no solution exist
        if (m <=0 && n >= 1)
            return 0;
        //count is sum of solutions (i) including A[m-1] (ii) excluding A[m-1]
        int c1 = count(A, m - 1, n);
        int c2 = count(A, m, n - A[m - 1]);
        return c1 + c2;
    }

    public static int makeChange(int[] coins, int amount) {
        if (coins != null && coins.length > 0 && amount >= 0)
            return makeChange(coins,amount,0);
        return 0;
    }

    //from firecode.io
    public static int makeChange(int[] coins, int amount, int current_coin_index) {
        int next_coin_index;
        if (current_coin_index < coins.length - 1){
            //If the coin index is less than the last index, increment the index.
            next_coin_index = current_coin_index + 1;
        }
        else
        {
            //If the current coin index is equal to the last index, return the coin itself.
            return coins[current_coin_index];
        }
        int res = 0;
        //Logic to calculate the residual amount.
        for (int i = 0; i * coins[current_coin_index] <= amount; i++) {
            res += makeChange(coins,amount-i*coins[current_coin_index],next_coin_index);
        }
        return res;
    }

    public static void main(String a[]) {
        int[] arr = new int[]{1, 2, 3};
        //int[] arr = new int[]{2, 5, 3, 6};
        System.out.println(CoinChange.count(arr, arr.length, 10));
    }
}
