package ds.trees;

import sun.reflect.generics.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Tree
         5
       /   \
      4     7
     /     / \
    2     6  11
   / \      /  \
  1  3     8   12

 if k = 3 o/p = 3
 if k = 9 o/p = 11
 */
public class KthSmallestBST {
    int count = 0;

    public int kthSmallest(TreeNode root, int k, int val) {

        if (root == null) return val;

        if (count <= k) val =  kthSmallest(root.left, k, val);

        count++;

        if (k == count) return root.val;

        if (count <= k) val = kthSmallest(root.right, k, val);

        return val;
    }

    public void addAllRightNodes(Stack<TreeNode> st, TreeNode node) {
        while (node != null) {
            st.push(node);
            node = node.right;
        }
    }

    public TreeNode findKthLargest1(TreeNode root, int k) {
        if (root == null) return null;
        int count = 0;

        Stack<TreeNode> st = new Stack<>();
        addAllRightNodes(st, root);

        TreeNode curr = null;

        while (!st.isEmpty()) {
            curr = st.pop();
            count++;
            if (count == k) {
                return curr;
            }
            if (curr.left != null) {
                addAllRightNodes(st, curr.left);
            }
        }
        return null;
    }

    public TreeNode findKthLargest(TreeNode root, int k) {

        if (root == null) return null;
        TreeNode temp = null;

        return recursiveCall(root, temp, k);
    }

    public TreeNode recursiveCall(TreeNode root, TreeNode result, int k) {
        if (root == null) return result;
        result = recursiveCall(root.right, result, k);
        if (++count == k) {
           return root;
        }
        result = recursiveCall(root.left, result, k);
        return result;
    }

    public int kthSmallest(TreeNode root, int k) {
        if (root == null || k <= 0) return 0;
        return kthSmallest(root, new int[]{0}, k, 0);
    }

    public int kthSmallest(TreeNode root, int a[], int k, int val) {
        if (root == null) return val;
        val = kthSmallest(root.left, a, k, val);
        a[0]++;
        if (k == a[0])
            return root.val;
        if (a[0] <= k)
            val = kthSmallest(root.right, a, k, val);

        return val;
    }

    public static void main(String a[]) {
        KthSmallestBST kth = new KthSmallestBST();
        TreeNode root = new TreeNode(5,
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

        root = new TreeNode(4,
                new TreeNode(2, null, null),
                new TreeNode(8,
                        new TreeNode(5, null, null),
                        new TreeNode(10, null, null)));

        root = new TreeNode(3,
                new TreeNode(1,
                        null,
                        new TreeNode(2, null, null)),
                new TreeNode(4, null, null));

        root = new TreeNode(1,
                null,
                new TreeNode(2, null, null));
        int result = kth.kthSmallest(root, 2);
        System.out.print(result);
        //System.out.println(kth.kthSmallest(root, 9, -1));
       // System.out.println(kth.findKthLargest1(root, 9));
        //TreeNode result = kth.findKthLargest1(root, 3);
        //System.out.println(result != null ? result.val : result);
    }
}
