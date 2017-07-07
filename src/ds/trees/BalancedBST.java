package ds.trees;

/**
Tree
        5
      /   \
     4     7
    /     / \
   2     6  11
  / \      /  \
 1  3     8  12

output = true
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

    int count = 0;

    public int kthsmallest(TreeNode root, int k) {

        if (root == null) return 0;

        return kthsmallestRecursive(root, k, -1);

    }

    public int kthsmallestRecursive(TreeNode root, int k, int value) {

        if (root == null) return value;

        if (count < k) value = kthsmallestRecursive(root.left, k, value);

        count++;

        if(k == count) {
            return root.val;
        }

        if (count < k) value = kthsmallestRecursive(root.right, k, value);

        return value;
    }

    /**
          1
        /   \
       2     3
     /  \   / \
    4   5  6   7
   / \
  8  9

        3
         \
          9
         /
        4

        5
      /   \
     4     7
    /     / \
   2     6  11
  / \        \
 1  3        12
  */

    public int numberOfHalfNodes(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 0;
        if ((root.left != null && root.right == null) ||(root.left == null && root.right != null)) return 1;
        return numberOfHalfNodes(root.left) + numberOfHalfNodes(root.right);
    }

    public int numberOfFullNodes(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 0;
        if (root.left != null && root.right == null) return numberOfFullNodes(root.left);
        if (root.left == null && root.right != null) return numberOfFullNodes(root.right);
        return 1 + numberOfFullNodes(root.left) + numberOfFullNodes(root.right);
    }


    public TreeNode findMin(TreeNode root) {
        if ((root.left == null && root.right == null) || (root.left == null && root.right != null)) return root;
        return findMin(root.left);
    }

    public static void main(String a[]) {
        BalancedBST bst = new BalancedBST();
        //int[] ar = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 11, 12};
        //TreeNode root = new BSTBasicOperations().buildTreeSortedArray(new TreeNode(), ar, 0, ar.length - 1);
        TreeNode root = new TreeNode(5,
                                    new TreeNode(4,
                                            new TreeNode(2,
                                                    null,
                                                    new TreeNode(3, null, null)),
                                            null),
                                    new TreeNode(7,
                                            new TreeNode(6, null, null),
                                            new TreeNode(11,
                                                    null,
                                                    new TreeNode(12, null, null))));
        /*root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(8, null, null),
                                new TreeNode(9, null, null)),
                        new TreeNode(5,null, null)),
                new TreeNode(3,
                        new TreeNode(6, null, null),
                        new TreeNode(7, null, null)));*/
        /*root = new TreeNode(3,
                null,
                new TreeNode(9,
                        new TreeNode(4, null, null),
                        null));*/
        //System.out.println(bst.isHeightBalancedBST(root));
        //System.out.println(bst.kthsmallest(root, 9));
        //System.out.println(bst.numberOfHalfNodes(root));
        System.out.println(bst.findMin(root).val);
    }

}