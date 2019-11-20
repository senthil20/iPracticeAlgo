package DataStructures.linkedlists;

import java.util.LinkedList;
import java.util.ListIterator;

public class MergeTwoLists {

    public static LinkedList<Integer> mergeTwoLinkedLists(LinkedList l1, LinkedList l2) {

        boolean iterateList1 = false;
        boolean iterateList2 = false;

        LinkedList result = new LinkedList();

        //ListIterator l1Iterator = l1.listIterator();
        //ListIterator l2Iterator = l2.listIterator();

        while (!l1.isEmpty() && !l2.isEmpty()) {
            if ((Integer)l1.peek() <= (Integer)l2.peek()) {
                result.add(l1.pop());
            }
            else {
                result.add(l2.pop());
            }
        }

        while (!l1.isEmpty()) {
            result.add(l1.pop());
        }
        while (!l2.isEmpty()) {
            result.add(l2.pop());
        }
        return result;
    }

    public ListNode mergeListsRecursion(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val) {
            l1.next = mergeListsRecursion(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeListsRecursion(l2.next, l1);
            return l2;
        }
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
        MergeTwoLists mlists = new MergeTwoLists();

        LinkedList input1 = new LinkedList();
        LinkedList input2 = new LinkedList();
        input1.add(1);input1.add(4);input1.add(8);input1.add(10);
        input2.add(3);input2.add(5);input2.add(7);

        LinkedList result = mergeTwoLinkedLists(input1, input2);

        System.out.println(result);

        ListNode l1 = mlists.buildLinkedList(new int[]{1, 2, 13, 20}, new ListNode());
        ListNode l2 = mlists.buildLinkedList(new int[]{1, 20, 35, 40}, new ListNode());
        mlists.mergeLists(l1, l2);
        //ListNode head = mlists.mergeListsRecursion(l1, l2);


    }
}
