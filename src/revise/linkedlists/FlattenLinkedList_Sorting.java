package revise.linkedlists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 *             5 --> 10 --> 19 -->28
 *             *     *      *      *
 *             *     *      *      *
 *             7    20      22    35
 *             *            *     *
 *             *            *     *
 *             8            50    40
 *             *                  *
 *             *                  *
 *            30                  45
 */

public class FlattenLinkedList_Sorting {

    /**
     * Merge from last node with prev node and return that merged head node.
     * @param root
     * @return
     */
    public static FlattenListNode flattenListSortingMerge(FlattenListNode root) {

        if (root == null || root.next == null) return root;
        root.next = flattenListSortingMerge(root.next);
        root = merge(root, root.next);
        return root;
    }

    public static FlattenListNode merge(FlattenListNode curr, FlattenListNode next) {
        FlattenListNode prev = new FlattenListNode(-1, null, null);
        FlattenListNode result = prev;
        while (curr != null && next != null) {
            if (curr.val < next.val) {
                prev.child = curr;
                curr = curr.child;
            }
            else {
                prev.child = next;
                next = next.child;
            }
            prev = prev.child;
        }
        if (curr != null) {
            prev.child = curr;
        }
        if (next != null) {
            prev.child = next;
        }
        return result.child;
    }

    /**
     * Add each next node into list and use PQ.
     * @param root
     * @return
     */
    public static ListNode flattenListSorting(FlattenListNode root) {
        if (root == null) return null;
        List<FlattenListNode> inputList = new ArrayList<>();
        while (root != null) {
            FlattenListNode temp = root.next;
            root.next = null;
            inputList.add(root);
            root = temp;
        }
        PriorityQueue<FlattenListNode> pq = new PriorityQueue<>(new Comparator<FlattenListNode>() {
            @Override
            public int compare(FlattenListNode o1, FlattenListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (FlattenListNode node : inputList) {
            pq.add(node);
        }
        ListNode prev = new ListNode(-1);
        ListNode result = prev;
        while (!pq.isEmpty()) {
            FlattenListNode temp = pq.poll();
            prev.next = new ListNode(temp.val);
            prev = prev.next;
            if (temp.child != null) {
                pq.add(temp.child);
            }
        }
        return result.next;
    }


    /**
     * Similar to above method
     * @param root
     * @return
     */
    public static ListNode flattenListSorting1(FlattenListNode root) {
        if (root == null) return null;
        List<ListNode> inputList = new ArrayList<>();
        while (root != null) {
            ListNode prev = new ListNode(-1);
            ListNode temp = new ListNode(root.val);
            prev.next = temp;
            while (root.child != null) {
                temp.next = new ListNode(root.child.val);
                temp = temp.next;
                root.child = root.child.child;
            }
            inputList.add(prev.next);
            root = root.next;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode node : inputList) {
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
        FlattenListNode root = new FlattenListNode(5,
                new FlattenListNode(10,
                        new FlattenListNode(19,
                                new FlattenListNode(28,
                                        null,
                                        new FlattenListNode(35,
                                                null,
                                                new FlattenListNode(40,
                                                        null,
                                                        new FlattenListNode(45, null,null)))),
                                new FlattenListNode(22,
                                        null,
                                        new FlattenListNode(50, null, null))),
                        new FlattenListNode(20, null, null)),
                new FlattenListNode(7, null,
                        new FlattenListNode(8,
                                null,
                                new FlattenListNode(30, null, null))));

        //ListNode result = flattenListSorting(root);
        //FlattenListNode result = flattenListSortingMerge(root);
        ListNode result = flattenListSorting1(root);
        System.out.println(result);
    }
}
