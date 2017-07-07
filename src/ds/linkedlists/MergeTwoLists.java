package ds.linkedlists;

import com.sun.xml.internal.org.jvnet.mimepull.MIMEMessage;

public class MergeTwoLists {

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
        ListNode l1 = mlists.buildLinkedList(new int[]{1, 2, 13, 20}, new ListNode());
        ListNode l2 = mlists.buildLinkedList(new int[]{1, 20, 35, 40}, new ListNode());
        mlists.mergeLists(l1, l2);
        //ListNode head = mlists.mergeListsRecursion(l1, l2);
    }
}
