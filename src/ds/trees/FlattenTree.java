package ds.trees;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
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

/**
 Tree
         1
      /    \
     2      5
    / \      \
   3   4      6

 output = true
 */
public class FlattenTree {

    public void flattenTree(TreeNode root) {
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
    public TreeNode flattenTree1(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return root;
        TreeNode right = null;
        if (root.left != null) {
            right = root.right;
            root.right = root.left;
            root.left = null;
        }
        root = flattenTree1(root.right);
        if (root != null) root.right = right;
        return root.right != null ? root.right : root;
    }

    public static void main(String a[]) {
        FlattenTree ft = new FlattenTree();
        /*TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3, null, null),
                        new TreeNode(4, null, null)),
                new TreeNode(5,
                        null,
                        new TreeNode(6, null, null)));*/
        TreeNode root = new TreeNode(1,
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
        ft.flattenTree(root);
        System.out.println(root);
       // TreeNode result = ft.flattenTree1(root);
    }
}
