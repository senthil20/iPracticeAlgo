package ds.trees;

/**
 Given the root of a Binary Tree  and 2 integers that represent the data values of any two TreeNodes present in the tree,
 write a method - getNodeDistance that returns the distance between the nodes.
 You can assume that the given keys exist in the tree.
 The distance between two nodes is defined as the minimum number of edges that must be traversed to travel between the two nodes.

 Example:
    1
   / \
  2   3
  \   \
  4   5
 getNodeDistance(2,5) => 3
 */

public class DistanceBetweenNodesinBT {
    /**
     Tree
            1
          /   \
         2     6
        /     / \
      11     3  14
     / \    /  /  \
    8  12  9  5    4

     LCA of 3, 4 is 6
     LCA of 11, 3 is 1
     LCA of 9, 14 is 6
     LCA of 12, 4 is 1
     */
    public int lcaBT(TreeNode root, int A, int B) {

        if (root == null) return -1;
        if (root.val == A) {
            return A;
        }
        if (root.val == B) {
            return B;
        }
        int left = lcaBT(root.left, A, B);
        int right = lcaBT(root.right, A, B);

        if (left != -1 && right != -1) return root.val;
        return left == -1 ? right : left;
    }

    public int findDistanceBetweenNodes(TreeNode root, int A, int B) {
        int distanceA = findHeight(root, A, 0);
        int distanceB = findHeight(root, B, 0);
        int lca = lcaBT(root, A, B);
        int lcaDistance = findHeight(root, lca, 0);
        int finalDistance = distanceA + distanceB - (2 * lcaDistance);
        return finalDistance;
    }

    public int findHeight(TreeNode root, int key, int count) {
        if (root == null) return 0;
        if (root.val == key) {
            return count;
        }
        int left = findHeight(root.left, key, count + 1);
        //int right = findHeight(root.right, key, count + 1);
        return left == 0 ? findHeight(root.right, key, count + 1) : left;
    }


    public static void main(String a[]) {

        DistanceBetweenNodesinBT dn = new DistanceBetweenNodesinBT();
        TreeNode btroot = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(11,
                                new TreeNode(8, null, null),
                                new TreeNode(12, null, null)),
                        null),
                new TreeNode(6,
                        new TreeNode(3,
                                new TreeNode(9, null, null),
                                null),
                        new TreeNode(14,
                                new TreeNode(5, null, null),
                                new TreeNode(4, null, null))));
        //System.out.println(dn.lcaBT(btroot, 9, 4));
        //System.out.println(dn.findHeight(btroot, 9, 0));
        System.out.println(dn.findDistanceBetweenNodes(btroot, 2, 6));
    }
}
