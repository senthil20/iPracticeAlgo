package ds.trees;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 Given binary tree,

            5
          /   \
         4     7
       /      / \
      2      6  11
     / \       /  \
    1  3      8  12

 return its level order traversal as [[5], [4, 7], [2, 6, 11], [1, 3, 8, 12]]
*/
public class LevelOrderTraversal {

    //Using two queues 'current' and 'next'
    public List<List<Integer>> levelOrderTraversal(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> value = new ArrayList<>();

        Queue<TreeNode> current  = new LinkedList<>();
        Queue<TreeNode> next  = new LinkedList<>();

        current.add(root);

        while (!current.isEmpty()) {

            TreeNode temp = current.poll();
            value.add(temp.val);

            if (temp.left != null) next.add(temp.left);
            if (temp.right != null) next.add(temp.right);

            if (current.isEmpty()) {
                current = next;
                next = new LinkedList<>();
                result.add(value);
                value = new ArrayList<>();
            }
        }
        return result;
    }

    //Add an null queue once node visited. It indicates the end of current level
    public List<List<Integer>> levelOrderTraversal1(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> value = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();

            if (temp != null) {
                value.add(temp.val);
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            else {
                result.add(value);
                value = new ArrayList<>();
                if (!queue.isEmpty()) queue.add(null);
            }
        }
        return result;
    }

    //solution from other sources
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        levelOrder(root, result, 1);

        return result;
    }

    private void levelOrder(TreeNode node, ArrayList<ArrayList<Integer>> result, int level) {
        if (node == null) return;

        if (result.size() < level) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(node.val);
            result.add(temp);
        } else {
            result.get(level - 1).add(node.val);
        }

        levelOrder(node.left, result, level + 1);
        levelOrder(node.right, result, level + 1);
    }

    public static void main(String a[]) {

        LevelOrderTraversal lt = new LevelOrderTraversal();

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

        //List<List<Integer>> list = lt.levelOrderTraversal(root);
        //List<List<Integer>> list = lt.levelOrderTraversal1(root);
        lt.levelOrder(root);
    }
}