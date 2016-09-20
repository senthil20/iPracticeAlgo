package ds.arrays;

import java.sql.Array;
import java.util.*;
import java.util.Arrays;

/**
 * Created by senthil on 13/8/16.
 */
public class FindDuplicate {

    public static int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        int find = 0;

        while(find != slow){
            slow = nums[slow];
            find = nums[find];
        }
        return slow;
    }

    public static int findDuplicate1(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            int m = (l+r)/2;
            int c = 0;

            for(int i: nums){
                if(i <= m){
                    c++;
                }
                else
                    break;
            }
            if(c > m) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return (l==nums.length) ? r : -1;
    }

    private static void segregate(int a[]) {
        if (a == null || a.length == 0) return;
        int s = 0;
        int e = a.length;
        int index = 0;
        while (s < e) {
            if (a[s] <= 0) {
                int temp = a[s];
                if (s > 0) {
                    System.arraycopy(a, index, a, index + 1, s - index);
                    a[index] = temp;
                }
                index++;
            }
            s++;
        }
        System.out.println(a);
        System.arraycopy(a, 0, a, 1 , 2);
    }

    public static void main(String a[]) {
        //System.out.println(FindDuplicate.findDuplicate(new int[]{2,5,9,6,9,3,8,9,7,1}));
        //System.out.println(FindDuplicate.findDuplicate1(new int[]{1,2,3,4,5,6,7}));
        FindDuplicate.segregate(new int[]{-1, 1, 3, 2, -2});
    }
}
