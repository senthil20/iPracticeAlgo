package ds.linkedlists;

import java.util.List;

public class PartitionList {

    ListNode head;
    ListNode tail;
    int listSize = 0;

    PartitionList() {}

    PartitionList(int[] a) {
        buildLinkedList(a);
    }

    public void buildLinkedList(int[] a) {
        ListNode p = new ListNode(-1);
        head = p;

        for(int i : a) {
            head.next = new ListNode(i);
            head = head.next;
        }
        head = p.next;
    }

    public ListNode partitionList(int x) {

        ListNode p = new ListNode(-1);
        ListNode n = new ListNode(-1);

        n.next = head;
        ListNode nHead = n;

        p.next = head;
        head = p;

        ListNode c = p.next;

        while (c != null) {
            if (c.val < x) {
                p.next = c.next;

                nHead.next = c;
                nHead = nHead.next;

                c = p.next;
            }
            else {
                p = p.next;
                c = p.next;
            }
        }
        nHead.next = head.next;
        return n.next;
    }

    public static void main(String args[]) {
        int a[] = new int[]{1, 4, 8, 5, 7, 9, 3};
        PartitionList pl = new PartitionList(a);
        pl.partitionList(8);
    }
}
