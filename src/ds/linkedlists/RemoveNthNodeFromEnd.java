package ds.linkedlists;

/**
 Given a linked list, remove the nth node from the end of list and return its head.

 For example,
 Given linked list: 1->2->3->4->5, and n = 2.
 After removing the second node from the end, the linked list becomes 1->2->3->5.

 Note:
 * If n is greater than the size of the list, remove the first node of the list.
 Try doing it using constant additional space.
 */
public class RemoveNthNodeFromEnd {

    public static ListNode removeNthFromEnd(ListNode a, int b) {
        if (a == null || b < 1) return a;
        ListNode fast = a;
        ListNode prev = new ListNode(-1);
        prev.next = a;
        ListNode result = prev;

        for (int i = 0; i < b; i++) {
            if (fast == null)
                fast = a;
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            prev = prev.next;
        }
        if (prev.next != null) prev.next = prev.next.next;
        return result.next;
    }

    public static void main(String s[]) {
        //ListNode root = new LinkedList().buildLinkedList(new int[]{1, 2, 13, 20, 25}, new ListNode());
        //ListNode root = new LinkedList().buildLinkedList(new int[]{1}, new ListNode());
        int A[] = new int[]{20, 380, 349, 322, 389, 424, 429, 120, 64, 691, 677, 58, 327, 631, 916, 203, 484, 918, 596, 252, 509, 644, 33, 460};
        int b = 82;
        int len = A.length;
        int rounds = b % A.length;
        ListNode root = new LinkedList().buildLinkedList(A, new ListNode());
        ListNode result = removeNthFromEnd(root, 82);
        System.out.println(result);
    }
}
