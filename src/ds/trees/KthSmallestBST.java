package ds.trees;

/**
 * Tree
         5
       /   \
      4     7
     /     / \
    2     6  11
   / \      /  \
  1  3     8   12

 if k = 3 o/p = 3
 if k = 9 o/p = 11
 */
public class KthSmallestBST {
    int count = 0;

    public int kthSmallest(TreeNode root, int k, int val) {

        if (root == null) return val;

        if (count <= k) val =  kthSmallest(root.left, k, val);

        count++;

        if (k == count) return root.val;

        if (count <= k) val = kthSmallest(root.right, k, val);

        return val;
    }

    public static void main(String a[]) {
        KthSmallestBST kth = new KthSmallestBST();
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
        System.out.println(kth.kthSmallest(root, 9, -1));
    }
}
