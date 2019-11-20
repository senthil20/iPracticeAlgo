package Revise.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
Given two binary trees and imagine that when you put one of them to cover the other,
some nodes of the two trees are overlapped while the others are not.
You need to merge them into a new binary tree. The merge rule is that if two nodes overlap,
then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

 Input:
    Tree 1                     Tree 2
        1                         2
       / \                       / \
      3   2                     1   3
     /                           \   \
    5                             4   7
 Output:
 Merged tree:
        3
       / \
      4   5
     / \   \
    5   4   7
 */
public class MergeTwoBinaryTrees {

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);
        return root;
    }

    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        t1.val += t2.val;
        t1.left = mergeTrees2(t1.left, t2.left);
        t1.right = mergeTrees2(t1.right, t2.right);
        return t1;
    }

    public static TreeNode mergeTrees1(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.add(new TreeNode[]{t1, t2});
        TreeNode parent = null;
        while (!queue.isEmpty()) {
            TreeNode[] temp = queue.poll();
            if (temp[0] == null || temp[1] == null) {
                continue;
            }
            temp[0].val += temp[1].val;

            if (temp[0].left == null) {
                temp[0].left = temp[1].left;
            } else {
                queue.add(new TreeNode[]{temp[0].left, temp[1].left});
            }

            if (temp[0].right == null) {
                temp[0].right = temp[1].right;
            } else {
                queue.add(new TreeNode[]{temp[0].right, temp[1].right});
            }
        }
        return t1;
    }

    public static void main(String a[]) {

        TreeNode node1 = new TreeNode(1,
                new TreeNode(3,
                        new TreeNode(5, null, null),
                        null),
                new TreeNode(2, null, null));

        TreeNode node2 = new TreeNode(2,
                new TreeNode(1,
                        null,
                        new TreeNode(4, null, null)),
                new TreeNode(3, null,
                        new TreeNode(7, null, null)));

        TreeNode result = mergeTrees1(node1, node2);
        System.out.println(result);
    }
}
