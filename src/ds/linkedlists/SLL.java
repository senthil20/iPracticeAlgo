package ds.linkedlists;

/**
 * Created by senthil on 17/7/16.
 */

class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class SLL {

    ListNode l1Head;
    ListNode l2Head;

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


    public int length(ListNode a) {
        int counter = 0;
        while(a != null) {
            counter++;
            a = a.next;
        }
        return counter;
    }

    private ListNode merge(ListNode l, ListNode r) {

        ListNode p = new ListNode(-1);
        ListNode tail = p;

        while(l != null && r != null) {

            if(l.val <= r.val) {
                tail.next = l;
                l = l.next;
            }
            else {
                tail.next = r;
                r = r.next;
            }
            tail = tail.next;
        }

        while(l != null) {
            tail.next = l;
            break;

        }

        while(r != null) {
            tail.next = r;
            break;
        }
        return p.next;
    }

    private ListNode sortList(ListNode a) {

        if(a == null || length(a) == 1) return a;

        int mid = length(a)/2;

        ListNode l= a;
        ListNode lTail = a;
        ListNode r = null;

        for(int i = 1; i < mid; i++) {
            lTail = lTail.next;
        }

        r = lTail.next;
        lTail.next = null;

        l = sortList(l);
        r = sortList(r);
        return merge(l, r);
    }

    public static void main(String s[]) {

        SLL sl = new SLL();
        int a[] = new int[]{12,13,14,18,2,4,9,20};
        int a1[] = new int[]{2,3,4,8};

        sl.l1Head = sl.buildLinkedList(a, sl.l1Head);
        //sl.l2Head = sl.buildLinkedList(a1, sl.l2Head);

        sl.sortList(sl.l1Head);
    }

}
