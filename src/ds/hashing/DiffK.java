package ds.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 Given an array ‘A’ of sorted integers and another non negative integer k,
 find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.
 Example:
 Input :
    A : [1, 2, 3, 5, 6, 10]
    k : 4
 Output : YES
 as 5 - 1 = 4
 */
public class DiffK {

    public int diffK(int[] a, int b) {
        if (a == null || a.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            int val = b + a[i];

            map.put(val, i);

            if (map.containsKey(a[i])) {
                System.out.println("Indices are " + map.get(a[i]) + " " + i);
                return 1;
            }
        }
        return 0;
    }

    public int diffK1(int[] a, int b) {
        if(a == null || a.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(a);
        for(int i=0; i < a.length; i++) {

            if (!map.containsKey(a[i])) {
                map.put(a[i] + b, i);
            }
            if (map.containsKey(a[i])) {
                return 1;
            }
        }
        return 0;
    }

    public int diffPossible1(int[] a, int b) {
        if(a == null || a.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i < a.length; i++) {

            if(map.containsKey(a[i])) {
                return 1;
            }
            else {
                map.put(a[i] + b, i);
            }
        }
        return 0;
    }

    public int diffPossible(int[] A, int B) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int num : A) {
            if (hashMap.containsKey(num)) {
                int value = hashMap.get(num);
                value++;
                hashMap.put(num, value);
            } else {
                hashMap.put(num, 1);
            }
        }

        for (int num : A) {
            int n = B + num;
            if (hashMap.containsKey(n)) {
                if (num == n && hashMap.get(n) > 1)
                    //return 1;
                    System.out.println("Values are # " + n + " " + num);
                else if (num != n)
                    //return 1;
                    System.out.println("Values are ## " + n + " " + num);
            }

            n = num - B;
            if (hashMap.containsKey(n)) {
                if (num == n && hashMap.get(n) > 1)
                    //return 1;
                    System.out.println("Values are @ " + n + " " + num);
                else if (num != n)
                    //return 1;
                    System.out.println("Values are @@ " + n + " " + num);
            }
        }
        return 0;
    }

    public static void main(String a[]) {
        DiffK diff = new DiffK();
        //int val = diff.diffK(new int[]{10, 6, 5, 3, 2, 1}, 4);
        //int val = diff.diffK(new int[]{77, 28, 19, 21, 67, 15, 53, 25, 82, 52, 8, 94, 50, 30, 37, 39, 9, 43, 35, 48, 82, 53, 16, 20, 13, 95, 18, 67, 77, 12, 93, 0}, 53);
        //int val = diff.diffPossible(new int[]{77, 28, 19, 21, 67, 15, 53, 25, 82, 52, 8, 94, 50, 30, 37, 39, 9, 43, 35, 48, 82, 53, 16, 20, 13, 95, 18, 67, 77, 12, 93, 0}, 53);
        int val = diff.diffPossible(new int[]{10, 6, 5, 3, 2, 1}, 4);
        System.out.println(val);
    }
}
