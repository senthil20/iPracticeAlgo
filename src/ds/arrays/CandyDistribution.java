package ds.arrays;

import java.util.ArrayList;
import java.util.List;
//2, 1
//2,
public class CandyDistribution {

    //1, 2, 4, 4, 5 - rating
    //1, 1, 1, 1, 1 - candy
    //1, 2, 2, 2, 2
    //
    public int candy(ArrayList<Integer> ratings) {
        if (ratings == null || ratings.size() == 0) return 0;
        List<Integer> candy = new ArrayList<>();
        for (int i = 0; i < ratings.size(); i++) {
            candy.add(i, 1);
        }

        while (true) {
            boolean candyDistributed = true;
            for (int i = 0; i < ratings.size(); i++) {
                if (i == 0 && ratings.get(i) > ratings.get(i + 1) ) {
                    candy.add(i, candy.get(i) + 1);
                    candyDistributed = false;
                    continue;
                }
                if (i == ratings.size() - 1 && ratings.get(i - 1) < ratings.get(i)) {
                    candy.add(i, candy.get(i) + 1);
                    candyDistributed = false;
                    continue;
                }

                if (ratings.get(i) > ratings.get(i - 1) || ratings.get(i) > ratings.get(i + 1)) {
                    candy.add(i, candy.get(i) + 1);
                    candyDistributed = false;
                }
            }
            if (candyDistributed) break;
        }
        int candyReq = 0;
        for (int val : candy) {
            candyReq += val;
        }
        return candyReq;
    }

}
