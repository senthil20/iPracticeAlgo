package ds.trees;

import java.util.ArrayList;
import java.util.List;

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

    //solution:1
    public int hasPathSum(TreeNode a, int b) {
        if (a == null) return 0;
        return hasPathSumRecursion(a, b, 0);
    }

    public int hasPathSumRecursion(TreeNode a, int b, int sum) {
        if (a == null) return 0;
        sum += a.val;
        if (sum == b && a.left == null && a.right == null) return 1;
        int left = hasPathSumRecursion(a.left, b, sum);
        int right = 0;
        if (left != 1) {
            right = hasPathSumRecursion(a.right, b, sum);
        }
        return left == 1 ? left : right;
    }

    //solution:2
    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) return false;
        if (sum - root.val == 0 && root.left == null && root.right == null) {
            return true;
        }
        boolean left = hasPathSum1(root.left, sum - root.val);
        boolean right = hasPathSum1(root.right, sum - root.val);
        return (left || right);
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

    //solution:1
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        if (root == null) return result;
        pathSumRecursion(root, result, path, sum, 0);
        return result;
    }

    public void pathSumRecursion(TreeNode root, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path, int sum, int total) {

        if (root == null) return;
        path.add(root.val);
        total += root.val;
        if (total == sum && root.left == null && root.right == null) {
            ArrayList<Integer> temp = new ArrayList<>(path);
            result.add(temp);
            return;
        }
        if (root.left != null) {
            pathSumRecursion(root.left, result, path, sum, total);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            pathSumRecursion(root.right, result, path, sum, total);
            path.remove(path.size() - 1);
        }
    }

    //solution:2
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
        ps.pathSum(root, 22);
        //System.out.println(ps.hasPathSum(root, 25));
        //ps.pathSum2(root, 22);
        //ps.pathSum21(root, 13);
    }
}