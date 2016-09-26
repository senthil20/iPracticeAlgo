package ds.trees;

/**
 * Created by senthil on 24/9/16.
 */
public class BalancedBST {

    //tc: o(n)
    //worst case for skew binary tree o(n^2)
    //if -2 return false else true
    public int isHeightBalancedBST(TreeNode root) {

        if (root == null) return -1;

        int l = isHeightBalancedBST(root.left);
        int r = isHeightBalancedBST(root.right);

        if (l == -2 || r == -2) return -2;

        if (Math.abs(l - r) > 1) {
            return -2;
        }
        return Math.max(l, r) + 1;
    }

    public static void main(String a[]) {
        BalancedBST bst = new BalancedBST();
        //int[] ar = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 11, 12};
        //TreeNode root = new BSTBasicOperations().buildTreeSortedArray(new TreeNode(), ar, 0, ar.length - 1);
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
        bst.isHeightBalancedBST(root);
    }

}