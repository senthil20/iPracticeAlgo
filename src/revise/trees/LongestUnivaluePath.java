package revise.trees;

public class LongestUnivaluePath {



    public int longestUnivaluePath(TreeNode root) {
        int[] result = new int[]{0};
        longestUnivaluePath(root, result);
        return result[0];
    }

    public int longestUnivaluePath(TreeNode node, int[] result) {
       return 0;
    }

    public static void main(String a[]) {
        LongestUnivaluePath lup = new LongestUnivaluePath();
        TreeNode node = new TreeNode(1,
                new TreeNode(4,
                        new TreeNode(4, null, null),
                        new TreeNode(4, null, null)),
                new TreeNode(5, null,
                        new TreeNode(5, null, null)));
        node = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(3, null, null),
                        new TreeNode(3, /* ************/
                                null,
                                new TreeNode(3,
                                        null,
                                        new TreeNode(3,
                                                null,
                                                new TreeNode(3, null, null))))),
                new TreeNode(4, null, null));

        node = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(1, null, null),
                        new TreeNode(1, null, null)),
                new TreeNode(5,
                        null,
                        new TreeNode(5, null, null)));

        /*node = new TreeNode(4,
                new TreeNode(6, null, null),
                new TreeNode(5,
                        null,
                        new TreeNode(5,
                                null,
                                new TreeNode(5, null, null))));*/
        int res = lup.longestUnivaluePath(node);
        System.out.println(res);
    }
}
