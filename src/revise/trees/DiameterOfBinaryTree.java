package revise.trees;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 * Example:
 Given a binary tree
           8
        /     \
      4        11
    /  \      / \
   2   6    10  13
 / \           /
1  3         12


 Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class DiameterOfBinaryTree {
    static int sum = 0;

    /**
                1
              /   \
             2     3
           /  \
          4   5
     */
    public static int diameterOfBinaryTree1(TreeNode root) {
        int[] result = new int[]{0, 0};
        dfs1(root, result);
        return result[0];
    }

    public static int[] dfs1(TreeNode root, int[] result) {
        if (root == null) return new int[]{0, 0};
        int[] left = dfs1(root.left, result);
        int[] right = dfs1(root.right, result);
        result[0] = Math.max(result[0], left[1] + right[1]);
        result[1] = Math.max(left[1], right[1]) + 1;
        return result;

    }

    public static int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return sum;
    }

    public static int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        sum = Math.max(sum, left + right);
        return Math.max(left, right) + 1;
    }

    public static void main(String a[]) {
        /*TreeNode node = new TreeNode(8,
                new TreeNode(4,
                        new TreeNode(2,
                                new TreeNode(1, null, null),
                                new TreeNode(3, null, null)),
                        new TreeNode(6, null,null)),
                new TreeNode(11,
                        new TreeNode(10, null, null),
                        new TreeNode(13,
                                new TreeNode(12, null, null),
                                null)));*/
        TreeNode node = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4, null, null),
                        new TreeNode(5, null, null)),
                new TreeNode(3, null, null));
        int sum = diameterOfBinaryTree1(node);
        System.out.println(sum);
    }
}
