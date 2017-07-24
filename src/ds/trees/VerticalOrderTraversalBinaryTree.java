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
        new VerticalOrderTraversalBinaryTree().verticalOrderTraversal(root);
    }
}
