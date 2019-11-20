package DataStructures.stacks;

import java.util.*;
/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 For example,
 Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 Window position                Max
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 Therefore, return the max sliding window as [3,3,5,5,6,7].
 */

class Node implements Comparable<Node>{
    int index;
    int val;

    Node(int index, int val) {
        this.index = index;
        this.val = val;
    }

    @Override
    public int compareTo(Node n) {
        return Integer.compare(n.val, val);
    }
}

public class SlidingWindow {

    public static int[] slidingWindow(int A[], int W) {
        Deque<Integer> q = new LinkedList<>();
        int[] result = new int[A.length - W + 1];
        for(int i = 0; i < W; i++) {
            while(!q.isEmpty() && A[q.peekLast()] <= A[i]) {
                q.removeLast();
            }
            q.addLast(i);
        }
        int count = 0;
        for(int i = W; i < A.length; i++) {
            result[count++] = A[q.peekFirst()];
            while(!q.isEmpty() && q.peekFirst() <= i-W) {
                q.removeFirst();
            }
            while(!q.isEmpty() && A[q.peekLast()] <= A[i]) {
                q.removeLast();
            }
            q.addLast(i);
        }
        result[count++] = A[q.peekFirst()];
        return result;
    }

    public static int[] slidingWindowPQ(int A[], int W) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] result = new int[A.length - W + 1];
        for(int i = 0; i < W; i++) {
            pq.add(new Node(i, A[i]));
        }
        int count = 0;
        for(int i=W; i<A.length; i++) {
            result[count++] = A[pq.peek().val];
            while(!pq.isEmpty() && pq.peek().index <= i-W) {
                pq.remove();
            }
            pq.add(new Node(i, A[i]));
        }
        result[count++] = A[pq.peek().val];
        return result;
    }

    public static int[] maxSlidingWindow(int[] A, int k) {
        if (A == null || A.length == 0 || k <= 1) return A;
        int[] result = new int[A.length - k + 1];
        int index = 0;
        int max = 0;
        int start = 0;
        while (start < k) {
            max = Math.max(max, A[start++]);
        }
        result[index++] = max;
        while (start++ <= A.length - 1) {
            max = 0;
            int count = index;
            while (count < index + k) {
                max = Math.max(max, A[count++]);
            }
            result[index++] = max;
        }
        return result;
    }

    //i/p: [1,3,-1,-3,5,3,6,7] and k = 3
    //o/p: [3,3,5,5,6,7]
    public static int[] maxSlidingWindowProgramCreek(int[] nums, int k) {
        if(nums==null||nums.length==0)
            return new int[0];

        int[] result = new int[nums.length-k+1];

        LinkedList<Integer> deque = new LinkedList<Integer>();
        for(int i=0; i<nums.length; i++){
            if(!deque.isEmpty()&&deque.peekFirst()==i-k)
                deque.poll();

            while(!deque.isEmpty()&&nums[deque.peekLast()]<nums[i]){
                deque.removeLast();
            }

            deque.offer(i);

            if(i+1>=k)
                result[i+1-k]=nums[deque.peek()];
        }

        return result;
    }
    /*public static int[] slidingWindowTreeMap(int A[], int W) {
        TreeMap<Integer,Integer> counts = new TreeMap<Integer,Integer>();
        for (int i = 0 ; i != W ; i++) {
            if (counts.containsKey(A[i])) {
                counts.put(A[i], counts.get(A[i])+1);
            } else {
                counts.put(A[i], 1);
            }
        }
        for (int i = W ; i != A.length ; i++) {
            Integer max = counts.lastKey();
            System.out.println(max);
            int tmp = counts.get(A[i-W])-1;
            if (tmp != 0) {
                counts.put(A[i-W], tmp);
            } else {
                counts.remove(A[i-W]);
            }
            if (counts.containsKey(A[i])) {
                counts.put(A[i], counts.get(A[i])+1);
            } else {
                counts.put(A[i], 1);
            }
        }
        System.out.println(counts.lastKey());
    }*/

    public static void main(String a[]) {
        System.out.println(slidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3));
        //System.out.println(maxSlidingWindowProgramCreek(new int[] {1,3,-1,-3,5,3,6,7}, 3));
        System.out.println(maxSlidingWindowProgramCreek(new int[] {4, 3, 2, 5}, 3));
        //System.out.println(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3));
        //System.out.println(maxSlidingWindow(new int[]{7, 2, 4},2));
        //System.out.println(slidingWindowTreeMap(new int[] {1,3,-1,-3,5,3,6,7}, 3));
    }
}
