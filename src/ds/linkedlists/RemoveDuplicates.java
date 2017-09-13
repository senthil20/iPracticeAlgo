package ds.linkedlists;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by sydgsk9 on 9/11/2017.
 */
public class RemoveDuplicates {

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

    public static ListNode deleteDuplicates(ListNode a) {
        if (a == null) return a;
        ListNode prev = new ListNode(-1);
        ListNode result = prev;
        ListNode curr = a;
        prev.next = curr;
        while (curr != null) {
            if (prev.next != curr.next) {
                prev.next = curr.next;
                prev = prev.next;
            }
            curr = curr.next;
        }
        return result.next;
    }

    public static void main(String s[]) {
        ListNode root = new LinkedList().buildLinkedList(new int[]{1,2,3,3,4}, new ListNode());
        ListNode result = deleteDuplicates(root);
        System.out.println(result);
    }

}
