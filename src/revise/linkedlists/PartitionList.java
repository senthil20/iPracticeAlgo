package revise.linkedlists;

/**
 Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.
 */
public class PartitionList {

    //7,8,9,3,2,1,5,11,15,4,0
    //x=6
    public static ListNode partitionList(ListNode a, int b) {
        ListNode sNode = new ListNode(-1);
        ListNode gNode = new ListNode(-1);
        ListNode sHead = null;
        ListNode gHead = null;
        while (a != null) {
            if (a.val < b) {
                if (sHead == null) sHead = a;
                sNode.next = a;
                sNode = sNode.next;
            }
            else {
                if (gHead == null) gHead = a;
                gNode.next = a;
                gNode = gNode.next;
            }
            a = a.next;
        }
        if (gNode.next != null) gNode.next = null;
        sNode.next = gHead;
        return sHead;
    }

    public static void main(String a[]) {
        ListNode root = new LinkedList().buildLinkedList(new int[]{192,856,647,251,498,749,252,577,322,794,490,278,754,505,688,418,486,3,700,680,707,892,37,666,9,858,802,82,441,500,64,373,174,779,346,803,760,48,783,654,731,391,733,480,5,144,919,291,180,50,326,90,437,502,527,648,361,828,729,546,934,69,209,187,365,329,276,86,348,986,344,183,495}, new ListNode());
        //ListNode result = partitionList(root, 40);
        ListNode root1 = new LinkedList().buildLinkedList(new int[]{7,8,9,3,2,1,5,11,15,4,0}, new ListNode());
        ListNode result1 = partitionList(root1, 5);
        System.out.println(result1);
    }
}
