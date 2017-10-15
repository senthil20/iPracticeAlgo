package revise.trees;

/**
Input: 3, 5

       3
    /    \
   1      4
 /  \    / \
0    3  5   6
    /
   2

Output:
        3
       / \
      3  4
        /
       5

 */

/**
 Input: 1, 3

       3
     /  \
    0    4
    \
    2
   /
  1

 Output:
     3
    /
   2
  /
 1

 */
public class TrimBST {

    public static TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        if (root.val < L) return trimBST(root.right, L, R);
        if (root.val > R) return trimBST(root.left, L, R);
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
    public static void main(String a[]) {
        /*TreeNode root = new TreeNode(3,
                new TreeNode(1,
                        new TreeNode(0, null, null),
                        new TreeNode(3,
                                new TreeNode(2, null, null),
                                null)),
                new TreeNode(4,
                        new TreeNode(5, null, null),
                        new TreeNode(6, null, null)));*/
        TreeNode root = new TreeNode(3,
                new TreeNode(0,
                        null,
                        new TreeNode(2,
                                new TreeNode(1, null, null),
                                null)),
                new TreeNode(4,null,null));

        TreeNode result = trimBST(root, 1, 3);
        System.out.println(result);
    }
}
