package ds.linkedlists;

import java.util.ArrayList;
import java.util.List;

public class MergeKLists {

    public ListNode mergeKLists(List<ListNode> lists) {
        return mergeRecursion(lists, 0, lists.size() - 1);
    }

    public ListNode mergeRecursion(List<ListNode> lists, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            ListNode left = mergeRecursion(lists, start, mid);
            ListNode right = mergeRecursion(lists, mid + 1, end);
            return mergeLists(left, right);
        }
        return lists.get(start);
    }

    public ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(-1);
        ListNode head = p;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            }
            else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return head.next;
    }


    public ListNode buildLinkedList(int a[], ListNode l) {
        if(a.length == 0) return null;

        l = new ListNode(-1);
        ListNode t = l;

        for(int a1 : a) {
            t.next = new ListNode(a1);
            t = t.next;
        }
        return l.next;
    }

    public static void main(String s[]) {
        MergeKLists mergeKLists = new MergeKLists();
        ListNode l1 = mergeKLists.buildLinkedList(new int[]{1, 2, 13, 20}, new ListNode());
        ListNode l2 = mergeKLists.buildLinkedList(new int[]{3, 4, 35, 41}, new ListNode());
        ListNode l3 = mergeKLists.buildLinkedList(new int[]{5, 9, 11, 25}, new ListNode());
        ListNode l4 = mergeKLists.buildLinkedList(new int[]{1, 21, 39, 40}, new ListNode());
        List<ListNode> list = new ArrayList<>();
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);
        ListNode result = mergeKLists.mergeKLists(list);
        System.out.println(result);
    }
}
