package ds.arrays;

import java.util.PriorityQueue;

public class FindKthLargest {

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
        for(int i: nums){
            q.offer(i);

            if(q.size()>k){
                q.poll();
            }
        }
        return q.peek();
    }

    public static void main(String a[]) {
        int result = findKthLargest(new int[]{5,7,2,1/*,3,4*/}, 3);
        System.out.println(result);
    }
}
