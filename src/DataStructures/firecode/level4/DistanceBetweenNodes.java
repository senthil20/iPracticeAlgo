package DataStructures.firecode.level4;

class TreeNode {
    int val;
    char c;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    TreeNode(char val, TreeNode left, TreeNode right) {
        this.c = val;
        this.left = left;
        this.right = right;
    }
}

public class DistanceBetweenNodes {
    /**
     Tree
         5
       /   \
      4     7
     /     / \
    2     6  11
  / \       /  \
 1  3      8   12

     LCA of 6, 12 is 7
     LCA of 7, 12 is 7
     LCA of 2, 11 is 5
     LCA of 8, 12 is 11
     */
    public int lcaBST(TreeNode root, int a, int b) {

        if (root == null) return -1;
        if (root.val < a && root.val < b) {
            return lcaBST(root.right, a, b);
        }
        else if (root.val > a && root.val > b) {
            return lcaBST(root.left, a, b);
        }
        return root.val;
    }

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
    public int lcaBT(TreeNode root, int a, int b) {
        if (root == null) return -1;
        if (root.val == a) {
            return a;
        }
        else if (root.val == b) {
            return b;
        }
        int left = lcaBT(root.left, a, b);
        int right = lcaBT(root.right, a, b);

        if (left != -1 && right != -1) return root.val;
        return left == -1 ? right : left;
    }

    public int distanceFromRootToNode(TreeNode root, int A, int count) {

        if (root == null) return 0;

        if (root.val == A) {
            return count;
        }
        int left = distanceFromRootToNode(root.left, A, count + 1);
        int right = distanceFromRootToNode(root.right, A, count + 1);
        return left != 0 ? left : right;
    }

    public static void main(String a[]) {
        DistanceBetweenNodes dn = new DistanceBetweenNodes();
        TreeNode bstroot = new TreeNode(5,
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
        //System.out.println(dn.lcaBT(btroot, 3, 4));
        //System.out.println(dn.lcaBST(bstroot, 6, 12));
        System.out.println(dn.distanceFromRootToNode(btroot, 2, 0));
    }
}
