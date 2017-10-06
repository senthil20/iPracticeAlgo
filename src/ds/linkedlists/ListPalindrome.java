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

    public static void main(String a[]) {
        int A[] = new int[]{1,2,3,4,3,2,1};
        ListNode head = new LinkedList().buildLinkedList(A, new ListNode());
        System.out.println(new ListPalindrome().lPalin(head));
    }

}
