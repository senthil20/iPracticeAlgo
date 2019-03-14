package ds.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * There are N children standing in a line. Each child is assigned a rating value.
 * <p>
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 * <p>
 * Sample Input :
 * <p>
 * Ratings : [1 2]
 * Sample Output :
 * 3
 * The candidate with 1 rating gets 1 candy and candidate with rating cannot get 1 candy as 1 is its neighbor.
 * So rating 2 candidate gets 2 candies. In total, 2+1 = 3 candies need to be given out.
 */
public class CandyDistribution {

    public static int candy(int[] A) {

        if (A == null || A.length == 0) return 0;
        int n = A.length;
        int[] candy = new int[n];

        Arrays.fill(candy, 1);

        for (int i = 0; i < n - 1; i++) {
            if (A[i + 1] > A[i])
                candy[i + 1] = candy[i] + 1;
        }
        for (int i = n - 1; i > 0; i--) {
            if (A[i - 1] > A[i] && candy[i - 1] <= candy[i])
                candy[i - 1] = candy[i] + 1;
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += candy[i];
        }
        return sum;
    }

    public static void main(String a[]) {

        int[] A = new int[]{1, 2, 1, 3, 4, 3};
        //int[] A = new int[]{4, 2, 3, 1, 5, 7, 2};
        //int[] A = new int[]{1, 9, 2, 10, 5, 1};
        int result = candy(A);
        System.out.println(result);
    }
}
