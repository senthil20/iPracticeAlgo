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

    public void join1(TreeLinkNode root) {
        TreeLinkNode dummyHead = new TreeLinkNode(0);
        TreeLinkNode pre = dummyHead;
        while (root != null) {
            if (root.left != null) {
                pre.next = root.left;
                pre = pre.next;
            }
            if (root.right != null) {
                pre.next = root.right;
                pre = pre.next;
            }
            root = root.next;
            if (root == null) {
                pre = dummyHead;
                root = dummyHead.next;
                dummyHead.next = null;
            }
        }
    }

    public void join(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode leftMost = root;
        while (leftMost != null) {
            TreeLinkNode cur = leftMost;
            leftMost = null;
            while (cur != null) {
                if (cur.left != null) {
                    cur.left.next = cur.right == null ? getNext(cur) : cur.right;
                    if (leftMost == null) leftMost = cur.left;
                }
                if (cur.right != null) {
                    cur.right.next = getNext(cur);
                    if (leftMost == null) leftMost = cur.right;
                }
                cur = cur.next;
            }
        }
    }

    private TreeLinkNode getNext(TreeLinkNode root) {
        TreeLinkNode cur = root.next;
        while (cur != null) {
            if (cur.left != null) return cur.left;
            if (cur.right != null) return cur.right;
            cur = cur.next;
        }
        return null;
    }

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

    public void connect1(TreeLinkNode root) {
        if(root == null)
            return;
        if(root.left != null){
            root.left.next = root.right;
            if(root.next != null)
                root.right.next = root.next.left;
        }
        connect1(root.left);
        connect1(root.right);
    }

    public void connect2(TreeLinkNode root) {
        while (root != null && root.left != null) {
            TreeLinkNode next = root.left;
            while (root != null) {
                root.left.next = root.right;
                if (root.next != null) root.right.next = root.next.left;
                root = root.next;
            }
            root = next;
        }
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
        nextPointer.join1(root);
        System.out.println(root);
    }
}