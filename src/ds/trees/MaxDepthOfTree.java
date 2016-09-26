package ds.trees;

/**
 * Created by senthil on 24/9/16.
 */
public class MaxDepthOfTree {

    public int maxDepthOfTree(TreeNode root) {

        if (root == null) return -1;

        int l = maxDepthOfTree(root.left);
        int r = maxDepthOfTree(root.right);

        return Math.max(l, r) + 1;
    }

    public static void main(String a[]) {
        MaxDepthOfTree bst = new MaxDepthOfTree();
        //int[] ar = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 11, 12};
        //TreeNode root = new BSTBasicOperations().buildTreeSortedArray(new TreeNode(), ar, 0, ar.length - 1);
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
        System.out.println(bst.maxDepthOfTree(root));
    }
}
