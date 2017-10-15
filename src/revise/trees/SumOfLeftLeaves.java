package revise.trees;


/**
           8
        /     \
      4        11
    /  \      / \
   2    6    10  13
  / \  / \     /  \
 1  3 5  7    12  14
 */

//0,0,2,0,0,2,4
public class SumOfLeftLeaves {
    static int sum = 0;

    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            sum += root.val;
        }
        sumOfLeftLeaves(root.left);
        if (root.right != null && !(root.right.left == null && root.right.right == null)) {
            sumOfLeftLeaves(root.right);
        }
        return sum;
    }

    public static void main(String a[]) {
        TreeNode node = new TreeNode(8,
                new TreeNode(4,
                        new TreeNode(2,
                                new TreeNode(1, null, null),
                                new TreeNode(3, null, null)),
                        new TreeNode(6,
                                new TreeNode(5, null, null),
                                new TreeNode(7, null, null))),
                new TreeNode(11,
                        new TreeNode(10, null, null),
                        new TreeNode(13,
                                new TreeNode(12, null, null),
                                new TreeNode(14, null, null))));
        int sum = sumOfLeftLeaves(node);
        System.out.println(sum);
    }
}
