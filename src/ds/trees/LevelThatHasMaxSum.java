package ds.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 Given a binary tree, write a method to return the level that has the maximum sum. In case the tree is empty, return -1
 Example:
        1
       / \
      2   3
    / \  / \
   4  5 6  7
  /
 8

 Output ==> 2
 Note: Assume that root is at level 0.
 */

/**
           9
          /
         8
        /
       4
       \
        6

 output = 0
 */
public class LevelThatHasMaxSum {

    public static int findMaxSumLevel(TreeNode root) {
        if (root == null) return -1;
        Queue<TreeNode> curr = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();;
        curr.add(root);
        int levelsum = 0;
        int max = -1;
        int result = 0;
        int level = 0;
        while (!curr.isEmpty()) {
            TreeNode node = curr.poll();
            levelsum += node.val;
            if (node.left != null) next.add(node.left);
            if (node.right != null) next.add(node.right);
            if (curr.isEmpty()) {
                curr = next;
                next = new LinkedList<>();
                if (levelsum > max) {
                    max = levelsum;
                    result = level;
                }
                levelsum = 0;
                level++;
            }
        }
        return result;
    }

    public static void main(String a[]) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(8, null, null),
                                null),
                        new TreeNode(5, null, null)),
                new TreeNode(3,
                        new TreeNode(6, null, null),
                        new TreeNode(7, null, null)));

        root = new TreeNode(9,
                new TreeNode(8,
                        new TreeNode(4,
                                null,
                                new TreeNode(6, null, null)),
                        null),
                null);

        System.out.println(LevelThatHasMaxSum.findMaxSumLevel(root));
    }
}
