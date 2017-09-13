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
        ListNode result = a;
        ListNode prev = new ListNode(-1);
        prev.next = a;
        for (int i = 0; i < b; i++) {
            fast = fast.next;
            if (fast == null) {
                return result.next;
            }
        }
        while (fast != null) {
            fast = fast.next;
            prev = prev.next;
        }
        if (prev.next != null) prev.next = prev.next.next;
        return result;
    }

    public static void main(String s[]) {
        ListNode root = new LinkedList().buildLinkedList(new int[]{1, 2, 13, 20, 25}, new ListNode());
        ListNode result = removeNthFromEnd(root, 1);
        System.out.println(result);
    }
}
