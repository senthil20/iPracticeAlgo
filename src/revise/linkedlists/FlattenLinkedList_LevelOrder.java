package revise.linkedlists;

import java.util.*;
import java.util.LinkedList;

/**
 *             10 --> 5 --> 12 -->7 --> 11
 *             *                  *
 *             *                  *
 *             4 --> 20 --> 13    17 --> 6
 *                   *      *     *
 *                   *      *     *
 *                   2     16     9 --> 8
 *                          *     *
 *                          *     *
 *                          3     19 --> 15
 */
public class FlattenLinkedList_LevelOrder {

    public static ListNode flattenList(FlattenListNode root) {
        if (root == null) return null;
        ListNode prev = new ListNode(-1);
        ListNode result = prev;
        Queue<FlattenListNode> queue = new LinkedList<>();
        while (root != null || !queue.isEmpty()) {
            FlattenListNode temp = (root != null ? root : (!queue.isEmpty() ? queue.poll() : null));
            if (temp != null) {
                prev.next = new ListNode(temp.val);
                prev = prev.next;
                if (temp.child != null) {
                    queue.add(temp.child);
                }
                root = temp.next;
            }
        }
        return result.next;
    }

    //from geeksforgeeks
    public static FlattenListNode flattenList1(FlattenListNode node) {
        FlattenListNode head = node;
        if (node == null) {
            return node;
        }
        FlattenListNode tmp = null;
        /* Find tail node of first level linked list */
        FlattenListNode tail = node;
        while (tail.next != null) {
            tail = tail.next;
        }
        // One by one traverse through all nodes of first level
        // linked list till we reach the tail node
        FlattenListNode cur = node;
        while (cur != tail) {
            // If current node has a child
            if (cur.child != null) {
                // then append the child at the end of current list
                tail.next = cur.child;
                // and update the tail to new last node
                tmp = cur.child;
                while (tmp.next != null) {
                    tmp = tmp.next;
                }
                tail = tmp;
            }
            // Change current node
            cur = cur.next;
        }
        return head;
    }

    public static void main(String a[]) {
        FlattenListNode root = new FlattenListNode(10,
                new FlattenListNode(5,
                        new FlattenListNode(12,
                                new FlattenListNode(7,
                                        new FlattenListNode(11, null, null),
                                        new FlattenListNode(17,
                                                new FlattenListNode(6, null, null),
                                                new FlattenListNode(9,
                                                        new FlattenListNode(8, null, null),
                                                        new FlattenListNode(19,
                                                                new FlattenListNode(15, null, null),
                                                                null)))),
                                null),
                        null),
                new FlattenListNode(4,
                        new FlattenListNode(20,
                                new FlattenListNode(13,
                                        null,
                                        new FlattenListNode(16,
                                                null,
                                                new FlattenListNode(3, null, null))),
                                new FlattenListNode(2, null, null)),
                        null));

        //ListNode result = flattenList(root);
        FlattenListNode result = flattenList1(root);
        System.out.println(result);
    }
}
