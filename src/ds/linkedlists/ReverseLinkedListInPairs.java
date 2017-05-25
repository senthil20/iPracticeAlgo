package ds.linkedlists;

/**
 * Given a singly-linked list, reverse the list in pairs.
 Example:
 Given 1->2->3->4,
 reverseInPairs(1) ==> 2->1->4->3
 */
public class ReverseLinkedListInPairs {

    public ListNode reverseInPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = new ListNode(-1);
        prev.next = head;
        head = prev;
        ListNode current = head.next;
        while (current != null && current.next != null) {
            ListNode next = current.next;
            prev.next = next;
            current.next = next.next;
            next.next = current;
            prev = current;
            current = current.next;
        }
        return head.next;
    }

}
