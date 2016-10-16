package ds.trees;

import java.util.ArrayList;
import java.util.Stack;

/*
 Given binary tree,

            5
          /   \
         4     7
       /      / \
      2      6  11
     / \       /  \
    1  3      8  12
*/
public class IsBTreeBST {

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode a) {

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
        bst.zigzagLevelOrder(root);

    }
}
