package DataStructures.arrays;

import java.util.*;

/**
 * Created by sydgsk9 on 4/13/2017.
 */
public class CountOccurence {
    //5, 4, 3, 4, 4, 5
    //4 3 5
    //4 5 3
    /**
     * 6 5 5 4 3 3 3 4 4
     //o/p 4 3 5 6
     // occ same order maintain
     */
    public List<Integer> countOccurence(int[] A) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : A) {
            if(map.containsKey(val)) {
                int count = map.get(val);
                map.put(val, count + 1);
            }
            else {
                map.put(val, 1);
            }
        }
        for (int val : A) {
            //5 4 3 3 3 4 4 5
            if (map.containsKey(val)) {
                result.add(map.get(val));
                map.remove(val);
            }
            //2, 3, 3
            //2 3 3 3 3 3 3 2
        }
        return null;
    }

    public static void main(String a[]) {
        CountOccurence co = new CountOccurence();
        co.countOccurence(new int[]{5, 4, 3, 5, 5, 5, 5, 3, 3, 4, 4});
    }
}
