package ds.trees;

import java.util.*;

/**
 Traverse a given binary tree in the Reverse Level Order. Mark a node as visited by adding its data to an ArrayList which will be returned.
 Example:
        1
       / \
      2   3
     / \ / \
    4  5 6  7

 Output => 4567231
 */
public class ReverseLevelOrderTraversal {

    public static ArrayList<Integer> levelorderRev(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            stack.push(node.val);
            if (node.right != null) queue.add(node.right);
            if (node.left != null) queue.add(node.left);
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    public static void main(String a[]) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4, null, null),
                        new TreeNode(5, null, null)),
                new TreeNode(3,
                        new TreeNode(6, null, null),
                        new TreeNode(7, null, null)));
        ArrayList<Integer> list = ReverseLevelOrderTraversal.levelorderRev(root);
    }
}
