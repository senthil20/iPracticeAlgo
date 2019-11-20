package DataStructures.stacks;

import java.util.Stack;

public class MaxStack {

    Stack<Integer> stack;
    Stack<Integer> maxStack;

    public MaxStack() {
        stack = new Stack();
        maxStack = new Stack();
    }

    public void push(int x) {
        int max = maxStack.isEmpty() ? x : maxStack.peek();
        maxStack.push(x > max ? x : max);
        stack.push(x);
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        if (maxStack.isEmpty()) return -1;
        int max = peekMax();
        Stack<Integer> temp = new Stack<>();
        while (max != top()) {
            temp.push(pop());
        }
        pop();
        while (!temp.isEmpty()) {
            push(temp.pop());
        }
        return max;
    }

    public static void main(String a[]) {
        MaxStack maxStack = new MaxStack();
        maxStack.push(2);
        maxStack.push(1);
        maxStack.push(5);
        maxStack.push(3);
        maxStack.push(9);
        maxStack.pop();
        System.out.println(maxStack.popMax());
    }
}
