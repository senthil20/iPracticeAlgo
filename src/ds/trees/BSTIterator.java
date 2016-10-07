package ds.trees;

import java.util.Iterator;
import java.util.Stack;

/**
 * Tree
        5
      /   \
     4     7
    /     / \
   2     6  11
  / \      /  \
 1  3     8  12
 */
public class BSTIterator implements Iterator {

    Stack<TreeNode> st = new Stack<>();

    BSTIterator() {
    }

    BSTIterator(TreeNode root) {
        pushLeft(root);
    }

    public void pushLeft(TreeNode node) {
        while (node != null) {
            st.push(node);
            node = node.left;
        }
    }
    @Override
    public boolean hasNext() {
        return !st.isEmpty();
    }

    @Override
    public Object next() {
        TreeNode temp = st.pop();
        pushLeft(temp.right);
        return temp.val;
    }

    public static void main(String a[]) {

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

        BSTIterator it = new BSTIterator(root);
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}
