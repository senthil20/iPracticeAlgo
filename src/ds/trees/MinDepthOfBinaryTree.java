package ds.trees;

import java.util.LinkedList;
import java.util.Queue;

/** Tree
        5
      /   \
     4     7
    / \   / \
   2  4  6  11
  / \      /  \
 1  3     8  12

 output = 2
 */
public class MinDepthOfBinaryTree {

    //Brute force not advisable, think if there is one node in left and thousands in right.
    public int minDepth(TreeNode root) {

        if (root == null) return -1;

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        if (root.left == null) {
            return 1 + rightDepth;
        } else if (root.right == null) {
            return 1 + leftDepth;
        }

        return 1 + Math.min(leftDepth, rightDepth);
    }

    //We can solve this using level order
    public int minDepthOfBinaryTree1(TreeNode root) {

        if (root == null) return 0;

        Queue<TreeNode> current = new LinkedList<>();
        Queue<Integer> counts = new LinkedList<>();

        current.add(root);
        counts.add(0);

        while (!current.isEmpty()) {

            TreeNode node = current.poll();
            int count = counts.poll();

            if (node.left != null) {
                current.add(node.left);
                counts.add(count+1);
            }

            if (node.right != null) {
                current.add(node.right);
                counts.add(count+1);
            }

            if (node.left == null && node.right == null) {
                return count;
            }
        }
        return 0;
    }

    public static void main(String a[]) {

        MinDepthOfBinaryTree md = new MinDepthOfBinaryTree();

        TreeNode root = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(2,
                                new TreeNode(1, null, null),
                                new TreeNode(3, null, null)),
                        new TreeNode(4, null, null)),
                new TreeNode(7,
                        new TreeNode(6, null, null),
                        new TreeNode(11,
                                new TreeNode(8, null, null),
                                new TreeNode(12, null, null))));

        /*TreeNode root = new TreeNode(5,
                new TreeNode(4,
                        null,
                        null),
                new TreeNode(7,
                        new TreeNode(8, null, null),
                        new TreeNode(10, null, null)));*/

        //System.out.println(md.minDepthOfBinaryTree(root));
        System.out.println(md.minDepth(root));
    }
}
