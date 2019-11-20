package DataStructures.trees;

/** Tree
        6
      /   \
     4    10
    / \   / \
   2  5  9  12
  / \   /  /  \
 1  3  7  11   13

 */
public class DeleteNodeBST {
    TreeNode root;
    //tc: o(n)
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        int cmp = Integer.compare(key, root.val);
        if (cmp < 0) root.left = deleteNode(root.left, key);
        else if (cmp > 0) root.right =  deleteNode(root.right, key);
        else {
            if (root.left == null)
                return root.right;

            if (root.right == null)
                return root.left;

            TreeNode t = root;
            root = findMin(t.right);
            root.right = deleteMin(t.right);
            root.left = t.left;
        }
        return root;
    }

    private TreeNode deleteMin(TreeNode x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        return x;
    }

    public TreeNode findMin(TreeNode node) {
        if (node.left == null) return node;
        return findMin(node.left);
    }

    public static void main(String a[]) {
        DeleteNodeBST d = new DeleteNodeBST();
        int[] ar = new int[]{1, 3, 5, 7, 9, 14, 18, 21};
        //TreeNode root = new BSTBasicOperations().buildTreeSortedArray(new TreeNode(), ar, 0, ar.length - 1);
        TreeNode root = new TreeNode(6,
                new TreeNode(4,
                        new TreeNode(2,
                                new TreeNode(1, null, null),
                                new TreeNode(3, null, null)),
                        new TreeNode(5, null, null)),
                new TreeNode(10,
                        new TreeNode(9,
                                new TreeNode(7, null, null),
                                null),
                        new TreeNode(12,
                                new TreeNode(11, null, null),
                                new TreeNode(13, null, null))));
        root = d.deleteNode(root, 6);
        System.out.println(root);
    }
}
