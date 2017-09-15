package ds.linkedlists;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.

 For example:

 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL

 */
public class RotateListByK {

    public static ListNode rotateRight(ListNode a, int b) {
        if (a == null) return a;
        ListNode first = a;
        ListNode head = a;
        ListNode curr = a;
        ListNode second = null;
        for (int i = 0; i < b; i++) {
            curr = curr.next;
            if (curr == null) {
                curr = a;
            }
        }
        while (curr != null && curr.next != null) {
            curr = curr.next;
            first = first.next;
        }
        second = first.next;
        first.next = null;

        ListNode f = reverse(head);
        ListNode result = f;
        ListNode s = reverse(second);
        while (f.next != null) {
            f = f.next;
        }
        f.next = s;
        return reverse(result);
    }

    public static ListNode reverse(ListNode a) {
        ListNode prev = null;
        ListNode curr = a;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String a[]) {
        ListNode root = new LinkedList().buildLinkedList(new int[]{1, 2, 3, 4}, new ListNode());
        ListNode result = rotateRight(root, 1);
        //ListNode result = reverse(root);
        System.out.println(result);
    }
}
