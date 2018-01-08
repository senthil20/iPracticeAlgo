package ds.stacks;

import java.util.*;

/**
 * Created by senthil on 15/5/16.
 */

class StackNode {

    int index=0;
    Character c;
    StackNode(Integer index, Character c) {
        this.c = c;
        this.index = index;
    }
}

public class Stacks {

    private static final Map<Character, Integer> pMap = new HashMap<>();

    static {
        pMap.put('+', 1);
        pMap.put('-', 1);
        pMap.put('*', 2);
        pMap.put('/', 2);
        pMap.put('%', 2);
        pMap.put('^', 3);
    }


    public static final int DEFAULT_CAPACITY = 10;

    int[] a = new int[DEFAULT_CAPACITY];
    int[] aMin = new int[DEFAULT_CAPACITY];

    int length = 0;
    int minLength = 0;

    public void push(int data) throws Exception{
        if(length == a.length)
            a = Arrays.copyOf(a, 2*DEFAULT_CAPACITY);
        if(minLength == aMin.length)
            aMin = Arrays.copyOf(aMin, 2*DEFAULT_CAPACITY);
        a[length++] = data;

        if(minLength == 0) {
            aMin[minLength++] = data;
            return;
        }

        if(data <= minPeek()) {
            aMin[minLength++] = data;
        }
    }

    public int pop() throws Exception {

        if(length == 0) throw new Exception("stack underflow");
        int temp = a[length-1];
        a[length-1] = -1;
        length--;

        if(temp == minPeek()) {
            aMin[minLength-1] = -1;
            minLength--;
        }

        return  temp;
    }

    public int peek() throws Exception {
        if(length == 0) throw new Exception("stack underflow");
        return a[length-1];
    }

    public int minPeek() throws Exception {
        if(minLength == 0) throw new Exception("stack underflow");
        return aMin[minLength-1];
    }

    public int getMin() throws Exception {
        if(minLength == 0) throw new Exception("stack underflow");
        System.out.println(aMin[minLength-1]);
        return aMin[minLength-1];
    }

    public boolean isStackEmpty(Stacks s) {
        return s.length == 0;
    }

    public void dupStack(Stacks s, Stacks s1) throws Exception{
        if(s.isStackEmpty(s)) return;
        int temp = s.pop();
        dupStack(s, s1);
        s1.push(temp);
    }

    public void reverseStack(Stacks s) throws Exception{

        if(s.isStackEmpty(s)) return;

        int temp = s.pop();
        reverseStack(s);
        insertBottom(s, temp);
    }

    public void insertBottom(Stacks s, int temp) throws Exception {

        if(s.isStackEmpty(s)) {
            s.push(temp);
            return;
        }

        int temp1 = s.pop();
        insertBottom(s, temp);
        s.push(temp1);
    }

    public String infixToPostFix(String s) {
        if(s == null) return s;
        Stack<Character> st = new Stack<>();
        StringBuffer sb = new StringBuffer();
        char[] c = s.toCharArray();
        for(Character ch : c) {
            if(Character.isAlphabetic(ch) || Character.isDigit(ch)) {
                sb.append(ch);
                continue;
            }
            else {
                if(ch != ')' && ch !='(') {
                    if(!st.isEmpty() && st.peek() != '(' && isLowerPrecedence(ch, st.peek())) {
                        while(!st.isEmpty() && st.peek() != '(') {
                            sb.append(st.pop());
                        }
                    }
                    else if(!st.isEmpty() && st.peek() != '(' && isEqualPrecedence(ch, st.peek())) {
                        sb.append(st.pop());

                    }
                    st.push(ch);
                }
                else if(ch == ')') {
                    while(!st.isEmpty() && st.peek() != '(') {
                        sb.append(st.pop());
                    }
                    if(!st.isEmpty()) st.pop();
                }
                else {
                    st.push(ch);
                }
            }
        }
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.toString();
    }

    public boolean isLowerPrecedence(Character c, Character c1) {
        return (pMap.get(c) < pMap.get(c1));
    }

    public boolean isEqualPrecedence(Character c, Character c1) {
        return (pMap.get(c) == pMap.get(c1));
    }

