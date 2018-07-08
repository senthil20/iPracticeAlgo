package ds.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
Note: A leaf is a node with no children.
Example:
Given binary tree [3,9,20,null,null,15,7],
     3
    / \
   9  20
     /  \
    15  7
 return its minimum depth = 2

        5
      /   \
     4     7
    / \     \
   2  4     11
  / \      /  \
 1  3     8  12

 output = 2
*/

public class MinDepthOfBinaryTree {

    //solution:1
    public int minDepth(TreeNode a) {
        if (a == null) {
            return 0;
        }
        if (a.left == null && a.right == null) {
            return 1;
        }
        int left = (a.left != null) ? minDepth(a.left) : Integer.MAX_VALUE;
        int right = (a.right != null) ? minDepth(a.right) : Integer.MAX_VALUE;
        return 1 + Math.min(left, right);
    }

    //solution:2, using level order
    public int minDepthOfBinaryTree(TreeNode a) {
        if (a == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        q.add(a);
        int level = 1;
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            if (n.left == null && n.right == null) return level;
            if (n.left != null) {
                next.add(n.left);
            }
            if (n.right != null) {
                next.add(n.right);
            }
            if (q.isEmpty()) {
                q = next;
                next = new LinkedList<>();
                level++;
            }
        }
        return level;
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
                        null,
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