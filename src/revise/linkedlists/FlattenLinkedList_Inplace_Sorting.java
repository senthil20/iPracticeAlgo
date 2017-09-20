package revise.linkedlists;
/**
*             1 --> 2 --> 3 --> 4
*                   *           *
*                   *           *
*                   5 --> 6     7
*                   *           *
*                   *           *
*                   8           9
*
*/
public class FlattenLinkedList_Inplace_Sorting {
    /**
     * Inplace sorting
     * @param root
     * @return
     */
    public static FlattenListNode flattenListInplace(FlattenListNode root) {
        FlattenListNode A = root;
        FlattenListNode B = root;
        FlattenListNode result = root;
        while (true) {
            while (A.next != null) {
                A = A.next;
            }
            while (B != null && B.child == null) {
                B = B.next;
            }
            if (B != null) {
                A.next = B.child;
                B.child = null;
                B = B.next;
            }
            else
                break;
        }
        return result;
    }

    public static void main(String a[]) {
        FlattenListNode root = new FlattenListNode(1,
                new FlattenListNode(2,
                        new FlattenListNode(3,
                                new FlattenListNode(4,
                                        null,
                                        new FlattenListNode(7,
                                                null,
                                                new FlattenListNode(9,
                                                        null,
                                                        null))),
                                null),
                        new FlattenListNode(5,
                                new FlattenListNode(6, null, null),
                                new FlattenListNode(8, null, null))),
                null);
        FlattenListNode result = flattenListInplace(root);
        System.out.println(result);
    }
}
