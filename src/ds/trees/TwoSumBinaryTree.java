package ds.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/** Input tree, key
 *           5
 *         /   \
 *        4     7
 *       /     / \
 *      2     6   11
 *    / \        /  \
 *   1   3      8   12
 *
 *   Output, list of two nodes equals key
 */
public class TwoSumBinaryTree {

    public List<String> inorder(TreeNode root1, TreeNode root2, int k) {

        List<String> list = new ArrayList<>();
        if (root1 == null || root2 == null) return list;
        boolean loop1 = true;
        boolean loop2 = true;
        int leftVal = 0;
        int rightVal = 0;
        Stack<TreeNode> leftSt = new Stack<>();
        Stack<TreeNode> rightSt = new Stack<>();

        while(true) {
            while (loop1) {
                if (root1 != null) {
                    while (root1 != null) {
                        leftSt.push(root1);
                        root1 = root1.left;
                    }
                }
                else {
                    if (!leftSt.isEmpty()) {
                        TreeNode temp = leftSt.pop();
                        leftVal = temp.val;
                        root1 = temp.right;

                    }
                    loop1 = false;
                }
            }

            while (loop2) {
                if (root2 != null) {
                    while (root2 != null) {
                        rightSt.push(root2);
                        root2 = root2.right;
                    }
                }
                else {
                    if (!rightSt.isEmpty()) {
                        TreeNode temp = rightSt.pop();
                        rightVal = temp.val;
                        root2 = temp.left;
                    }
                    loop2 = false;
                }
            }

            if (leftVal >= rightVal) break;

            if (leftVal + rightVal == k) {
                list.add(leftVal + "," + rightVal);
                loop1 = loop2 = true;
                continue;
            }
            if (leftVal + rightVal > k) {
                loop2 = true;
            }
            else {
                loop1 = true;
            }
        }
        return list;
    }

    public static void main(String a[]) {
        TwoSumBinaryTree twosum = new TwoSumBinaryTree();
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
        twosum.inorder(root, root, 0);
    }
}
