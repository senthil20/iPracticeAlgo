package Revise.trees;

import java.util.ArrayList;
import java.util.Queue;

public class KthSmallestInBST {

    static int count = 0;
    static int smallest = 0;
    public static int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        kthSmallest(root.left, k);
        count++;
        if (k == count) {
            smallest = root.val;
        }
        if (smallest == 0)
            kthSmallest(root.right, k);
        return smallest;
    }

    public static void main(String a[]) {
        TreeNode node = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2,
                                new TreeNode(1, null, null),
                                null),
                        new TreeNode(4, null, null)),
                new TreeNode(6, null, null));

        int smallest = kthSmallest(node, 5);
        System.out.println(smallest);
    }
}