    public Integer getMinPrecedence(int minPr, int input) {

        if(minPr == 0) return (minPr = input);
        else if(input < minPr) return input;
        else return minPr;
    }

    public boolean isOperator(Character ch) {

        return ch != null && (ch == '*' || ch == '/' || ch == '%' || ch == '+' || ch == '-');
    }

    public String removeReduntantbraces(String s) {
	System.out.println("Adding logger");
        StringBuffer sb = new StringBuffer();
        Stack<StackNode> st = new Stack<>();
        List<Integer> index = new ArrayList<>();
        char[] c = s.toCharArray();
        int precedenceWithin = 0;
        Character rightOp;
        Character leftOp;
        int sIndex = 0;

        for (int i = 0; i < c.length; i++) {
            if (c[i] != ')' && !Character.isDigit(c[i]) && !Character.isAlphabetic(c[i])) {
                st.push(new StackNode(sIndex, c[sIndex]));
                sIndex++;
                continue;
            }
            else if(Character.isDigit(c[i]) || Character.isAlphabetic(c[i])) {
                sIndex++;
                continue;
            }
            else {
                leftOp = null;
                rightOp = null;
                if (i + 1 < c.length) {
                    rightOp = c[i + 1];
                }

                StackNode sn = null;
                while (!st.isEmpty() && st.peek().c != '(') {
                    sn = st.pop();
                    Character ch = sn.c;
                    if (isOperator(ch)) {
                        precedenceWithin = getMinPrecedence(precedenceWithin, pMap.get(ch));
                    }

                }
                StackNode leftBrace = st.pop();

                if (!st.isEmpty() && isOperator(st.peek().c)) leftOp = st.pop().c;

                if (precedenceWithin >= getMax(leftOp, rightOp)) {
                    index.add(i);
                    index.add(leftBrace.index);
                }
                precedenceWithin = 0;
                sIndex++;
            }
        }

        while(!st.isEmpty() && (st.peek().c == '(' || st.peek().c == ')')) {
            index.add(st.pop().index);
        }

        for(Integer idx : index) {
            c[idx] = '\n';
        }
        for(Character c1 : c) {
            if(c1 == '\n') continue;
            sb.append(c1);
        }
        return sb.toString();
    }

    public Integer getMax(Character leftOp, Character rightOp) {
        if(!isOperator(leftOp) && !isOperator(rightOp)) return 0;
        else if(!isOperator(leftOp) && isOperator(rightOp)) return pMap.get(rightOp);
        else if(isOperator(leftOp) && !isOperator(rightOp)) return pMap.get(leftOp);
        else return Math.max(pMap.get(leftOp), pMap.get(rightOp));
    }

    public int braces1(String a) {

        char c[] = a.toCharArray();
        Stack<Character> st = new Stack<>();

        for(Character ch : c) {

            if(ch != ')' && !Character.isDigit(ch) && !Character.isAlphabetic(ch)) {
                st.push(ch);
                continue;
            }
            else if(ch == ')') {
                if(!st.isEmpty() && st.peek() == '(') return 1;
                while(!st.isEmpty() && st.peek() != '(') {
                    st.pop();
                }
                st.pop();
            }
        }
        return 0;
    }

    public int braces(String a) {

        if(a == null || a.length() == 0) return 0;
        Stack<Character> st = new Stack<Character>();
        int i = 0;

        while(i<a.length()){
            char c = a.charAt(i);
            if(c == '(' || c =='+' || c == '*' || c == '/' || c =='-') st.push(c);
            else if(c == ')'){
                if(st.peek() == '(') return 1;
                else{
                    while(!st.isEmpty() && st.peek()!= '(') st.pop();
                    st.pop();
                }
            }
            i++;
        }
        return 0;
    }


