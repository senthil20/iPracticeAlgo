package DataStructures.linkedlists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKLists {

    public ListNode mergeKLists(List<ListNode> lists) {
        return mergeRecursion(lists, 0, lists.size() - 1);
    }

    public ListNode mergeRecursion(List<ListNode> lists, int start, int end) {
        if (start >= end) return lists.get(start);
        int mid = (start + end) / 2;
        ListNode left = mergeRecursion(lists, start, mid);
        ListNode right = mergeRecursion(lists, mid + 1, end);
        return mergeLists(left, right);
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

    public ListNode mergeKListsUsingPQ(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });
        for (ListNode listNode : lists) {
            pq.add(listNode);
        }
        ListNode prev = new ListNode(-1);
        ListNode head = prev;
        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();
            prev.next = temp;
            prev = prev.next;
            if (temp.next != null) pq.add(temp.next);
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
        ListNode l4 = mergeKLists.buildLinkedList(new int[]{0, 21, 39, 40}, new ListNode());
        List<ListNode> list = new ArrayList<>();
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);
        //ListNode result = mergeKLists.mergeKLists(list);
        ListNode result = mergeKLists.mergeKListsUsingPQ(list);
        System.out.println(result);
    }
}
