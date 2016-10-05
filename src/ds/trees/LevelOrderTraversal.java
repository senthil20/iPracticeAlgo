package ds.trees;

import java.util.*;

/** Input = tree
 *           5
 *         /   \
 *        4     7
 *       /     / \
 *      2     6   11
 *    / \        /  \
 *   1   3      8   12
 *
 * Output = { {5},
 *            {4, 7},
 *            {2, 6, 11}
 *            {1, 3, 8, 12}
 *          }
 */
public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) return null;

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        Queue<TreeNode> curr = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();

        curr.add(root);

        while (!curr.isEmpty()) {
            TreeNode temp = curr.poll();
            list.add(temp.val);

            if (temp.left != null) {
                next.add(temp.left);
            }
            if (temp.right != null) {
                next.add(temp.right);
            }

            if (curr.isEmpty()) {
                result.add(list);
                list = new ArrayList<>();
                curr = next;
                next = new LinkedList<>();
            }
        }
        return result;
    }


    public static void main(String s[]) {
        LevelOrderTraversal lo = new LevelOrderTraversal();

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
        List<List<Integer>> list = lo.levelOrder(root);
        System.out.println(list);
    }
}