    public String fileStructure(String s) {

        if(s.length() == 0) return s;

        Stack<String> st = new Stack<>();
        StringBuffer sb = new StringBuffer();
        String str[]  = s.split("/");

        for(String s1 : str) {
            if(s1.equalsIgnoreCase(".")) {
                //do nothing
            }
            else if(s1.equalsIgnoreCase("..")) {
                if(!st.isEmpty()) st.pop();
            }
            else if(!s1.equalsIgnoreCase("")){
                st.push("/"+s1);
            }
        }

        for(String temp: st) {
            sb.append(temp);
        }

        if(sb.length() == 0) sb.append("/");
        return sb.toString();
    }

    public boolean isOperator(String str) {

        return str != null && (str.equalsIgnoreCase("*") || str.equalsIgnoreCase("/") ||
                str.equalsIgnoreCase("%") || str.equalsIgnoreCase("+") || str.equalsIgnoreCase("-"));
    }

    public int evalRPN(ArrayList<String> a) {

        if(a.size() == 0) return 0;

        Stack<Integer> st = new Stack<Integer>();
        for(String s : a) {
            if(!isOperator(s) && !"(".equalsIgnoreCase(s) && !")".equalsIgnoreCase(s)) {
                st.push(Integer.parseInt(s));
            }
            else {
                if("*".equalsIgnoreCase(s))
                    st.push(st.pop()*st.pop());

                else if("/".equalsIgnoreCase(s))
                    st.push((1*st.pop())/st.pop());

                else if("+".equalsIgnoreCase(s))
                    st.push(st.pop()+st.pop());

                else if("-".equalsIgnoreCase(s))
                    st.push(-st.pop()+st.pop());
            }
        }
        if(st.size() == 1) return st.pop();
        return 0;

    }


    public Double postFixEvaluator(String s) {

        if(s == null) return null;
        char[] ch = s.toCharArray();
        Stack<Double> st = new Stack<>();

        for(Character c: ch) {
            if(!isOperator(c)) {
                st.push(Double.parseDouble(c.toString()));
            }
            else if(c == '*') {
                st.push(st.pop() * st.pop());
            }
            else if(c == '/') {
                st.push((1/st.pop()) * st.pop());
            }
            else if(c == '+') {
                st.push(st.pop() + st.pop());
            }
            else if(c == '-') {
                st.push(-st.pop() + st.pop());
            }

        }
        if(st.size() == 1) return st.pop();
        else return null;
    }

