package DataStructures.linkedlists;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeTwoListsDemo {

    public static ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null && b == null) return null;
        if (a == null && b != null) return b;
        if (a != null && b == null) return a;
        ListNode prev = new ListNode(-1);
        ListNode result = prev;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        pq.add(a);
        pq.add(b);

        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();
            prev.next = temp;
            prev = prev.next;

            if (temp.next != null) {
                pq.add(temp.next);
            }
        }
        return result.next;
    }

    public static void main(String a[]) {
        ListNode l1 = new LinkedList().buildLinkedList(new int[]{}, new ListNode());
        ListNode l2 = new LinkedList().buildLinkedList(new int[]{4, 11, 15}, new ListNode());

        ListNode result = mergeTwoLists(l1, l2);
        System.out.println(result);
    }
}
