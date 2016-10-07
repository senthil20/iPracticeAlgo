package ds.trees;

/** Nodes 2 & 6
 * Tree Input                  Output
          5                        5
        /   \                    /   \
       4     7                  4     7
     /      / \       -->      /     / \
    6      2  11              2     6  11
   / \        / \            / \      / \
  1  3       8  12          1  3     8  12
*/

/** If nodes are adjacent 2 & 4
 * Tree Input                  Output
          5                        5
        /   \                    /   \
       2     7                  4     7
      /     / \       -->      /     / \
     4     6  11              2     6  11
    / \      / \             / \       / \
   1  3     8  12           1  3      8  12
*/

public class RecoverBST {

    TreeNode p, q;
    TreeNode prev = null;

    public void recoverBST(TreeNode root) {
        if (root == null) return;

        System.out.println("Before recovering..." );
        inorderTraversal(root);
        System.out.println();
        int temp = p.val;
        p.val = q.val;
        q.val = temp;

        System.out.println("After recover...");
        inOrderPrint(root);
    }

    public void inorderTraversal(TreeNode root) {

        if (root == null) return;

        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        if (prev != null && root.val < prev.val) {
            if (p == null) {
                p = prev;
                q = root;
            }
            else q = root;
        }
        prev = root;

        inorderTraversal(root.right);
    }

    public void inOrderPrint(TreeNode root) {
        if (root == null) return;
        inOrderPrint(root.left);
        System.out.print(root.val + " ");
        inOrderPrint(root.right);
    }

    public static void main(String a[]) {

        RecoverBST bst = new RecoverBST();

        TreeNode root = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(6,
                                new TreeNode(1, null, null),
                                new TreeNode(3, null, null)),
                        null),
                new TreeNode(7,
                        new TreeNode(2, null, null),
                        new TreeNode(11,
                                new TreeNode(8, null, null),
                                new TreeNode(12, null, null))));
        bst.recoverBST(root);
    }
}
