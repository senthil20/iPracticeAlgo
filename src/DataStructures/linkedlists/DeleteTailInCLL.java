package DataStructures.linkedlists;

/**
 Given a circular-linked list, write a function to delete its tail node and return the modified list's head.
 *x = indicates head node
 1->2->3->4->*1 ==> 1->2->3->*1
 */
public class DeleteTailInCLL {

    public ListNode deleteAtTail(ListNode head) {
        if (head == null || head.next == head) return null;
        ListNode previous = head;
        ListNode current = previous.next;
        while (current.next != head) {
            previous = previous.next;
            current = previous.next;
        }
        previous.next = current.next;
        return head;
    }

    public static void main(String a[]) {

    }

}
