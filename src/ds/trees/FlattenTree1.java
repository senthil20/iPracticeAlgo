package ds.trees;

public class FlattenTree1 {

    public static void flatten(TreeNode root) {
        flattenTree(root);
    }

    public static TreeNode flattenTree(TreeNode root) {
        if (root == null) return root;
        TreeNode temp = root.right;
        if (root.left != null) {
            root.right = root.left;
            root.left = null;
            flattenTree(root.right);
            while (root.right != null) {
                root = root.right;
            }
            root.right = temp;
        }
        flattenTree(root.right);
        return root;
    }

    public static void main(String a[]) {
        TreeNode node = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4, null, null),
                        new TreeNode(5, null, null)),
                new TreeNode(3,
                        new TreeNode(6, null, null),
                        new TreeNode(7, null, null)));

        node = new TreeNode(1,
                new TreeNode(2, null, null),
                new TreeNode(3,
                        new TreeNode(4, null, null),
                        null));
        /*node = new TreeNode(1,
                null,
                new TreeNode(2,
                        new TreeNode(3, null, null),
                        null));*/
        flatten(node);
        System.out.println(node);
    }
}
