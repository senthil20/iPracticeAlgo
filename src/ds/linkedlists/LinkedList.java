package ds.linkedlists;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
    public ListNode() {
    }
}

public class LinkedList {

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
       List list = new ArrayList();
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

    public ListNode deleteAtMiddle(ListNode head, int position) {
        if (head == null) return head;
        ListNode p = new ListNode(-1);
        p.next = head;
        head = p;
        ListNode c = p.next;
        int count = 1;
        while (c != null) {
            if (count == position) {
                p.next = c.next;
                c = c.next;
                return head.next;
            }
            else {
                p.next = c;
                p = c;
                c = c.next;
                count++;
            }
        }
        return head.next;
    }

    public ListNode deleteAtHead(ListNode head) {
        if (head == null) return null;
        ListNode newHead = head.next;
        ListNode p = newHead;
        while (p.next != null) {
            p = p.next;
        }
        p.next = newHead;
        return newHead;
    }

    public ListNode findNthNodeFromEnd(ListNode head, int n) {
        if (head == null) return null;
        int length = length(head);
        if (n == 0 || n > length) return null;
        int count = 0;
        while (head != null) {
            if (length - count == n) {
                return head;
            }
            count++;
            head = head.next;
        }
        return null;
    }

    public ListNode findNthNodeFromEnd1(ListNode head, int n) {
        if (n < 1)
            return null;
        ListNode fast = head;
        for(int i = 0; i < n; i++) {
            if (fast == null)
                return null;
            fast = fast.next;
        }
        while(fast != null) {
            head = head.next;
            fast = fast.next;
        }
        return head;
    }

    public ListNode insertAtPosition(ListNode head, int data, int pos) {
        if (head == null) return null;
        ListNode p = new ListNode(-1);
        p.next = head;
        head = p;
        int count = 1;
        while (p != null && p.next != null) {
            if (count == pos) {
                ListNode node = new ListNode(data);
                ListNode next = p.next;
                p.next = node;
                node.next = next;
                return head.next;
            }
            else p = p.next;
            count++;
        }
        ListNode temp = new ListNode(data);
        p.next = temp;
        temp.next = null;
        return head;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            System.out.print(curr);
        }
        return prev;
    }

    public ListNode reverseListRecursively(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = null;
        ListNode toreturn = reverseListRecursively(next);
        next.next = head;
        return toreturn;
    }

    public static void main(String s[]) {
        LinkedList sl = new LinkedList();
        int a[] = new int[]{12,13,14,18,2,4,9,20};
        //int a1[] = new int[]{1,2,3,4,5,6,7,8,8,6,5,4,3,2,1};
        int a1[] = new int[]{1,2,3,4,5};

        ListNode head1 = sl.buildLinkedList(a1, new ListNode());
        //ListNode head2 = sl.buildLinkedList(a1, new ListNode());

        //sl.sortList(head1);
        //sl.deleteAtMiddle(head1, 3);
        //ListNode result = sl.deleteAtHead(head1);
        //System.out.println(sl.findNthNodeFromEnd1(head1, 3));
        //ListNode head = sl.insertAtPosition(head1, 10, 1);
        System.out.println(sl.reverseListRecursively(head1));
    }
}
