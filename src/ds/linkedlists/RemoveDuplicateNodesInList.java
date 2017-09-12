package ds.linkedlists;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicateNodesInList {

    public static ListNode removeDuplicates(ListNode head) {
        Set<Integer> set = new TreeSet<>();
        ListNode p = new ListNode(-1);
        p.next = head;
        ListNode curr = p;
        while (curr != null && curr.next != null) {
            if (set.contains(curr.next.val)) {
                curr.next = curr.next.next;
            }
            else {
                set.add(curr.next.val);
            }
            curr = curr.next;
        }
        return p.next;
    }

    public static void main(String a[]) {
        ListNode head = new SLL().buildLinkedList(new int[]{1,2,2,4,3,1} , new ListNode());
        removeDuplicates(head);

    }
}
