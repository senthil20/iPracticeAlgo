package DataStructures.linkedlists;

/**
 * Note: Try to solve this task in O(n) time using O(1) additional space, where n is the number of elements in the list,
 * since this is what you'll be asked to do during an interview.

 Given a singly linked list of integers l and an integer k, remove all elements from list l that have a value equal to k.
 Example
 For l = [3, 1, 2, 3, 4, 5] and k = 3, the output should be
 removeKFromList(l, k) = [1, 2, 4, 5];
 For l = [1, 2, 3, 4, 5, 6, 7] and k = 10, the output should be
 removeKFromList(l, k) = [1, 2, 3, 4, 5, 6, 7].
 */
public class RemoveKFromList {

    static ListNode removeKFromList(ListNode l, int k) {
        if (l == null) return l;
        ListNode prev = new ListNode(-1);
        ListNode result = prev;
        //123, 456, 789, 0
        while (l != null) {
            if (l.val != k) {
                prev.next = l;
                prev = prev.next;
            }
            l = l.next;
        }
        prev.next = null;
        return result.next;
    }

    public static void main(String a[]) {
        ListNode root = new LinkedList().buildLinkedList(new int[]{123, 456, 789, 0}, new ListNode());
        ListNode result = removeKFromList(root, 0);
        System.out.println(result);
    }
}
