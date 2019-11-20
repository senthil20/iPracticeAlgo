package DataStructures.stacks;

import java.util.*;

public class LargestRectangleArea {

    public static int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) return 0;
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
        System.out.println(LargestRectangleArea.largestRectangleArea(new int[]{1,3,-1,-3,5,3,6,7}));
    }
}
