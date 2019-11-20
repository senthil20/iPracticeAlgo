package Revise.trees;

public class BSTToGreaterTree {

    public static TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convertBSTRecursion(root, new int[]{0});
        return root;
    }

    public static void convertBSTRecursion(TreeNode root, int[] sum) {
        if (root == null) return;
        convertBSTRecursion(root.right, sum);
        root.val += sum[0];
        sum[0] = root.val;
        convertBSTRecursion(root.left, sum);
    }

    public static void main(String a[]) {
        /*TreeNode root = new TreeNode(5,
                new TreeNode(2, null, null),
                new TreeNode(13, null, null));*/
        TreeNode root = new TreeNode(11,
                new TreeNode(7,
                        new TreeNode(5, null, null),
                        new TreeNode(9, null, null)),
                new TreeNode(13,
                        new TreeNode(12, null, null),
                        null));
        TreeNode result = convertBST(root);
        System.out.println(result);
    }
}
