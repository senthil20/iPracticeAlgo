package ds.linkedlists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by sydgsk9 on 5/15/2017.
 */
public class MergeKListPQ {

    public ListNode mergeKListsUsingPQ(List<ListNode> lists) {
        ListNode prev = new ListNode(-1);
        ListNode head = prev;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });

        for (int i = 0; i < lists.size(); i++) {
            ListNode temp = lists.get(i);
            pq.add(temp);
        }

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            prev.next = node;
            prev = prev.next;

            if (node.next != null) {
                pq.add(node.next);
            }
        }
        return head.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
                return Integer.compare(l1.val, l2.val);
            }
        });
        for (ListNode node : lists) {
            pq.add(node);
        }
        ListNode prev = new ListNode(-1);
        ListNode result = prev;
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
        LinkedList ll = new LinkedList();
        MergeKListPQ ml = new MergeKListPQ();
        ListNode l1 = ll.buildLinkedList(new int[]{1, 2, 13, 20}, new ListNode());
        ListNode l2 = ll.buildLinkedList(new int[]{3, 4, 35, 41}, new ListNode());
        ListNode l3 = ll.buildLinkedList(new int[]{5, 9, 11, 25}, new ListNode());
        ListNode l4 = ll.buildLinkedList(new int[]{1, 21, 39, 40}, new ListNode());
        /*List<ListNode> list = new ArrayList<>();
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);
        ListNode result = ml.mergeKListsUsingPQ(list);*/
        ListNode result = ml.mergeKLists(new ListNode[]{l1, l2, l3, l4});
        System.out.println(result);
    }

}
