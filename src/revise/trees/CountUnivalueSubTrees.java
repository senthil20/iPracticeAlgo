package revise.trees;

/**
 Given a binary tree, count the number of uni-value subtrees.
 A Uni-value subtree means all nodes of the subtree have the same value.
 Example :
 Input:  root = [5,1,5,5,5,null,5]
        5
      /  \
     1    5
   / \    \
  5   5    5
 Output: 4
 */

public class CountUnivalueSubTrees {
    public int countUnivalSubtrees(TreeNode root) {
        int[] result = new int[]{0};
        countUnivalSubtrees(root, result);
        return result[0];
    }

    public boolean countUnivalSubtrees(TreeNode root, int[] result) {
        if (root == null) return true;
        if (root.left == null && root.right == null) {
            result[0]++;
            return true;
        }
        boolean left = countUnivalSubtrees(root.left, result);
        boolean right = countUnivalSubtrees(root.right, result);
        if (left == false || right == false) {
            return false;
        }
        if (root.left != null && root.val != root.left.val
                || root.right != null && root.val != root.right.val) {
            return false;
        }
        result[0]++;
        return true;
    }

    public static void main(String a[]) {
        CountUnivalueSubTrees cu = new CountUnivalueSubTrees();
        TreeNode node = new TreeNode(5,
                new TreeNode(1,
                        new TreeNode(5, null, null),
                        new TreeNode(5, null, null)),
                new TreeNode(5, null,
                        new TreeNode(5, null, null)));
        int res = cu.countUnivalSubtrees(node);
        System.out.println(res);
    }
}
