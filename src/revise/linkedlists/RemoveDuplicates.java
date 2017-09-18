package revise.linkedlists;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    //o(n) space
    //1,3,4,5,8,1,5,6,6,8
    public static ListNode removeDuplicatesUnsorted(ListNode root) {
        ListNode result = root;
        ListNode curr = root;
        Set<Integer> set = new HashSet<>();
        set.add(root.val);
        while (curr.next != null) {
            if (!set.contains(curr.next.val)) {
                set.add(curr.next.val);
                curr = curr.next;
            }
            else {
                curr.next = curr.next.next;
            }
        }
        return result;
    }

    //o(1) space //1,1,1,1,3,4,5,2,1,5,6,6,8
    public static ListNode removeDuplicatesUnsorted2(ListNode root) {
        ListNode curr = root;
        while (curr != null) {
            ListNode inner = curr;
            while (inner.next != null) {
                if (curr.val == inner.next.val) {
                    inner.next = inner.next.next;
                }
                else {
                    inner = inner.next;
                }
            }
            curr = curr.next;
        }
        return root;
    }

    //11,1,1,1,2,3,3,3,3
    public static ListNode removeDuplicatesSorted(ListNode root) {
        ListNode curr = root;
        ListNode result = root;
        while (curr.next != null ) {
            if (root.val == curr.next.val) {
                curr = curr.next;
            }
            else {
                root.next = curr.next;
                root = root.next;
                curr = root;
            }
        }
        if (root.next != null) root.next = null;
        return result;
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
        //ListNode root = new LinkedList().buildLinkedList(new int[]{1,1,1,1,1,1,12,3,4,1,5,6,5,5,5,8,1}, new ListNode());
        //ListNode result = deleteDuplicates(root);
        ListNode root1 = new LinkedList().buildLinkedList(new int[]{1,3,4,5,8,1,5,6,6,8}, new ListNode());
        ListNode result1 = removeDuplicatesUnsorted(root1);
        //ListNode root2 = new LinkedList().buildLinkedList(new int[]{11,1,1,1,2,3,3,3,3}, new ListNode());
        //ListNode result2 = removeDuplicatesSorted(root2);
        //ListNode root3 = new LinkedList().buildLinkedList(new int[]{1,1,1,1,3,4,5,2,1,5,6,6,8}, new ListNode());
        //ListNode result3 = removeDuplicatesUnsorted2(root3);
        System.out.println(result1);
    }

}
