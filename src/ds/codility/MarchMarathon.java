package ds.codility;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MarchMarathon {

    /**
     Consider the following template for an equation:
     a ? b ? c ? d
     Here each letter stands for an integer value, and ? stands for either an equals sign or a multiplication operator.
     You have an array values that contains four integers. Can you fill the template with the integers, two multiplication operators, and one equals sign, such that the resulting equation will be correct?
     Example
     For values = [2, 4, 3, 6], the output should be
     equationTemplate(values) = true.
     Here is how the template can be filled to result in a correct equation: 2 * 6 = 3 * 4.
     For values = [2, 3, 30, 5], the output should be
     equationTemplate(values) = true.
     Here is one of the ways to fill the template to get a correct equation: 30 = 2 * 3 * 5.
     For values = [2, 3, 5, 5], the output should be
     equationTemplate(values) = false.
     There is no way to fill the template that will result in a correct equation.
     Input/Output
     [time limit] 3000ms (java)
     [input] array.integer values
     Guaranteed constraints:
     values.length = 4,
     -100 ≤ values[i] ≤ 100.
     [output] boolean
     Return true if the template can be filled so that the resulting equaltion will be correct, otherwise return false.
     */

    boolean equationTemplate(int[] values) {
        return perm(values, values.length, false);
    }

    private boolean perm(int[] a, int n, boolean val) {
        int v1 = a[0];
        int v2 = a[1];
        int v3 = a[2];
        int v4 = a[3];

        if (v1 == v2 * v3 * v4 || v1 * v2 == v3 * v4 || v1 *v2 * v3 == v4)
            return true;

        if (n == 1) return false;

        for (int i = 0; i < n; i++) {
            if (!val) {
                swap(a, i, n-1);
                val = perm(a, n-1, val);
                swap(a, i, n-1);
            }
        }
        return val;
    }

    public void swap(int a[], int s , int d) {
        int temp = a[s];
        a[s] = a[d];
        a[d] = temp;
    }

    public int solution(String S) {
        if (S == null || S.length() == 0) return 0;
        Stack<Character> st = new Stack<>();
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == '(') st.push(ch);
            else {
                if (!st.isEmpty()) {
                    st.pop();
                }
                count++;
            }
        }
        return count;
    }

    public int[] solution1(int[] A) {
        if (A == null || A.length == 0) return new int[]{};
        List<Integer> list = new ArrayList<>();

        int result = 0;
        for (int i = 0; i < A.length; i++)
            result += Math.pow(-2, i) * A[i];

        int num = -result;
        while (num != 0) {
            int rem = num % (-2);
            num = num / (-2);
            if (rem < 0) {
                rem += 2;
                num += 1;
            }
            list.add(rem);
        }
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    public int[] solution3(int[] A) {
        if (A == null || A.length == 0) return new int[]{};
        List<Integer> list = new ArrayList<>();

        int result = 0;
        for (int i = 0; i < A.length; i++)
            result += Math.pow(-2, i) * A[i];

        int num = -result;
        while (num != 0) {
            int rem = num % (-2);
            num = (int)Math.ceil(num / (-2));
            list.add(Math.abs(rem));
        }
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }


    int result = 0;
    public int solution2(int A, int B) {
        recursiveTraversal(0, 0, A, B, 0, false);
        return result;
    }

    public void recursiveTraversal(int start, int end, int A, int B, int count, boolean dir) {
        if (start > A || end > B) return;
        if (start == A && end == B) {
            result = Math.min(result, count);
        }
        if (dir) {
            recursiveTraversal(start + 2, end + 1, A, B, count + 1, false);
        }
        else {
            recursiveTraversal(start + 1, end + 2, A, B, count + 1, true);
        }
    }

    public List<Double> toBaseNeg2(double d) {
        List<Double> list = new ArrayList<>();
        while (d != 0) {
            double remainder = d % -2;
            d = d / -2;
            d = Math.ceil(d);
            list.add(Math.abs(remainder));
        }
        return list;
    }

    public static void main(String a[]) {
        MarchMarathon mm = new MarchMarathon();
        mm.toBaseNeg2(-9);
        //mm.solution2(1, 0);

        //mm.solution3(new int[]{1,0,0,1,1});
        //mm.solution("))");
        //System.out.println(mm.equationTemplate(new int[]{2, 4, 3, 6}));
        //System.out.println(mm.equationTemplate(new int[]{2, 3, 30, 5}));
    }
}
