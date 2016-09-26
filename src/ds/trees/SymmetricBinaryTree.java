package ds.trees;

/**
For example, this binary tree is symmetric:
       1
     /   \
    2     2
   / \   / \
  3   4 4   3

But the following is not:
      1
     / \
    2   2
    \   \
    3    3
 **/

public class SymmetricBinaryTree {

    public boolean symmetricTree(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) return true;

        else if (root1 == null || root2 == null) {
            return false;
        }

        if(root1.val != root2.val) return false;

        boolean left = symmetricTree(root1.left, root2.right);
        boolean right = symmetricTree(root1.right, root2.left);

        return (left && right);
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
        st.symmetricTree(root.left, root.right);
    }
}