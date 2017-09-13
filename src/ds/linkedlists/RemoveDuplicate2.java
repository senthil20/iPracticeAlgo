package ds.linkedlists;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 For example,
 Given 1->2->3->3->4->4->5, return 1->2->5.
 Given 1->1->1->2->3, return 2->3.
 */
public class RemoveDuplicate2 {

    public static ListNode removeDuplicates2(ListNode a) {
        ListNode prev = new ListNode(-1);
        ListNode result = prev;
        ListNode curr = a;
        prev.next = a;
        while (curr != null) {
            if (curr.next != null && prev.next == curr.next) {
                prev = prev.next;
            }
            else {
                prev.next = curr.next;
            }
            curr = curr.next;
        }
        return prev.next;
    }

    public static void main(String a[]) {
        ListNode head = new LinkedList().buildLinkedList(new int[]{1,2,2,4,3,1} , new ListNode());
        ListNode result = removeDuplicates2(head);
        System.out.println(result);
    }
}
