package ds.arrays;

import java.util.*;

/**
 * Given 3 sorted arrays:
 [
 [1, 3, 5, 7],
 [2, 4, 6],
 [0, 8, 9, 10, 11]
 ]
 return [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11].
 */
public class MergeKSortedArrays {

    class ArrayContainer implements Comparable<ArrayContainer>{
        int[] ar;
        int start;
        ArrayContainer(int[] ar, int start) {
            this.ar = ar;
            this.start = start;
        }
        @Override
        public int compareTo(ArrayContainer o) {
            return this.ar[this.start] - o.ar[o.start];
        }
    }

    public List<Integer> mergeKSortedArray(int[][] arr) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<ArrayContainer> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            ArrayContainer a = new ArrayContainer(arr[i], 0);
            pq.add(a);
        }

        while (!pq.isEmpty()) {
            ArrayContainer a = pq.poll();
            result.add(a.ar[a.start]);

            if (a.start < a.ar.length - 1) {
                pq.add(new ArrayContainer(a.ar, a.start + 1));
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] arr1 = { -1, 3, 5, 7 };
        int[] arr2 = { -9, 2, 4, 6, 8 };
        int[] arr3 = { -11, 0, 9, 10, 11 };

        List<Integer> result = new MergeKSortedArrays().mergeKSortedArray(new int[][] { arr1, arr2, arr3 });
        System.out.println(result);
    }
}
