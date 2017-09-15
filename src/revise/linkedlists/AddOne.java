package revise.linkedlists;

public class AddOne {

    public static ListNode addOne(ListNode a) {
        if (a == null) return a;
        int carry = addOneRecursively(a, 1);
        if (carry != 0) {
            ListNode head = new ListNode(carry);
            head.next = a;
            return head;
        }
        return a;
    }

    public static int addOneRecursively(ListNode a, int carry) {
        if (a == null) return carry;
        carry = addOneRecursively(a.next, carry);
        int sum = a.val + carry;
        carry = sum / 10;
        a.val = sum % 10;
        return carry;
    }

    public static ListNode addOneIterative(ListNode a) {

        ListNode result = null;
        ListNode next = null;
        ListNode curr = a;
        while (curr != null) {
            if (curr.val < 9) {
                next = curr;
            }
            curr = curr.next;
        }
        curr = a;
        if (next == null) {
            result = new ListNode(1);
            result.next = curr;
            while (curr != null) {
               curr.val = 0;
               curr = curr.next;
            }
            return result;
        }
        else {
            result = curr;
            while (curr != null) {
                if (curr == next) {
                    curr.val = curr.val + 1;
                    curr = curr.next;
                    while (curr != null) {
                        curr.val = 0;
                        curr = curr.next;
                    }
                }
                else {
                    curr = curr.next;
                }
            }
            return result;
        }
    }


    public static void main(String args[]) {
        LinkedList list = new LinkedList();
        int a[] = new int[]{9, 9, 9, 9, 9};
        ListNode head = list.buildLinkedList(a, new ListNode());
        //ListNode result = addOne(head);
        ListNode result = addOneIterative(head);
        System.out.println(result);
    }
}
