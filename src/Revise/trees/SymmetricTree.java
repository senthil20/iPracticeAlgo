package Revise.trees;

public class SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }
    public static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if ((left == null && right != null)
                || (left != null && right == null)
                || (left.val != right.val)) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public static void main(String a[]) {
        TreeNode node = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3, null, null),
                        new TreeNode(4, null, null)),
                new TreeNode(2,
                        new TreeNode(4, null, null),
                        new TreeNode(3, null, null)));
        boolean result = isSymmetric(node);
        System.out.println(result);
    }
}
