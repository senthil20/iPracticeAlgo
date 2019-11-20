package DataStructures.linkedlists;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.

 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.

 Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class SwapNodesInPairs {

    public static ListNode swapPairs(ListNode head) {

        ListNode prev = new ListNode(-1);
        ListNode result = prev;
        ListNode next = null;
        while (head.next != null) {
            next = head.next;
            prev.next = next;
            head.next = next.next;
            next.next = head;
            prev = head;
            head = prev.next;
        }
        return result.next;
    }

    public static ListNode swapPairsRecursion(ListNode head) {
        if (head != null && head.next != null) {
            swap(head, head.next);
            swapPairsRecursion(head.next.next);
        }
        return head;
    }

    public static void swap(ListNode head, ListNode next) {
        int temp = head.val;
        head.val = next.val;
        next.val = temp;
    }

    public static void main(String a[]) {
        ListNode head = new LinkedList().buildLinkedList(new int[]{10, 2, 3, 8, 9}, new ListNode());
        //ListNode result = swapPairs(head);
        ListNode result = swapPairsRecursion(head);
        System.out.println(result);
    }
}
