package ds.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Write a function to find the total number of half nodes in a binary tree.
 * A half node is a node which has exactly one child node. If there are no half nodes, return 0.
 */

/**
Tree
        5
      /   \
     4     7
    /     / \
   2     6  11
  / \      /  \
 1  3     8  12

 output = 1
 */
public class HalfNodes {

    public int numberOfHalfNodes(TreeNode root) {
        if (root == null) return 0;
        else {
            if (root.left == null && root.right != null) return 1 + numberOfHalfNodes(root.right);
            if (root.left != null && root.right == null) return 1 + numberOfHalfNodes(root.left);
        }
        return numberOfHalfNodes(root.left) + numberOfHalfNodes(root.right);
    }

    public int numberOfHalfNodesQueue(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int count = 0;
        TreeNode curr = null;
        while(!q.isEmpty()) {
            curr = q.remove();
            if(curr.left == null && curr.right != null || curr.left != null && curr.right == null) {
                count++;
            }
            if(curr.left != null)
                q.add(curr.left);
            if(curr.right != null)
                q.add(curr.right);
        }
        return count;
    }

    public static void main(String a[]) {
        HalfNodes hn = new HalfNodes();
        TreeNode root = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(2,
                                new TreeNode(1, null, null),
                                null),
                        null),
                new TreeNode(7,
                        new TreeNode(6, null, null),
                        new TreeNode(11,
                                new TreeNode(8, null, null),
                                new TreeNode(12, null, null))));
        root = new TreeNode(3,
                            null,
                new TreeNode(9,
                        new TreeNode(4, null, null),
                        null));

        System.out.println(hn.numberOfHalfNodes(root));

    }
}