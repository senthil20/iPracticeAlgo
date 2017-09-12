package ds.arrays;

import java.util.ArrayList;

/**
 * Created by User on 09-07-2017.
 */

public class BuySellStock {

    static int stockBuySell(int stockPrices[])
    {
        int count = 0;
        int max = 0;
        int i = 0;
        int N = stockPrices.length;
        ArrayList<int[]> list = new ArrayList<>();
        while (i < N - 1)
        {
            int[] temp = new int[2];

            //min
            while ((i < N - 1) && (stockPrices[i + 1] <= stockPrices[i]))
                i++;

            if (i == N - 1)
                break;
            temp[0] = i++;

            //max
            while ((i < N) && (stockPrices[i] >= stockPrices[i - 1]))
                i++;
            temp[1] = i-1;

            list.add(temp);
            count++;
        }

        if (count != 0) {
            for (int j = 0; j < count; j++) {
                int[] val = list.get(j);
                int diff = stockPrices[val[1]] - stockPrices[val[0]];
                max += diff;
            }

        }
        return max;
    }
    public static void main(String a[]) {
        BuySellStock.stockBuySell(new int[]{100,80,120,130,70,60,100,125});
    }
}
