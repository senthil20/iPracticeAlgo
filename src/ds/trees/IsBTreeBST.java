package ds.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 Eg 1: Given binary tree,

            5
          /   \
         4     7
       /      / \
      2      6  11
     / \       /  \
    1  3      8  12
*/

/*
 Eg 2: Given binary tree,

            5
          /   \
         4     7
       /      / \
      2      6  11
     / \       /  \
    1  10     8  12
*/
public class IsBTreeBST {
    int prev = -1;
    boolean flag = true;
    public boolean isBSTInOrder(TreeNode root) {

        if (root == null) {
            return true;
        }
        flag = isBSTInOrder(root.left);

        if (root != null && root.val < prev) return false;
        prev = root.val;

        if(flag) flag = isBSTInOrder(root.right);

        return flag;
    }

    public boolean isBST(TreeNode root, int min, int max) {

        if (root == null) return true;

        if (root.val <= min || root.val >= max) return false;

        boolean isLeft = isBST(root.left, min, root.val);
        boolean isRight = isBST(root.right, root.val, max);

        return  isLeft && isRight;
    }


    public int numberOfLeaves(TreeNode root) {

        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        int left = numberOfLeaves(root.left);
        int right = numberOfLeaves(root.right);

        return left + right;
    }

    public int sum(TreeNode root) {

        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;

        int left = sum(root.left);
        int right = sum(root.right);

        return left + right + root.val;
    }

    /**
          20
        /   \
      15    30
     /  \
    14  18

     output ==> true

        20
      /   \
     30    15
    /  \
   14  18

     output ==> false
     */
    public boolean isBSTIterative(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop(); //20, 15
            if (temp != null) {
                while (temp.left != null) {
                    stack.add(temp.left); //15, 14
                    if (temp.val < min && temp.val > max) return false;
                    max = temp.val;
                    continue;
                }
            }
            if (temp.right != null) {
                stack.add(temp.right);
                min = temp.val;
                if (temp.val < min && temp.val > max) return false;
            }
        }
        return true;
    }
    public static void main(String a[]){
        IsBTreeBST bst = new IsBTreeBST();
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
       /* TreeNode root = new TreeNode(20,
                new TreeNode(15,
                        new TreeNode(14, null, null),
                        new TreeNode(18, null, null)),
                new TreeNode(30,
                        null*//*new TreeNode(25, null, null)*//*,
                        new TreeNode(29, null, null)));*/

        root = new TreeNode(20,
                new TreeNode(15,
                        new TreeNode(14, null, null),
                        new TreeNode(18, null, null)),
                new TreeNode(30, null, null));
        System.out.println(bst.isBSTIterative(root));
        //System.out.println(bst.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        //System.out.println(bst.isBSTInOrder(root));
        //System.out.println(bst.numberOfLeaves(root));
        //System.out.println(bst.sum(root));
    }
}
