package DataStructures.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by senthil on 25/9/16.
 */
/*
* the tree...
       4
      / \
     2   5
    / \
   1   3

 is changed to...
       4
      / \
     5   2
        / \
       3   1
*
* */
public class InvertTree {

    //solution:1
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        invertTree(root.left);
        invertTree(root.right);
        swap(root);
        return root;
    }

    public void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    //solution:2
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.left != null) {
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
            }
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
        }
        return root;
    }

    public static void main(String a[]) {
        InvertTree mt = new InvertTree();
        TreeNode root = new TreeNode(4,
                                new TreeNode(2,
                                        new TreeNode(1, null, null),
                                        new TreeNode(3, null, null)),
                                new TreeNode(5, null, null));
        mt.invertTree1(root);
        System.out.println(root);
    }
 }
