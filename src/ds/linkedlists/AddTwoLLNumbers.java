package ds.linkedlists;

/**
 Given two integers represented as linked-lists, find their sum and return it in the form of linked list.

 Note: You can assume that the input integers are non negative and the digits stored in the linked lists are in the reverse order.
 Take a look at the examples to understand the format.

 Example:
 Input 1: 1->2->3
 Input 2: 1->2->3
 Output : 2->4->6

 Input 1: 9->9
 Input 2: 9->8
 Output : 8->8->1
 */

public class AddTwoLLNumbers {

    public static ListNode sumTwoLinkedLists(ListNode input1, ListNode input2) {
        if (input1 == null && input2 == null) return null;
        ListNode prev = new ListNode(-1);
        ListNode head = prev;
        int carry = 0;
        int sum = 0;
        while (input1 != null || input2 != null) {
            sum = (input1 != null ? input1.val : 0) + (input2 != null ? input2.val : 0) + carry;
            carry = sum / 10;
            prev.next = new ListNode(sum % 10);
            prev = prev.next;
            input1 = input1 != null ? input1.next : null;
            input2 = input2 != null ? input2.next : null;
        }
        if (carry != 0) prev.next = new ListNode(carry);
        return head.next;
    }

    //My initial solution!
    public static ListNode sumTwoLinkedLists1(ListNode input1, ListNode input2) {
        if (input1 == null && input2 == null) return null;
        ListNode prev = new ListNode(-1);
        ListNode head = prev;
        int carry = 0;
        int sum = 0;
        while (input1 != null && input2 != null) {
            sum = input1.val + input2.val + carry;
            carry = sum / 10;
            prev.next = new ListNode(sum % 10);
            prev = prev.next;
            input1 = input1.next;
            input2 = input2.next;
        }
        while (input1 != null) {
            sum = carry + input1.val;
            carry = sum / 10;
            prev.next = new ListNode(sum % 10);
            prev = prev.next;
            input1 = input1.next;
        }
        while (input2 != null) {
            sum = carry + input2.val;
            carry = sum / 10;
            prev.next = new ListNode(sum % 10);
            prev = prev.next;
            input2 = input2.next;
        }
        if (carry != 0) prev.next = new ListNode(carry);
        return head.next;
    }

    public static void main(String a[]) {
        ListNode l1 = new LinkedList().buildLinkedList(new int[]{5, 4, 9, 7}, new ListNode());
        ListNode l2 = new LinkedList().buildLinkedList(new int[]{9, 7, 9, 2}, new ListNode());
        ListNode result= AddTwoLLNumbers.sumTwoLinkedLists(l1, l2);
        System.out.println(result);
    }
}
