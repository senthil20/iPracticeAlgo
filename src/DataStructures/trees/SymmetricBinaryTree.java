package DataStructures.trees;

/**
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
     1
    / \
   2   2
  / \ / \
 3  4 4  3

But the following [1,2,2,null,3,null,3] is not:
     1
    / \
   2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
**/

public class SymmetricBinaryTree {
    public boolean symmetricTree(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        boolean isLeft = symmetricTree(left.left, right.right);
        boolean isRight = symmetricTree(left.right, right.left);
        return isLeft && isRight;
    }

    public static void main(String a[]) {
        SymmetricBinaryTree st = new SymmetricBinaryTree();
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3, null, null),
                        new TreeNode(4, null, null)),
                new TreeNode(2,
                        new TreeNode(4, null, null),
                        new TreeNode(3, null, null)));
        System.out.println(st.symmetricTree(root.left, root.right));
    }
}