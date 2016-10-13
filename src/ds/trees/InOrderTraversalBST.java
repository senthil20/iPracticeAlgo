package ds.trees;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
Tree
        5
      /   \
     4     7
    /     / \
   2     6  11
  / \      /  \
 1  3     8   12

output = 1, 2, 3, 4, 5, 6, 7, 8, 11, 12
*/

public class InOrderTraversalBST {

    //tc: o(n) sc: o(n)
    public void inorderRecursive(TreeNode root) {

        if (root == null) return;
        inorderRecursive(root.left);
        System.out.print(root.val + " ");
        inorderRecursive(root.right);
    }

    public TreeNode pushLeft(TreeNode root, Stack<TreeNode> st) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }
        return root;
    }
    //tc: o(n) sc: o(n)
    public List<Integer> inorderIterative(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> st = new Stack<>();

        while (!st.isEmpty() || root != null) {

            if (root != null) {
                root = pushLeft(root, st);
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
        //int[] ar = new int[]{1, 3, 5, 7, 9, 14, 18, 21};
        //TreeNode root = new BSTBasicOperations().buildTreeSortedArray(new TreeNode(), ar, 0, ar.length - 1);
        TreeNode root = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(2,
                                new TreeNode(1, null, null),
                                new TreeNode(3, null, null)),
                        null),
                new TreeNode(7,
                        new TreeNode(6, null, null),
                        new TreeNode(11,
                                new TreeNode(8, null, null),
                                new TreeNode(12, null, null))));

        in.inorderIterative(root);
        //in.inorderRecursive(root);
    }
}
