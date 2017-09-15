package revise.linkedlists;

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

    public static void main(String s[]) {
        LinkedList sl = new LinkedList();
        int a[] = new int[]{12, 13, 14, 18, 2, 4, 9, 20};
        ListNode head = sl.buildLinkedList(a, new ListNode());

    }
}
