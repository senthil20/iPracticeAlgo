package revise.trees;

/**
 *        8
       /     \
      4        11
    /  \      / \
   2    6    10  13
  / \  / \     /  \
 1  3 5  7    12  14
 */
public class DeleteNodeBST {

    /**
     root = [5,3,6,2,4,null,7]
     key = 3
          5
        /  \
       3   6
     / \    \
    2   4    7
     */
    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        else {
            if (root.left == null && root.right == null) return null;
            if (root.left != null && root.right == null) return root.left;
            TreeNode temp = root;
            root = findMin(root.right);
            root.left = temp.left;
        }
        return root;
    }

    public static TreeNode findMin(TreeNode node) {
        if (node.left == null) return node;
        return findMin(node.left);
    }

    public static void main(String a[]) {
        /*TreeNode node = new TreeNode(8,
                new TreeNode(4,
                        new TreeNode(2,
                                new TreeNode(1, null, null),
                                new TreeNode(3, null, null)),
                        new TreeNode(6,
                                new TreeNode(5, null, null),
                                new TreeNode(7, null, null))),
                new TreeNode(11,
                        new TreeNode(10, null, null),
                        new TreeNode(13,
                                new TreeNode(12, null, null),
                                new TreeNode(14, null, null))));
        TreeNode result = deleteNode(node, 6);*/
        TreeNode node = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2, null, null),
                        new TreeNode(4, null, null)),
                new TreeNode(6, null,
                        new TreeNode(7, null, null)));
        TreeNode result = deleteNode(node, 3);
        System.out.println(result);
    }
}
