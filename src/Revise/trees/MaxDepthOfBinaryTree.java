package Revise.trees;

public class MaxDepthOfBinaryTree {

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + Math.max(left, right);
    }
    public static void main(String a[]) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4, null, null),
                        null),
                new TreeNode(3,
                        new TreeNode(5, null, null),
                        new TreeNode(6,
                                new TreeNode(7, null, null),
                                null)));

        int max = maxDepth(root);
        System.out.println(max);
    }
}
