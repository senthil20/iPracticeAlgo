package revise.trees;

/**
 Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
    public ListNode() {
    }
}
public class SortedListToBST {

    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return sortedListToBSTRecursion(head, null);
    }

    public static TreeNode sortedListToBSTRecursion(ListNode head, ListNode tail) {
        if (head == tail) return null;
        ListNode sp = head;
        ListNode fp = head;

        while (fp != tail && fp.next != tail) {
            sp = sp.next;
            fp = fp.next.next;
        }
        TreeNode node = new TreeNode(sp.val);
        node.left = sortedListToBSTRecursion(head, sp);
        node.right = sortedListToBSTRecursion(sp.next, tail);
        return node;
    }

    public static ListNode buildLinkedList(int a[], ListNode l) {
        if(a.length == 0) return null;

        l = new ListNode(-1);
        ListNode t = l;

        for(int a1 : a) {
            t.next = new ListNode(a1);
            t = t.next;
        }
        return l.next;
    }

    public static void main(String a[]) {
        ListNode list = buildLinkedList(new int[]{4, 5, 7, 9}, new ListNode());
        TreeNode result = sortedListToBST(list);
        System.out.println(result);
    }
}
