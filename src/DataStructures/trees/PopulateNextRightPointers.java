package DataStructures.trees;


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

    public void connectUsingRecursion(TreeLinkNode root) {
        if (root == null) return;
        if (root.left != null) {
            root.left.next = root.right;
            if(root.next != null) {
                root.right.next = root.next.left;
            }
        }
        connectUsingRecursion(root.left);
        connectUsingRecursion(root.right);
    }

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

    public static void main(String a[]) {
        PopulateNextRightPointers nextPointer = new PopulateNextRightPointers();
        /*TreeLinkNode root = new TreeLinkNode(1,
                new TreeLinkNode(2,
                        new TreeLinkNode(4,null,null),
                        new TreeLinkNode(5, null, null)),
                new TreeLinkNode(3,
                        new TreeLinkNode(6, null, null),
                        new TreeLinkNode(7,null,null)));*/
        TreeLinkNode root = new TreeLinkNode(1,
                new TreeLinkNode(2,
                        new TreeLinkNode(4,null,null),
                        null),
                new TreeLinkNode(3,
                        null,
                        new TreeLinkNode(5,null,null)));
        nextPointer.connectUsingRecursion(root);
        System.out.println(root);
    }
}