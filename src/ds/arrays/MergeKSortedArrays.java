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
    public static List<Integer> mergeKSortedArrays(int[][] arrays) {
        class ArrayNode {
            int[] A;
            int count;

            ArrayNode(int[] A, int count) {
                this.A = A;
                this.count = count;
            }
        }
        PriorityQueue<ArrayNode> pq = new PriorityQueue<ArrayNode>(new Comparator<ArrayNode>() {
            @Override
            public int compare(ArrayNode o1, ArrayNode o2) {
                return Integer.compare(o1.A[o1.count], o2.A[o2.count]);
            }
        });
        for (int[] A : arrays) {
            if (A.length > 0) {
                pq.add(new ArrayNode(A, 0));
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            ArrayNode node = pq.poll();
            result.add(node.A[node.count]);
            if (node.count >= node.A.length - 1) continue;
            pq.add(new ArrayNode(node.A, node.count + 1));
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = MergeKSortedArrays.mergeKSortedArrays(new int[][]{
                {8, 11, 12, 13, 19},
                {0, 4, 8, 14, 15},
                {-1, 1, 2, 3}
        });
        System.out.println(result);
    }
}
