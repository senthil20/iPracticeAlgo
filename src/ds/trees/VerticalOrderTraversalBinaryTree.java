package ds.trees;

import java.util.*;

/**
 * Given a binary tree, print a vertical order traversal of it.
 Example :
 Given binary tree:
         6
       /   \
     3      7
   / \       \
  2   5       9

 returns
 [
    [2],
    [3],
    [6 5],
    [7],
    [9]
 ]
 */
public class VerticalOrderTraversalBinaryTree {

    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Map<Integer, List<Integer>> map = new TreeMap<>();
        verticalOrder(root, map, 0);
        result = new ArrayList<>(map.values());
        return result;
    }

    public static void verticalOrder(TreeNode root, Map<Integer, List<Integer>> map, int pos) {
        if (root == null) return;
        if (map.containsKey(pos)) {
            map.get(pos).add(root.val);
        }
        else {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            map.put(pos, list);
        }
        verticalOrder(root.left, map, pos - 1);
        verticalOrder(root.right, map, pos + 1);
    }




    class NodeWithPosition {
        TreeNode node;
        int position;
        NodeWithPosition(TreeNode n, int pos) {
            this.node = n;
            this.position = pos;
        }
    }

    /**
            5
          /   \
         4     7
        /     / \
       2     6  11
      / \        \
     1  3        12
     */

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (A == null) return result;
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        Queue<NodeWithPosition> queue = new LinkedList<>();
        queue.add(new NodeWithPosition(A, 0));

        while (!queue.isEmpty()) {
            NodeWithPosition n = queue.poll();
            if (map.containsKey(n.position)) {
                map.get(n.position).add(n.node.val);
            }
            else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(n.node.val);
                map.put(n.position, temp);
            }

            if (n.node.left != null) {
                queue.add(new NodeWithPosition(n.node.left, n.position - 1));
            }
            if (n.node.right != null) {
                queue.add(new NodeWithPosition(n.node.right, n.position + 1));
            }
        }

        for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    public static void main(String a[]) {

        List<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(2);
        System.out.print(list);
        TreeNode root = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(2,
                                new TreeNode(1, null, null),
                                new TreeNode(3, null, null)),
                        null),
                new TreeNode(7,
                        new TreeNode(6, null, null),
                        new TreeNode(11,
                                new TreeNode(10, null, null),
                                new TreeNode(12, null, null))));
        root = new TreeNode(6,
                new TreeNode(3,
                        new TreeNode(2, null, null),
                        new TreeNode(5, null, null)),
                new TreeNode(7,
                        null,
                        new TreeNode(9, null, null)));

        root = new TreeNode(3,
                new TreeNode(9,
                        new TreeNode(4, null, null),
                        new TreeNode(0,
                                null,
                                new TreeNode(2, null, null))),
                new TreeNode(8,
                        new TreeNode(1,
                                new TreeNode(5, null, null),
                                null),
                        new TreeNode(7, null, null)));

        verticalOrder(root);
        //new VerticalOrderTraversalBinaryTree().verticalOrderTraversal(root);
    }
}
