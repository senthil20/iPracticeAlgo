package Revise.linkedlists;

/**
 Reverse last half of a singly linkedlist and interleave the last half into the first half.
 I/p: 1->2->3->4->5->6
 O/p: 1->6->2->5->3->4
 */
public class ReverseLastAndInterleaveIntoFirst {

    public static ListNode reverseAndInterleave(ListNode a) {
        if (a == null) return a;
        ListNode result = a;
        ListNode first = a;
        ListNode sp = a;
        ListNode fp = a;
        while (fp != null && fp.next != null && fp.next.next != null) {
            sp = sp.next;
            fp = fp.next.next;
        }
        ListNode second = sp.next;
        sp.next = null;

        ListNode rev = reverse(second);
        while (first != null && rev != null) {
            ListNode fnext = first.next;
            ListNode snext = rev.next;
            first.next = rev;
            rev.next = fnext;
            first = fnext;
            rev = snext;
        }
        return result;
    }

    public static ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode next = null;
        while (node != null) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

    public static void main(String a[]) {
        ListNode root = new LinkedList().buildLinkedList(new int[]{1,2,3,4,5}, new ListNode());
        ListNode result = reverseAndInterleave(root);
        System.out.println(result);
    }
}
