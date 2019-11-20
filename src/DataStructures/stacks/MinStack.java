package DataStructures.stacks;

import java.util.Stack;

/**
 Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.
 Example:
 MinStack minStack = new MinStack();
 minStack.push(-2);
 minStack.push(0);
 minStack.push(-3);
 minStack.getMin();   --> Returns -3.
 minStack.pop();
 minStack.top();      --> Returns 0.
 minStack.getMin();   --> Returns -2.
 */
public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.empty() || minStack.peek() >= x)
            minStack.push(x);
    }

    public void pop() {
        if(!stack.isEmpty()){
            int num = stack.pop();
            if(num == minStack.peek())
                minStack.pop();
        }
    }

    public int top() {
        if (!stack.empty()) return stack.peek();
        else return 0;
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String a[]) throws Exception {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
