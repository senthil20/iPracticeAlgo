package DataStructures.trees;

/*
Given a binary tree, find the largest subtree which is a Binary Search Tree (BST),
where largest means subtree with largest number of nodes in it.
Note:
A subtree must include all of its descendants.
Here's an example:
    10
    / \
   5  15
  / \   \
 1   8   7
The Largest BST Subtree in this case is the highlighted one.
The return value is the subtree's size, which is 3.
 */
public class LargestBSTSubTree {

    public static int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        int[] max = new int[]{0};
        int[] result = largestBSTSubtreeRecursive(root, max);
        return max[0];
    }

    public static int[] largestBSTSubtreeRecursive(TreeNode root, int[] max) {
        if (root == null) {
            return new int[]{0, 0, 0};// no.of nodes, left boundary, right boundary
        }
        int[] left = largestBSTSubtreeRecursive(root.left, max);
        int[] right = largestBSTSubtreeRecursive(root.right, max);

        if ((left[0] == 0 || left[0] > 0 && left[2] <= root.val) &&
                (right[0] == 0 || right[0] > 0 && right[1] >= root.val)) {
            int size = 1 + left[0] + right[0];
            max[0] = Math.max(size, max[0]);
            int leftBoundary = left[0] == 0 ? root.val : left[1];
            int rightBoundary = right[0] == 0 ? root.val : right[2];
            return new int[]{size, leftBoundary, rightBoundary};
        }
        else {
            return new int[]{-1, -1, -1};
        }
    }

    public static void main(String a[]) {
        TreeNode root = new TreeNode(10,
                new TreeNode(5,
                        new TreeNode(1, null, null),
                        new TreeNode(8, null, null)),
                new TreeNode(15,
                        null,
                        new TreeNode(7, null, null)));
        root = new TreeNode(19,
                new TreeNode(4,
                        new TreeNode(5,
                                new TreeNode(2,
                                        new TreeNode(1, null, null),
                                        new TreeNode(3, null, null)),
                                new TreeNode(6,
                                        null,
                                        new TreeNode(7, null, null))),
                        new TreeNode(12,
                                null,
                                new TreeNode(19, null, null))),
                new TreeNode(22,
                        new TreeNode(9, null, null),
                        new TreeNode(10,
                                null,
                                new TreeNode(8, null, null))));

        int result = largestBSTSubtree(root);
        System.out.print(result);
    }
}
