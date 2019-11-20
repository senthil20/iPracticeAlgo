package Revise.trees;

public class LCABTree {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) return null;
        if (root.val == p.val) {
            return p;
        }
        if (root.val == q.val) {
            return q;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left == null ? right: left;
    }

    public static void main(String a[]) {
        TreeNode node = new TreeNode(3,
                new TreeNode(5,
                        new TreeNode(6,null, null),
                        new TreeNode(2,
                                new TreeNode(7, null, null),
                                new TreeNode(4, null, null))),
                new TreeNode(1,
                        new TreeNode(0,null, null),
                        new TreeNode(8,null, null)));

        TreeNode result = lowestCommonAncestor(node,
                new TreeNode(0, null, null),
                new TreeNode(8, null, null));

        System.out.println(result);
    }
}
