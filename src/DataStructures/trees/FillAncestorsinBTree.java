package DataStructures.trees;

import java.util.ArrayList;

/**
 * Created by sydgsk9 on 1/13/2017.
 */
public class FillAncestorsinBTree {

    /**
     Tree
        5
      /   \
     4     7
    /     / \
   2     6  11
  / \      /  \
 1  3     8  12

     output = true
     */
    public ArrayList<Integer> ancestorsList = new ArrayList<Integer>();
    public boolean printAncestors(TreeNode root, int nodeData) {
        if (root == null) return false;
        if (root.val == nodeData) {
            ancestorsList.add(root.val);
            return true;
        }
        boolean isLeft = false;
        boolean isRight = false;
        //if (root.left != null) {
            isLeft = printAncestors(root.left, nodeData);
            if (isLeft) {
                ancestorsList.add(root.val);
            }
        //}
       /// if (root.right != null) {
            isRight = printAncestors(root.right, nodeData);
            if (isRight) {
                ancestorsList.add(root.val);
            }
       // }
        return isLeft || isRight;
    }

    public static void main(String a[]) {
        BSTBasicOperations bst = new BSTBasicOperations();
        FillAncestorsinBTree fa = new FillAncestorsinBTree();
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
        fa.printAncestors(root, 11);
        System.out.println(fa.ancestorsList);
    }
}