    public int[] findNearestSmaller(int[] a) {

        Stack<Integer> st = new Stack<Integer>();
        List<Integer> list = new ArrayList<>();
        if(a.length <=1) return a;

        for(int i=0; i < a.length; i++) {

            while(!st.isEmpty() && st.peek() >= a[i]){
                st.pop();
            }
            if(st.isEmpty()) {
                list.add(-1);
            }
            else {
                list.add(st.peek());
            }
            st.push(a[i]);
        }
        int[] resultant = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            resultant[i] = list.get(i);
        }
        return resultant;
    }


    public ArrayList<Integer> prevSmaller(ArrayList<Integer> arr) {

        Stack<Integer> st = new Stack<Integer>();
        ArrayList<Integer> resultant = new ArrayList<Integer>();

        for(int i = 0; i < arr.size(); i++) {
            while(!st.isEmpty() && st.peek() >= arr.get(i)) {
                st.pop();
            }
            if(st.isEmpty()) {
                resultant.add(-1);
            }
            else {
                resultant.add(st.peek());
            }
            st.push(arr.get(i));
        }
        return resultant;
    }

    public void sort(Stack<Integer> s) {

        Stack<Integer> ns = new Stack<>();
        while(!s.isEmpty()) {
            int temp = s.pop();
            while(!ns.isEmpty() && ns.peek() > temp) {
                s.push(ns.pop());
            }
            ns.push(temp);
        }
        for(int i=0; i < ns.size(); i++)
            System.out.println(ns.get(i));
    }

    public int maxRectangle(int a[]) {
        int i=0;
        int n = a.length;
        int max = 0;
        Stack<Integer> st = new Stack<>();
        while(i < n) {
            if(st.isEmpty() || a[st.peek()] <= a[i]) {
                st.push(i++);
            }
            else {
                int p = i;
                int h = a[p];
                int w = st.isEmpty() ? i : i-st.peek() -1;
                max = Math.max(max, h*w);
            }
        }
        return max;
    }

    public int trap(int[] A) {
        if (A.length == 0)
            return 0;
        int[] maxLeft = new int[A.length];
        int[] maxRight = new int[A.length];
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            maxLeft[i] = max;
            if (A[i] > max)
                max = A[i];
        }
        max = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; i--) {
            maxRight[i] = max;
            if (A[i] > max)
                max = A[i];
        }
        int ret = 0;
        for (int i = 1; i < A.length - 1; i++) {
            int trap = Math.min(maxLeft[i], maxRight[i]) - A[i];
            if (trap > 0)
                ret += trap;
        }
        return ret;
    }

    public int trap1(int[] height) {
        int l = height.length;
        if(l < 3) return 0;
        int[] leftMax = new int[l];
        int[] rightMax = new int[l];
        int maxL = height[0];
        int maxR = height[l-1];
        for(int i = 0; i < l; i++){
            maxL = height[i] > maxL ? height[i] : maxL;
            leftMax[i] = maxL;
            maxR = height[l-1-i] > maxR ? height[l-1-i] : maxR;
            rightMax[l-1-i] = maxR;
        }
        int waterTrapped = 0;
        for(int i = 0; i < l; i++){
            waterTrapped += leftMax[i] > rightMax[i] ? rightMax[i] - height[i] : leftMax[i] - height[i];
        }
        return waterTrapped;
    }

    public int trap3(int[] heights) {
        if(heights.length == 0 || heights.length < 3)
            return 0;

        int l = 0;
        int r = heights.length - 1;
        int water = 0;

        while(l < r && heights[l] <= heights[l+1])
            l += 1;

        while(l < r && heights[r] <= heights[r-1])
            r -= 1;

        while(l < r) {
            int left = heights[l];
            int right = heights[r];

            if(left <= right) {
                while(l < r && left >= heights[l]) {
                    water += left - heights[l];
                    l += 1;
                }
            }
            else {
                while(l < r && right >= heights[r]) {
                    water += right - heights[r];
                    r -= 1;
                }
            }

        }

        return water;
    }

    public int trap4(int[] heights) {
        if (heights.length == 0 || heights.length < 3)
            return 0;
        Stack<Integer> st = new Stack<>();
        int water = 0;
        int n = heights.length;

        for(int i=0; i < n; i++) {
            while(!st.isEmpty() && heights[i] > heights[st.peek()]) {
                int temp = heights[st.pop()];
                if(!st.isEmpty())
                    water = water + (Math.min(heights[i], heights[st.peek()])-temp) * (i-st.peek()-1);
            }
            st.push(i);
        }
        return water;
    }
    public static void main(String a[]) throws Exception{
        Stacks s = new Stacks();
        //Stacks s1 = new Stacks();
        s.push(5);
        s.push(2);
        s.push(2);
        s.push(2);
        //s.dupStack(s, s1);
        /*s.pop();
        s.pop();
        s.getMin();*/
        //s.reverseStack(s);6
        //System.out.print(s);
        //System.out.println(s.infixToPostFix("(A%D)()()()^C*E+X-Y*(A^B))))))"));
        //System.out.println(s.removeReduntantbraces("4-(3-2)"));
        //System.out.println(s.fileStructure("/home/  "));
        //System.out.println(s.postFixEvaluator("22/"));
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        //list.add(2);
        /*list.add(5);
        list.add(6);
        list.add(7);
        list.add(4);
        list.add(12);*/
        //System.out.println(s.evalRPN(list));
        //System.out.println(s.findNearestSmaller(new int[]{1,2,5,6,7,4,12}));
        //s.printPrevSmaller(new int[]{1,2,5,6,7,4,12});
        //System.out.println(s.prevSmaller(list));
        /*Stack<Integer> s1 = new Stack();
        s1.push(3);
        s1.push(1);
        s1.push(5);
        s1.push(2);
        s1.push(7);
        s1.push(4);
        s.sort(s1);*/
        int arr[] = new int[]{3,2,1,4,0,0,1,2};
        System.out.println(s.trap4(arr));
    }
}
