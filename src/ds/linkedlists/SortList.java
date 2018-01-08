package ds.linkedlists;

import java.util.ArrayList;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortList {
    //5, 3, 1, 4, 6, 9
    public ListNode mergeList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode sp = head;
        ListNode fp = head;
        while (fp.next != null && fp.next.next != null) {
            sp = sp.next;
            fp = fp.next.next;
        }
        ListNode right = sp.next;
        sp.next = null;
        ListNode left = head;
        left = mergeList(left);
        right = mergeList(right);
        head = merge(left, right);
        return head;
    }

    public ListNode sortList(ListNode root) {
        int count = sizeOf(root);
        if (root == null || count == 1) return root;
        int mid = count/2;
        ListNode left = new ListNode(-1);
        left.next = root;
        ListNode right = null;
        while (mid > 1) {
            root = root.next;
            mid--;
        }
        right = root.next;
        root.next = null;
        left = left.next;
        left = sortList(left);
        right = sortList(right);
        root = merge(left, right);
        return root;
    }

    public int sizeOf(ListNode root) {
        int count = 0;
        while (root != null) {
            root = root.next;
            count++;
        }
        return count;
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(-1);
        ListNode tail = p;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            }
            else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        while (l1 != null) {
            tail.next = l1;
            break;
        }
        while (l2 != null) {
            tail.next = l2;
            break;
        }
        return p.next;
    }

    public static void main(String a[]) {
        ListNode head = new LinkedList().buildLinkedList(new int[]{5, 3, 1, 4, 6, 9}, new ListNode());
        head = new SortList().mergeList(head);
        System.out.println(head);
        //Java see this example too
        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList<String> list2 = list1;
        list1 = null;
        System.out.println(list2);
        list1.add("IB");
        list1.add("LC");
        list2.add("GFG");

        System.out.println(list1);
        System.out.println(list2);
    }
}
