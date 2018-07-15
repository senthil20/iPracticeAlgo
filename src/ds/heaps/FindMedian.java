package ds.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedian {

    public static void main(String a[]) {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        PriorityQueue<Integer> minQueue = new PriorityQueue();
        PriorityQueue<Integer> maxQueue = new PriorityQueue(Collections.reverseOrder());
        for (int i = 0; i < A.length; i++) {
            if (i == 0) {
                maxQueue.offer(A[i]);
                System.out.println(Double.valueOf(A[i]));
                continue;
            }
            if (A[i] > maxQueue.peek()) {
                minQueue.offer(A[i]);
            } else
                maxQueue.offer(A[i]);

            if (minQueue.size() - maxQueue.size() > 1) maxQueue.offer(minQueue.poll());
            if (maxQueue.size() - minQueue.size() > 1) minQueue.offer(maxQueue.poll());
            if (minQueue.size() > maxQueue.size()) {
                System.out.println((double) minQueue.peek());
            }
            else if(maxQueue.size() > minQueue.size()) {
                System.out.println((double) maxQueue.peek());
            }
            else
                System.out.println((double) (minQueue.peek() + maxQueue.peek()) / 2);
        }
    }
}
