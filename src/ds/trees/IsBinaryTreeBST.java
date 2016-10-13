package ds.trees;

import sun.reflect.generics.tree.Tree;

/**
Tree
        5
      /   \
     4     7
    /     / \
   2     6  11
  / \      /  \
 1  3     8   12

output = true

Tree
        5
      /   \
     4     7
    /     / \
   2     3  11
  / \      /  \
 1  6     8   12

output = false, because of node with value 6 & node with value 3
 */
public class IsBinaryTreeBST {
    boolean isFail = false;
    public boolean isBTreeBST(TreeNode root, int min, int max) {

        if (root == null) return true;

        if (root.val < min || root.val > max) {
            isFail = true;
            return false;
        }
        boolean left = false;
        boolean right = false;

        if (!isFail) {
            left = isBTreeBST(root.left, min, root.val);
            right = isBTreeBST(root.right, root.val, max);
        }
        return left && right;
    }

    public static void main(String a[]) {

        IsBinaryTreeBST isBT = new IsBinaryTreeBST();
        TreeNode root = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(2,
                                new TreeNode(1, null, null),
                                new TreeNode(3, null, null)),
                        null),
                new TreeNode(7,
                        new TreeNode(3, null, null),
                        new TreeNode(11,
                                new TreeNode(8, null, null),
                                new TreeNode(12, null, null))));

        System.out.println(isBT.isBTreeBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}