package ds.trees;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * tc: o(n)
     * Approach 1: similar to path sum 2 problem
     */
    public int sumRootToLeaf(TreeNode root) {

        if (root == null) return 0;

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        depthWiseTraversal(result, list, root);

        long total = 0;

        for(List l : result) {
            String s = "";
            for (Object obj : l) {
                s = s.concat(String.valueOf((Integer)obj));
            }
            total += Long.valueOf(s);
        }
        return (int)total;
    }

    public void depthWiseTraversal(List<List<Integer>> result, List<Integer> list, TreeNode root) {

        list.add(root.val);

        if (root.left == null && root.right == null) {
            List<Integer> temp = new ArrayList<>(list);
            result.add(temp);
        }

        if (root.left != null) {
            depthWiseTraversal(result, list, root.left);
            list.remove(list.size() - 1);
        }

        if (root.right != null) {
            depthWiseTraversal(result, list, root.right);
            list.remove(list.size() - 1);
        }
    }

    /**
     * tc:o(n)
     * Recursive, just append int using int * 10 and finally add it to sum
     */
    public int sumRootToLeafNumbers(TreeNode root) {

        if (root == null) return 0;
        return sumRootRecursive(root, 0 , 0);
    }

    public int sumRootRecursive(TreeNode root, int sum, int val) {

        val = val * 10 + root.val;

        if (root.left == null && root.right == null) {
            sum += val;
        }

        if (root.left != null) sum =  sumRootRecursive(root.left, sum, val);
        if (root.right != null) sum = sumRootRecursive(root.right, sum, val);

        return sum;
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

        System.out.println(sn.sumRootToLeafNumbers(root));
    }
}
