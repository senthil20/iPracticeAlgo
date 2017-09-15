package revise.trees;

import java.util.Stack;

/**
 * Given a pre-order array of BST, print in-order sequence
 *               8
 *            3    10
 *          1   6    14
 *            4  7  13
 *
 *  given  8, 3, 1, 6, 4, 7, 10, 14, 13
 *  return 1, 3, 4, 6, 7, 8, 10, 13, 14
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {
    }
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class PreOrderToInorder {

    public static void printInorderFromPreOrder(int A[]) {
        Stack<Integer> st = new Stack<>();
        st.push(A[0]);
        for (int i = 1; i < A.length; i++) {
            int temp = st.peek();
            if (A[i] > temp) {
                while (!st.isEmpty() && st.peek() < A[i])
                    System.out.print(st.pop() + " ");
            }
            st.push(A[i]);
        }
        while (!st.isEmpty()) System.out.print(st.pop() + " ");
    }

    public static void main(String a[]) {
        TreeNode root = new TreeNode(8,
                new TreeNode(3,
                        new TreeNode(1, null, null),
                        new TreeNode(6,
                                new TreeNode(4, null, null),
                                new TreeNode(7, null, null))),
                new TreeNode(10,
                        null,
                        new TreeNode(14,
                                new TreeNode(13, null, null),
                                null)));

        int[] A = new int[]{8, 3, 1, 6, 4, 7, 10, 14, 13};
        printInorderFromPreOrder(A);
    }

}
