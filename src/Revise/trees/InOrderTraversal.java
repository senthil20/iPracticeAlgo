package Revise.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {

    public static List<Integer> inorderTraversalIterative(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty() || root != null) {
            if (root != null && root.left != null) {
                pushLeft(root, stack);
            }
            TreeNode temp = stack.pop();
            result.add(temp.val);
            if (temp.right != null) {
                stack.push(temp.right);
            }
            root = temp.right;
        }
        return result;
    }

    public static void pushLeft(TreeNode root, Stack st) {
        while (root != null && root.left != null) {
            st.push(root.left);
            root = root.left;
        }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        inorderRecursion(root, result);
        return result;
    }

    public static void inorderRecursion(TreeNode root, List<Integer> result) {
        if (root == null) return;
        inorderRecursion(root.left, result);
        result.add(root.val);
        inorderRecursion(root.right, result);
    }

    public static void main(String a[]) {
        TreeNode node = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1, null, null),
                        new TreeNode(3, null, null)),
                new TreeNode(6,
                        new TreeNode(5, null, null),
                        new TreeNode(7, null, null)));
        List<Integer> result = inorderTraversalIterative(node);
        System.out.println(result);
    }
}
