package revise.trees;

import java.util.*;

/**
 root = [5,3,6,2,4,null,7]
 key = 3
      5
    /  \
   3    6
  / \    \
 2   4    7
 */

public class BinaryTreeTilt {

    public static List<List<Integer>> printBottomUp(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> curr = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        curr.offer(root);
        while (!curr.isEmpty()) {
            TreeNode temp = curr.poll();
            list.add(temp.val);
            if (temp.left != null) {
                next.offer(temp.left);
            }
            if (temp.right != null) {
                next.offer(temp.right);
            }
            if (curr.isEmpty()) {
                curr = next;
                next = new LinkedList<>();
                result.add(0, list);
                list = new ArrayList<>();
            }
        }

        return result;
    }

    static int sum = 0;

    public static int findTilt(TreeNode root) {
        if (root == null) return 0;
        findTilt(root.left);
        findTilt(root.right);
        int diff = (root.left != null ? root.left.val : 0) - (root.right != null ? root.right.val : 0);
        sum += Math.abs(diff);
        return sum;
    }

    public static void main(String a[]) {
        TreeNode node = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2, null, null),
                        new TreeNode(4, null, null)),
                new TreeNode(6, null,
                        new TreeNode(7, null, null)));

        //findTilt(node);
        //System.out.println(sum);
        List<List<Integer>> result = printBottomUp(node);
        System.out.println(result);
    }

}
