package DataStructures.trees;

/**
 * Given the below binary tree.Find max path sum.
          5
         / \
        4   8
       /   / \
     11   16  4
    /  \    / \
   7    2  5   1

Paths are
 [
 [5,4,11,7],
 [5,4,11,2],
 [5,8,16],
 [5,8,4,5],
 [5,8,4,1]
 ]
 So max is [5, 8, 6]
 **/
public class MaximumSumPath {

    public int maxSumPath(TreeNode root) {
        if (root == null) return 0;
        int left = maxSumPath(root.left);
        int right = maxSumPath(root.right);
        return root.val + Math.max(left, right);
    }

    public static void main(String a[]) {
        MaximumSumPath msum = new MaximumSumPath();
        TreeNode root = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11,
                                new TreeNode(7, null, null),
                                new TreeNode(2, null, null)),
                        null),
                new TreeNode(8,
                        new TreeNode(16, null, null),
                        new TreeNode(4,
                                new TreeNode(5, null, null),
                                new TreeNode(1, null, null))));
        System.out.print(msum.maxSumPath(root));

    }
}
