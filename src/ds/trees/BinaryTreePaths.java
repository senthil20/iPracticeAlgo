package ds.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by senthil on 25/9/16.
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<String> paths = new ArrayList<>();

        StringBuffer sb = null;

        binaryTreepathsRecursive(result, list, root);

        for (List l1 : result) {

            sb = new StringBuffer();

            for (Object val : l1) {
                sb.append(val).append("->");
            }

            String temp = sb.toString();
            temp = temp.substring(0, temp.length() - 2);
            paths.add(temp);
        }
        return paths;
    }

    public void binaryTreepathsRecursive(List<List<Integer>> result, List<Integer> list, TreeNode root) {

        if (root != null) list.add(root.val);

        if (root.left == null && root.right == null) {
            List<Integer> temp = new ArrayList<>();
            temp.addAll(list);
            result.add(temp);
        }

        if (root.left != null) {
            binaryTreepathsRecursive(result, list, root.left);
            list.remove(list.size() - 1);
        }

        if (root.right != null) {
            binaryTreepathsRecursive(result, list, root.right);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String a[]) {

        BinaryTreePaths bp = new BinaryTreePaths();

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
        bp.binaryTreePaths(root);
    }
}
