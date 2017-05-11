package ds.arrays;

import java.lang.reflect.Array;
import java.util.*;

/**
 * You are given a read only array of n integers from 1 to n.
 Each integer appears exactly once except A which appears twice and B which is missing.
 Return A and B.
 Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 Note that in your output A should precede B.

 Input:[3 1 2 5 3]
 Output:[3, 4]
 A = 3, B = 4
 */
public class FindRepetitiveAndMissing {
    //array altered here!
    public static void findRepetitiveAndMissing(int a[]) {

        if(a == null || a.length == 0) return;
        int s = 0;
        int e = a.length;

        while(s < e) {
            if(a[Math.abs(a[s]) - 1] > 0) {
                a[Math.abs(a[s]) - 1] = -a[Math.abs(a[s]) - 1];
            }
            else {
                System.out.println("Repeating element is " + Math.abs(a[s]));
            }
            s++;
        }
        s = 0;
        while(s < e) {
            if(a[s] > 0) {
                System.out.println("Missing element is " + (s + 1));
                break;
            }
            s++;
        }
    }

    //Another approach
    public ArrayList<Integer> repeatedNumber(final List<Integer> a) {
        ArrayList<Integer> result = new ArrayList<>();
        Collections.sort(a);
        int n = a.size();
        long total = n * (n + 1) / 2;
        long sum = 0;
        long rep = 0;
        int i = 1;
        for (; i < a.size(); i++) {
            if (a.get(i) == a.get(i - 1)) rep = a.get(i);
            sum += a.get(i - 1);
        }
        sum += a.get(i - 1);
        long missing = total - sum + rep;
        result.add((int)rep);
        result.add((int)missing);
        return result;
    }

    //finding only missing using binary search
    public int findMissingUsingBinarySearch(int[] A) {
        Arrays.sort(A);
        int l = 0, r = A.length - 1;
        while(l <= r){
            int m = (l + r) / 2;
            if (A[m] > m) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return r + 1;
    }

    public static void main(String a[]) {
        FindRepetitiveAndMissing fm = new FindRepetitiveAndMissing();
        fm.findRepetitiveAndMissing(new int[]{1,2,3,5,5});
        //System.out.println(fm.findMissingUsingBinarySearch(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9}));
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(5);
        ArrayList result = fm.repeatedNumber(list);
        System.out.println(result);
    }

}
