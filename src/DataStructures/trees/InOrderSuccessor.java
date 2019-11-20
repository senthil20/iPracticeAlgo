package DataStructures.trees;

/**
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 * Note: If the given node has no in-order successor in the tree, return null.
 * Example 1:
 *  p = 1
 *   2
 *  / \
 * 1   3
 * Output: 2

 * Example 2:
 *  p = 7
 *         5
 *      /   \
 *     2     8
 *    / \   / \
 *   1   3 6  9
            \
             7
 * Output: 8
 */
public class InOrderSuccessor {

    public static TreeNode inorderSuccessor(TreeNode root, int p) {
        TreeNode res = null;
        while (root!=null) {
            if (p < root.val) {
                res = root;
                root = root.left;
            }
            else root = root.right;
        }
        return res;
    }

    public static TreeNode inorderPredecessor(TreeNode root, int p) {
        TreeNode res = null;
        while (root != null) {
            if (p > root.val) {
                res = root;
                root = root.right;
            }
            else root = root.left;
        }
        return res;
    }

    public static void main(String a[]) {
        TreeNode root = new TreeNode(5,
                new TreeNode(2,
                        new TreeNode(1, null, null),
                        new TreeNode(3, null, null)),
                new TreeNode(8,
                        new TreeNode(6,
                                null,
                                new TreeNode(7, null, null)),
                        new TreeNode(9, null, null)));

        //TreeNode result = inorderSuccessor(root, new TreeNode(), 6);
        TreeNode result = inorderSuccessor(root, 1);
        System.out.print(result);
    }
}
