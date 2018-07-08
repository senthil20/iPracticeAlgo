package ds.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 For example:
 Given binary tree [3,9,20,null,null,15,7],
     3
    / \
   9  20
  / \
 15  7
 return its zigzag level order traversal as:
 [
    [3],
    [20,9],
    [15,7]
 ]
 */
public class ZigZagTraversalBT {

    //my leetcode solution
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> curr = new Stack<>();
        Stack<TreeNode> next = new Stack<>();
        curr.add(root);
        int level = 0;
        while (!curr.isEmpty()) {
            TreeNode temp = curr.pop();
            list.add(temp.val);
            if (level % 2 == 0) {
                if (temp.left != null) next.add(temp.left);
                if (temp.right != null) next.add(temp.right);
            }
            else {
                if (temp.right != null) next.add(temp.right);
                if (temp.left != null) next.add(temp.left);
            }
            if (curr.isEmpty()) {
                result.add(list);
                list = new ArrayList<>();
                level++;
                curr = next;
                next = new Stack<>();
            }
        }
        return result;
    }
    //better runtime than the above
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder1(TreeNode a) {
        if (a == null) return null;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(a);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()) {
                TreeNode temp = s1.pop();
                list.add(temp.val);

                if (temp.left != null) {
                    s2.push(temp.left);
                }
                if (temp.right != null) {
                    s2.push(temp.right);
                }
            }
            if (list.size() != 0) {
                result.add(list);
                list = new ArrayList<>();
            }
            while (!s2.isEmpty()) {
                TreeNode temp = s2.pop();
                list.add(temp.val);

                if (temp.right != null) {
                    s1.push(temp.right);
                }
                if (temp.left != null) {
                    s1.push(temp.left);
                }
            }
            if (list.size() != 0) {
                result.add(list);
                list = new ArrayList<>();
            }
        }
        return result;
    }


    public static List<List<Integer>> zigzagLevelOrderNOW(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        Stack<TreeNode> next = new Stack<>();
        st.push(root);
        boolean traverseLeft = true;
        while (!st.isEmpty()) {
            TreeNode temp = st.pop();
            list.add(temp.val);

            if (traverseLeft) {
                if (temp.left != null) {
                    next.add(temp.left);
                }
                if(temp.right != null) {
                    next.add(temp.right);
                }
            }
            else {
                if(temp.right != null) {
                    next.add(temp.right);
                }
                if (temp.left != null) {
                    next.add(temp.left);
                }
            }

            if (st.isEmpty()) {
                result.add(list);
                list = new ArrayList<>();
                traverseLeft = !traverseLeft;
                st = next;
                next = new Stack<>();
            }
        }
        return result;
    }

    public static void main(String a[]){
        ZigZagTraversalBT zig = new ZigZagTraversalBT();
        TreeNode root = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(2,
                                new TreeNode(1, null, null),
                                new TreeNode(3, null, null)),
                        null),
                new TreeNode(7,
                        new TreeNode(6, null, null),
                        new TreeNode(11,
                                new TreeNode(8, null, null),
                                new TreeNode(12, null, null))));
        //zig.zigzagLevelOrder(root);
        zigzagLevelOrderNOW(root);

    }

}
