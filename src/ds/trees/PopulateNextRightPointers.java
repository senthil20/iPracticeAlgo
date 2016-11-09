package ds.trees;


import java.util.LinkedList;
import java.util.Queue;

/**
Tree
a)       5 -> null
       /   \
      4  -> 7 -> null
     /     / \
    2  -> 6 ->11 -> null
  / \       /  \
 1-> 3  -> 8 -> 12 -> null


b)       1 -> null
      /    \
     2  ->  3 -> null
    / \    /  \
   4 ->5->6 -> 7 -> null
  / \         / \
 8 ->9  ->  10->11 -> null
 */

public class PopulateNextRightPointers {

   //simple way
   public void connect(TreeLinkNode root) {

        if (root == null) return;

        Queue<TreeLinkNode> current = new LinkedList<>();
        Queue<TreeLinkNode> next = new LinkedList<>();

        current.add(root);

        while (!current.isEmpty()) {

            TreeLinkNode temp = current.poll();

            if (temp.left != null) next.add(temp.left);

            if (temp.right != null) next.add(temp.right);

            if (current.isEmpty()) {
                temp.next = null;
                current = next;
                next = new LinkedList<>();
            }
            else {
                temp.next = current.peek();
            }
         }
    }

    //using recursion with no extra space
    public void connect1(TreeLinkNode root) {

        if (root == null) return;

        TreeLinkNode parent = root;

        if (parent != null) {

            TreeLinkNode temp = parent;

            while (temp != null) {
                if (temp.left != null)
                {
                    if (temp.right != null)
                        temp.left.next = temp.right;
                    else
                        temp.left.next = getNextConnect(temp);
                }

                if (temp.right != null)
                    temp.right.next = getNextConnect(temp);

                temp = temp.next;
            }

            if (parent.left != null)
                parent = parent.left;
            else if (parent.right != null)
                parent = parent.right;
            else
                parent = getNextConnect(parent);

            connect(parent);
        }
    }

    public TreeLinkNode getNextConnect(TreeLinkNode node) {

        TreeLinkNode temp = node.next;

        if (temp == null) return temp;
        if (temp.left != null) return temp.left;
        if (temp.right != null) return temp.right;

        return getNextConnect(temp);
    }

    public static void main(String a[]) {
        PopulateNextRightPointers nextPointer = new PopulateNextRightPointers();
        //int[] ar = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 11, 12};
        //TreeNode root = new BSTBasicOperations().buildTreeSortedArray(new TreeNode(), ar, 0, ar.length - 1);
        /*TreeLinkNode root = new TreeLinkNode(5,
                new TreeLinkNode(4,
                        new TreeLinkNode(2,
                                new TreeLinkNode(1, null, null),
                                new TreeLinkNode(3, null, null)),
                        null),
                new TreeLinkNode(7,
                        new TreeLinkNode(6, null, null),
                        new TreeLinkNode(11,
                                new TreeLinkNode(8, null, null),
                                new TreeLinkNode(12, null, null))));*/
        TreeLinkNode root = new TreeLinkNode(1,
                new TreeLinkNode(2,
                        new TreeLinkNode(4,
                                new TreeLinkNode(8, null, null),
                                new TreeLinkNode(9, null, null)),
                        new TreeLinkNode(5, null, null)),
                new TreeLinkNode(3,
                        new TreeLinkNode(6, null, null),
                        new TreeLinkNode(7,
                                new TreeLinkNode(10, null, null),
                                new TreeLinkNode(11, null, null))));
        //nextPointer.populateRightPointers(root);
        nextPointer.connect(root);
        System.out.println(root);
    }
}