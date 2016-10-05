package ds.trees;

public class KthSmallestBST {
    int count = 0;
    boolean found = false;

    public int kthSmallest(TreeNode root, int k, int value) {

        if (root == null) return value;

        value =  kthSmallest(root.left, k, value);
        count++;
        if (k == count) {
            found = true;
            return root.val;
        }
        value = kthSmallest(root.right, k, value);
        return value;
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
