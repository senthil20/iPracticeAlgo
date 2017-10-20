package ds.linkedlists;

public class ReverseNodesInKGroups {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode prev = new ListNode(-1);
        ListNode result = null;
        ListNode first = head;
        while (head != null) {
            for (int i = 0; i < k - 1; i++) {
                if (head.next == null) {
                    prev.next = first;
                    return result == null ? first : result;
                }
                head = head.next;
            }
            ListNode next = head.next;
            head.next = null;
            ListNode temp = reverse(first);
            if (result == null) result = temp;
            prev.next = temp;
            while (prev.next != null) {
                prev = prev.next;
            }
            first = next;
            head = first;
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
        ListNode head = new LinkedList().buildLinkedList(new int[]{1,2,3}, new ListNode());
        ListNode result = reverseKGroup(head, 2);
        System.out.println(result);
    }
}
