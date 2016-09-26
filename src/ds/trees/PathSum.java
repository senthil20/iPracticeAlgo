package ds.trees;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by senthil on 25/9/16.
 */

public class PathSum {

    /** Given the below binary tree and sum = 22,
                  5
                 / \
                4   8
               /   / \
              11  13  4
             /  \      \
            7    2      1
    return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
    **/

    public boolean pathSum1(TreeNode root, int sum) {
        if (root == null) return false;

        if (sum - root.val == 0 && root.left == null && root.right == null) {
            return true;
        }

        boolean left = pathSum1(root.left, sum - root.val);

        boolean right = pathSum1(root.right, sum - root.val);

        return (left || right); // or simply return pathSum1(root.left, sum - root.val) || pathSum1(root.right, sum - root.val);
    }

    /**
     * Given the below binary tree and sum = 22,
            5
           / \
          4   8
         /   / \
        11  13  4
       /  \    / \
      7    2  5   1
     return
     [
        [5,4,11,2],
        [5,8,4,5]
     ]
     **/
    public List<List<Integer>> pathSum2(TreeNode root, int sum) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        pathSumRecursive2(result, list, root, sum);

        return result;
    }

    public void pathSumRecursive2(List<List<Integer>> result, List<Integer> list, TreeNode root, int sum) {

        if(root != null) list.add(root.val);

        if (sum - root.val == 0 && root.left == null && root.right == null) {
            List<Integer> temp = new ArrayList<>();
            temp.addAll(list);
            result.add(temp);
        }

        if (root.left!= null) {
            pathSumRecursive2(result, list, root.left, sum - root.val);
            list.remove(list.size() - 1);
        }

        if (root.right != null) {
            pathSumRecursive2(result, list, root.right, sum - root.val);
            list.remove(list.size() - 1);
        }
    }

    //similar to above. nothing more.
    public List<List<Integer>> pathSum21(TreeNode root, int sum) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        return pathSumRecursive21(result, list, root, sum-root.val);
    }

    public List<List<Integer>> pathSumRecursive21(List<List<Integer>> result, List<Integer> list, TreeNode root, int sum) {

        if (root == null) return result;

        list.add(root.val);

        if (root.left != null) {
            pathSumRecursive21(result, list, root.left, sum - root.left.val);
            list.remove(list.size() - 1);
        }

        if (sum == 0) {
            System.out.println("True");
            result.add(list);
        }

        if (root.right != null) {
            pathSumRecursive21(result, list, root.right, sum - root.right.val);
            list.remove(list.size() - 1);
        }
        return result;
    }

    public static void main(String a[]) {

        PathSum ps = new PathSum();
        TreeNode root = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11,
                                new TreeNode(7, null, null),
                                new TreeNode(2, null, null)),
                        null),
                new TreeNode(8,
                        new TreeNode(13, null, null),
                        new TreeNode(4,
                                new TreeNode(5, null, null),
                                new TreeNode(1, null, null))));
        /*TreeNode root = new TreeNode(5,
                                new TreeNode(3,
                                        null,
                                        new TreeNode(4,
                                                new TreeNode(1, null, null),
                                                null)),
                                new TreeNode(8, null, null));*/
        //System.out.println(ps.pathSum1(root, 22));
        //ps.pathSum2(root, 22);
        ps.pathSum21(root, 13);
    }
}
