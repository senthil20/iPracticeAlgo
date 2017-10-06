package revise.trees;

/**
 *
 */
public class StringFromBinaryTree {

    public static void tree2str(TreeNode t, StringBuffer sb) {
        if (t == null) return;
        sb.append(t.val);
        if (t.left == null && t.right != null) {
            sb.append("()");
        }
        if (t.left != null) {
            tree2str(t.left, sb.append("("));
            sb.append(")");
        }
        if (t.right != null) {
            tree2str(t.right, sb.append("("));
            sb.append(")");
        }
    }

    public static void main(String a[]) {
        /*TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4, null, null),
                        null),
                new TreeNode(3, null, null));*/
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        null,
                        new TreeNode(4, null, null)),
                new TreeNode(3, null, null));
        StringBuffer sb = new StringBuffer();
        tree2str(root, sb);
        System.out.println(sb.toString());
    }
}
