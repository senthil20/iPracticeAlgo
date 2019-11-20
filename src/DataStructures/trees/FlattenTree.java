package DataStructures.trees;

import java.util.Stack;

/**
Input Tree
        1
       / \
      2   5
     / \   \
    3  4    6

Output Tree
         1
          \
           2
            \
             3
              .
               .
                6
*/

public class FlattenTree {

    public static void flattenTreeIterative(TreeNode root) {
        if (root == null) return;
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        while (p != null || !stack.isEmpty()) {
            if (p.right != null) {
                stack.push(p.right);
            }
            if (p.left != null) {
                p.right = p.left;
                p.left = null;
            }
            else if(!stack.isEmpty()) {
                p.right = stack.pop();
            }
            p = p.right;
        }
    }

    /*          1
              /   \
            2      6
           /      / \
          3      7   8
        / \           \
       4  5            9
    */

    public static void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode temp = null;
        if (root.left != null) {
            temp = root.right;
            root.right = root.left;
            root.left = null;
        }
        flatten(root.right);
        while (root.right != null)
            root = root.right;

        root.right = temp;
        flatten(temp);
    }

    public static void main(String a[]) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3, null, null),
                        new TreeNode(4, null, null)),
                new TreeNode(5,
                        null,
                        new TreeNode(6, null, null)));
        root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3,
                                new TreeNode(4, null, null),
                                new TreeNode(5, null, null)),
                        null),
                new TreeNode(6,
                        new TreeNode(7, null, null),
                        new TreeNode(8,
                                null,
                                new TreeNode(9, null, null))));
        root = new TreeNode(1,
                new TreeNode(2, null, null),
                new TreeNode(3,
                        new TreeNode(4, null, null),
                        null));
        /*root = new TreeNode(1,
                null,
                new TreeNode(2,
                        new TreeNode(3, null, null),
                        null));*/

        flatten(root);
        System.out.println(root);
        //ft.flattenTree(root);
    }
}
