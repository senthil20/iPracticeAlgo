package DataStructures.trees;

/**
 Consider the following Binary Tree.

              6
            /   \
           3     5
         /   \    \
        2     5    4
            /   \
           7     4
 There are 4 leaves, hence 4 root to leaf paths:
 Path                    Number
 6->3->2                   632
 6->3->5->7               6357
 6->3->5->4               6354
 6->5>4                    654
 Answer = 632 + 6357 + 6354 + 654 = 13997
 */
public class SumRootToLeafNumbers {

    //solution:1
    public int sumNumbers(TreeNode a) {
        if (a == null) return 0;
        int[] result = new int[1];
        sumNumbersRecursion(a, 0, result);
        return result[0];
    }

    public void sumNumbersRecursion(TreeNode a, int sum, int[] result) {
        if (a == null) return;
        sum = ((sum * 10) + a.val) % 1003;
        if (a.left == null && a.right == null) {
            result[0] = (result[0] + sum) % 1003;
            return;
        }
        sumNumbersRecursion(a.left, sum, result);
        sumNumbersRecursion(a.right, sum, result);
    }
    //solution:2
    public int sumNumbers1(TreeNode a) {
        if (a == null) return 0;
        return sumNumbersRecursion1(a, 0) % 1003;
    }

    public int sumNumbersRecursion1(TreeNode a, int sum) {
        if (a == null) return 0;
        sum = ((sum * 10) + a.val) % 1003;
        if (a.left == null && a.right == null) return sum % 1003;
        return sumNumbersRecursion1(a.left, sum) + sumNumbersRecursion1(a.right, sum);
    }

    public static void main(String a[]) {

        SumRootToLeafNumbers sn = new SumRootToLeafNumbers();

        TreeNode root = new TreeNode(6,
                new TreeNode(3,
                        new TreeNode(2, null, null),
                        new TreeNode(5,
                                new TreeNode(7, null, null),
                                new TreeNode(4, null ,null))),
                new TreeNode(5,
                        null,
                        null));

        System.out.println(sn.sumNumbers(root));
    }
}
