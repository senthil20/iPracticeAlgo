package Revise.linkedlists;

public class IntersectionOfTwoLinkedLists {

    public static ListNode intersectNode(ListNode A, ListNode B) {
        if (A == null || B == null) return null;
        ListNode AHead = A;
        ListNode BHead = B;
        int count = 0;
        while (true) {
            while (A.next != null && B.next != null) {
                if (A == B) {
                    return A;
                }
                A = A.next;
                B = B.next;
            }
            if (A.next == null) {
                A = BHead;
            }
            else if (B.next == null) {
                B = AHead;
            }
            if (count == 2) return null;
            count++;
        }
    }

    public static void main(String a[]) {
        ListNode root1 = new LinkedList().buildLinkedList(new int[]{1, 2, 3}, new ListNode());
        ListNode root2 = new LinkedList().buildLinkedList(new int[]{2, 3}, new ListNode());
        ListNode next = new LinkedList().buildLinkedList(new int[]{4, 5, 6}, new ListNode());

        ListNode A = root1;
        ListNode B = root2;

        while (root1.next != null) {
            root1 = root1.next;
        }
        root1.next = next;
        while (root2.next != null) {
            root2 = root2.next;
        }
        root2.next = next;
        ListNode result = intersectNode(A, B);
        System.out.println(result);
    }
}
