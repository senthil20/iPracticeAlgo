package ds.linkedlists;

/**
 *
 Given a singly linked list, determine if its a palindrome. Return 1 or 0 denoting if its a palindrome or not, respectively.
 Notes:
 Expected solution is linear in time and constant in space.
 For example,
 List 1-->2-->1 is a palindrome.
 List 1-->2-->3 is not a palindrome.
 */

public class ListPalindrome {

    public int lPalin(ListNode A) {
        if (A == null || A.next == null) return 1;
        int lSize = size(A);
        int mid = lSize / 2;
        ListNode first = A;
        for (int i = 0; i < mid; i++) {
            first = first.next;
        }
        ListNode second = reverse(first);
        while (A != null && second != null) {
            if (A.val != second.val) return 0;
            A = A.next;
            second = second.next;
        }
        return 1;
    }

    public ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public int size(ListNode A) {
        int count = 0;
        while (A != null) {
            A = A.next;
            count++;
        }
        return count;
    }

    static boolean isListPalindrome(ListNode l) {
        if (l == null) return true;
        ListNode sp = l;
        ListNode fp = l;

        while (fp.next != null && fp.next.next != null) {
            sp = sp.next;
            fp = fp.next.next;
        }
        ListNode second = sp.next;
        sp.next = null;
        ListNode first = l;
        ListNode secondRev = reverse1(second);

        while (first != null && secondRev != null) {
            if (Integer.compare(first.val, secondRev.val) != 0) return false;
            first = first.next;
            secondRev = secondRev.next;
        }
        return true;
    }

    static ListNode reverse1(ListNode node) {
        ListNode prev = null;
        ListNode next = null;
        while (node != null) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

    public static void main(String a[]) {
        //int A[] = new int[]{1, 1000000000, -1000000000, -1000000000, 1000000000, 1};
        /*
        int A[] = new int[]{1, 2, 3, 3, 2};
        ListNode head = new LinkedList().buildLinkedList(A, new ListNode());
        System.out.println(new ListPalindrome().isListPalindrome(head));
        */
        int A[] = new int[]{1,2,3,4,3,2,1};
        ListNode head = new LinkedList().buildLinkedList(A, new ListNode());
        System.out.println(new ListPalindrome().lPalin(head));
    }
}
