package ds.linkedlists;
/**
 * Sort a linked list using insertion sort
 */
public class InsertionSortList {
    //5, 3, 1, 4, 6, 0
    public ListNode insertionSortList(ListNode head) {
        ListNode result = new ListNode(-1);
        ListNode p = result;
        ListNode curr = head;
        ListNode t = null;
        while (curr != null && curr.next != null) {
            ListNode next = curr.next;
            if (p.next == null) {
                p.next = curr;
                curr = curr.next;
                t = p.next;
                continue;
            }
            while (p.next != null) {
                if (curr.val < p.next.val) {
                    p.next = curr;
                    curr.next = t;
                    t.next = next;
                    curr = next;
                    break;
                }
                p = p.next;
                //t = t.next;
            }
        }
        return result.next;
    }

    public static void main(String a[]) {
        ListNode head = new LinkedList().buildLinkedList(new int[]{5, 3, 1, 4, 6, 0}, new ListNode());
        head = new InsertionSortList().insertionSortList(head);
        System.out.println(head);
    }
}
