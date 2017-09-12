package ds.trees;

import java.util.Arrays;

/**
 * Created by User on 02-07-2017.
 */
//INCOMPLETE
public class FindNextGreaterForInput {
    public static int temp(TreeNode root, int val) {
        int min = Integer.MAX_VALUE;
        int result = root.val;
        while (root != null) {
            result = root.val;
            if (val > root.val) {
                root = root.right;
            }
            else if (val < root.val) {
                root = root.left;
            }
            else {
                if (root.right != null) return root.right.val;
                else return -1;
            }
        }
        return result;
    }

    public static void main(String a[]) {

        int ar[] = new int[]{20,10,30,8,12,25,40,6,31,13,23,30};
        Arrays.sort(ar);
        TreeNode root = new BSTBasicOperations().buildTreeSortedArray(new TreeNode(), ar, 0, ar.length - 1);
        System.out.println(FindNextGreaterForInput.temp(root, 11));

        TreeNode root1 = new TreeNode(20,
                new TreeNode(10,
                        new TreeNode(8,null,null),
                        new TreeNode(12,null,null)),
                new TreeNode(30,
                        new TreeNode(25, null, null),
                        new TreeNode(40, null,null)));

        System.out.print(FindNextGreaterForInput.temp(root1, 40));
    }
}
