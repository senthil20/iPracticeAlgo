package DataStructures.arrays;


public class MaxProfit {


    public static int maxProfit(int[] a) {
        if (a == null || a.length == 0) return 0;
        int maxProfit = 0;
        for (int i = 1; i < a.length; i = i+2)
            maxProfit = Math.max(maxProfit, maxProfit + (a[i] - a[i - 1]));
        return maxProfit;
    }

    public static void main(String a[]) {

    }
}
