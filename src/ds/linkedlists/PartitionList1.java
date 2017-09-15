package ds.linkedlists;

/**
 Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.
 */
public class PartitionList1 {

    public static ListNode partition(ListNode a, int b) {

        if (a == null) return a;
        ListNode prev = new ListNode(-1);
        ListNode nHead = null;
        ListNode nHeadTemp = null;
        ListNode curr = a;
        a = prev;
        while (curr != null) {
            if (curr.val < b) {
                prev.next = curr;
                prev = prev.next;
            }
            else {
                if (nHead == null) {
                    nHead = nHeadTemp = curr;
                }
                else {
                    nHeadTemp.next = curr;
                    nHeadTemp = nHeadTemp.next;
                }
            }
            curr = curr.next;
        }
        if (nHeadTemp != null) nHeadTemp.next = null;
        prev.next = nHead;
        return a.next;
    }

    public static void main(String a[]) {
        ListNode root = new LinkedList().buildLinkedList(new int[]{192,856,647,251,498,749,252,577,322,794,490,278,754,505,688,418,486,3,700,680,707,892,37,666,9,858,802,82,441,500,64,373,174,779,346,803,760,48,783,654,731,391,733,480,5,144,919,291,180,50,326,90,437,502,527,648,361,828,729,546,934,69,209,187,365,329,276,86,348,986,344,183,495}, new ListNode());
        ListNode result = partition(root, 40);
        System.out.println(result);
    }
}
