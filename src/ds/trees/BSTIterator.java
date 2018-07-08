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
class TreeNodeDouble {
    double val;
    TreeNodeDouble left;
    TreeNodeDouble right;
    TreeNodeDouble() {
    }
    TreeNodeDouble(double val) {
        this.val = val;
    }
    TreeNodeDouble(double val, TreeNodeDouble left, TreeNodeDouble right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BSTIterator implements Iterator {

    Stack<TreeNodeDouble> st = new Stack<>();

    BSTIterator() {
    }

    BSTIterator(TreeNodeDouble root) {
        pushLeft(root);
    }

    public void pushLeft(TreeNodeDouble node) {
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
        TreeNodeDouble temp = st.pop();
        pushLeft(temp.right);
        return temp.val;
    }

    public static void main(String a[]) {

        TreeNodeDouble root = new TreeNodeDouble(5,
                new TreeNodeDouble(4,
                        new TreeNodeDouble(2,
                                new TreeNodeDouble(1, null, null),
                                new TreeNodeDouble(3, null, null)),
                        null),
                new TreeNodeDouble(7,
                        new TreeNodeDouble(6, null, null),
                        new TreeNodeDouble(11,
                                new TreeNodeDouble(8, null, null),
                                new TreeNodeDouble(12, null, null))));

        TreeNodeDouble root1 = new TreeNodeDouble(4,
                new TreeNodeDouble(2,
                        new TreeNodeDouble(1, null, null),
                        new TreeNodeDouble(3, null, null)),
                new TreeNodeDouble(6,
                        new TreeNodeDouble(5,
                                new TreeNodeDouble(4.5, null, null),
                                new TreeNodeDouble(5.5,
                                        new TreeNodeDouble(5.4, null, null),
                                        new TreeNodeDouble(5.6, null, null))),
                        new TreeNodeDouble(7,
                                null,
                                new TreeNodeDouble(8,
                                        new TreeNodeDouble(7.5, null, null),
                                        null))));

        BSTIterator it = new BSTIterator(root1);
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}
