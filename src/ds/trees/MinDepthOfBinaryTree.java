package ds.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by senthil on 26/9/16.
 */
public class MinDepthOfBinaryTree {

    //Brute force not advisable, think if there is one node in left and thousands in right.
    public int minDepthOfBinaryTree(TreeNode root) {

        if (root == null) return 0;

        if (root.left == null && root.right == null) return 1;

        if (root.left == null)
            return minDepthOfBinaryTree(root.right);

        if (root.right == null)
            return minDepthOfBinaryTree(root.left);

        return Math.min(minDepthOfBinaryTree(root.left), minDepthOfBinaryTree(root.right)) + 1;
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

        /*TreeNode root = new TreeNode(5,
                new TreeNode(4,
                        null,
                        new TreeNode(2, null, null)),
                new TreeNode(7,
                        new TreeNode(6, null, null),
                        new TreeNode(11,
                                new TreeNode(8, null, null),
                                new TreeNode(12, null, null))));*/
        TreeNode root = new TreeNode(5,
                new TreeNode(4,
                        null,
                        null),
                new TreeNode(7,
                        new TreeNode(8, null, null),
                        new TreeNode(10, null, null)));

        //System.out.println(md.minDepthOfBinaryTree(root));
        System.out.println(md.minDepthOfBinaryTree1(root));
    }
}
