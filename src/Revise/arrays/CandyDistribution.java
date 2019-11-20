package Revise.arrays;

import java.util.Arrays;

public class CandyDistribution {

    public static int candy(int[] ratings) {
        int sum = 0;
        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1);
        boolean flag = true;

        while (flag) {
            flag = false;
            for (int i = 1; i < ratings.length; i++) {
                if (ratings[i] > ratings[i - 1] && candy[i] <= candy[i - 1]) {
                    candy[i] = candy[i] + 1;
                    flag = true;
                }
                if (i < ratings.length - 1 && ratings[i] > ratings[i + 1] && candy[i] <= candy[i + 1]) {
                    candy[i] = candy[i] + 1;
                    flag = true;
                }
            }
        }
        for (int i = 0; i < candy.length; i++) {
            sum += candy[i];
        }
        return sum;
    }

    public static void main(String a[]) {
        int[] ratings = new int[]{4, 6, 4, 5, 6, 2};
        ratings = new int[]{2, 4, 2, 6, 1, 7, 8, 9, 2, 1};
        int total = candy(ratings);
        System.out.println(total);
    }
}
