package ds.stacks;

import java.util.*;

/**
 * Created by senthil on 29/5/16.
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

public class DequeSlidingWindow {

    public static List findMaxWindow(int a[], int k) {

        if(a == null || a.length < 3) return null;
        List<Integer> maxList = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();

        for(int i=0; i < k; i++) {
            while(!dq.isEmpty() && a[dq.peekLast()] <= a[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }

        for(int i=k; i < a.length; i++) {
            maxList.add(a[dq.peekFirst()]);

            while(!dq.isEmpty() && dq.peekFirst() <= i-k) {
                dq.removeFirst();
            }
            while(!dq.isEmpty() && a[dq.peekLast()] <= a[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }

        if(!dq.isEmpty())
            maxList.add(a[dq.peekFirst()]);
        return maxList;
    }

    public static int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();

        int max = 0;
        int i = 0;

        while (i < height.length) {
            if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int p = stack.pop();
                int h = height[p];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(h * w, max);
            }
        }

        while (!stack.isEmpty()) {
            int p = stack.pop();
            int h = height[p];
            int w = stack.isEmpty() ? i : i - stack.peek() - 1;
            max = Math.max(h * w, max);
        }

        return max;
    }

    public static void main(String args[]) {

        int a[] = new int[]{1,3,-1,-3,5,3,6,7};
        //DequeSlidingWindow.largestRectangleArea(a);
        List<Integer> list = DequeSlidingWindow.findMaxWindow(a, 3);
        for(Integer i : list)
            System.out.println(" " + i);
    }
}
