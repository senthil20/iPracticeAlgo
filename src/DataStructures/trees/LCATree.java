package DataStructures.trees;

public class LCATree {
    boolean v1 = false;
    boolean v2 = false;
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
        else if(root.val > a && root.val > b) {
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
    public int lcaBT(TreeNode a, int val1, int val2) {
        int result = lcaRecursive(a, val1, val2);
        if(v1 && v2) return result;
        return -1;
    }
    public int lcaRecursive(TreeNode a, int val1, int val2) {
        if (a == null) return -1;
        if (a.val == val1) {
            v1 = true;
            return a.val;
        }
        if (a.val == val2) {
            v2 = true;
            return a.val;
        }
        int left = lcaRecursive(a.left, val1, val2);
        int right = lcaRecursive(a.right, val1, val2);
        if (left != -1 && right != -1) return a.val;
        return left == -1 ? right : left;
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left != null && right != null ? root : left != null ? left : right;
    }

    public static void main(String a[]) {
        LCATree lca = new LCATree();
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
        //System.out.println(lca.lcaBST(bstroot, 6, 12));
        //int result = lca.lcaBT(btroot, 2, 11);
        int result = lca.lcaBT(btroot, 3,9);
        System.out.println(result);
    }
}
