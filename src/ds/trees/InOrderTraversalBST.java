package ds.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by senthil on 22/9/16.
 */
public class InOrderTraversalBST {

    //tc: o(n) sc: o(n)
    public void inorderRecursive(TreeNode root) {

        if (root == null) return;
        inorderRecursive(root.left);
        System.out.print(root.val + " ");
        inorderRecursive(root.right);
    }

    //tc: o(n) sc: o(n)
    public List<Integer> inorderIterative(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> st = new Stack<>();

        while (!st.isEmpty() || root != null) {
            if (root != null) {
                st.push(root);
                root = root.left;
                continue;
            }
            else {
                TreeNode t = st.pop();
                result.add(t.val);
                System.out.print(t.val + " ");
                root = t.right;
            }
        }
        return result;
    }


    public static void main(String a[]) {
        InOrderTraversalBST in = new InOrderTraversalBST();
        //int[] ar = new int[]{1, 3, 5, 7, 8, 9, 11, 12, 13, 14, 15, 17, 18, 20};
        int[] ar = new int[]{1, 3, 5, 7, 9, 14, 18, 21};
        TreeNode root = new BSTBasicOperations().buildTreeSortedArray(new TreeNode(), ar, 0, ar.length - 1);
        in.inorderIterative(root);
        //in.inorderRecursive(root);
    }
}
