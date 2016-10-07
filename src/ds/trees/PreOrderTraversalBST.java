package ds.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 Tree
         5
      /    \
     4      9
    /     /  \
   2     7   11
  / \  /  \  / \
 1  3 6   8 10 12

 output = true
 */
public class PreOrderTraversalBST {

    //tc: o(n) sc: o(n)
    public void preorderRecursive(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorderRecursive(root.left);
        preorderRecursive(root.right);
    }

    //tc: o(n) sc: o(n)
    public List<Integer> preOrderIterative(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            root = st.pop();
            result.add(root.val);

            if (root.left != null) {
                root = root.left;
            }
            if (root.right != null) {
                root = root.right;
            }
        }
        return result;
    }

    public static void main(String a[]) {
        PreOrderTraversalBST pre = new PreOrderTraversalBST();
        int[] ar = new int[]{1, 3, 5, 7, 9, 14, 18, 21};
        TreeNode root = new BSTBasicOperations().buildTreeSortedArray(new TreeNode(), ar, 0, ar.length - 1);
        pre.preorderRecursive(root);
    }
}
