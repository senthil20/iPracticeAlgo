package ds.trees;

import java.util.LinkedList;
import java.util.Queue;

/** Input = tree
 *           5
 *         /   \
 *        4     7
 *       /     / \
 *      2     6   11
 *    / \        /  \
 *   1   3      8   12
 *
 * Output = 2 ( 5 --> 7 --> 6)
 */
public class MinDepthOfBinaryTree {

    public int minDepthRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = minDepthRecursive(root.left);
        int right = minDepthRecursive(root.right);

        return Math.min(left, right) + 1;
    }


    public int minDepth(TreeNode root) {

        if (root == null) return -1;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> counts = new LinkedList<>();

        queue.add(root);
        counts.add(0);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            int count = counts.poll();

            if (temp.left != null) {
                queue.add(temp.left);
                counts.add(count + 1);
            }
            if (temp.right != null) {
                queue.add(temp.right);
                counts.add(count + 1);
            }

            if (temp.left == null && temp.right == null) return count;
        }
        return -1;
    }
    public static void main(String a[]) {
        MinDepthOfBinaryTree md = new MinDepthOfBinaryTree();
        TreeNode root = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(2,
                                new TreeNode(1, null, null),
                                new TreeNode(3, null, null)),
                        null),
                new TreeNode(7,
                        null/*new TreeNode(6, null, null)*/,
                        null/*new TreeNode(11,
                                new TreeNode(8, null, null),
                                new TreeNode(12, null, null))*/));

        //System.out.println(md.minDepth(root));
        System.out.println(md.minDepthRecursive(root));
    }

}
