package revise.linkedlists;
/**
 *             1 --> -1 --> -1 --> 10 --> 11
 *                  *        *
 *                 *          *
 *               -1 --> 4      5 --> -1 --> 9
 *               *                  *
 *              *                  *
 *             2 --> 3           -1
 *                              *
 *                             *
 *                            6 --> 7 --> 8
 */
class FlattenListNode {
    int val;
    FlattenListNode next;
    FlattenListNode child;
    FlattenListNode(int data, FlattenListNode next, FlattenListNode child) {
        this.val = data;
        this.next = next;
        this.child = child;
    }
}
public class FlattenLinkedList {
    public static FlattenListNode flattenList(FlattenListNode root) {
        if (root == null) return root;
        FlattenListNode result = new FlattenListNode(-1, null, null);
        dfs(root, result);
        return result.next;
    }

    public static FlattenListNode dfs(FlattenListNode node, FlattenListNode result) {
        if (node == null) return result;
        if (node != null && node.child == null && node.val != -1) {
            result.next = node;
            result = result.next;
        }
        result = dfs(node.child, result);
        result = dfs(node.next, result);
        return result;
    }

    public static void main(String a[]) {
        FlattenListNode root = new FlattenListNode(1,
                new FlattenListNode(-1,
                        new FlattenListNode(-1,
                                new FlattenListNode(10, null, null),
                                new FlattenListNode(5,
                                        new FlattenListNode(-1,
                                                new FlattenListNode(9, null, null),
                                                new FlattenListNode(-1,
                                                        null,
                                                        new FlattenListNode(6,
                                                                new FlattenListNode(7,
                                                                        new FlattenListNode(8,
                                                                                null, null),
                                                                        null),
                                                                null))),
                                        null)),
                        new FlattenListNode(-1,
                                new FlattenListNode(4, null, null),
                                new FlattenListNode(2,
                                        new FlattenListNode(3, null, null),
                                        null))),
                null);

        FlattenListNode result = flattenList(root);
        System.out.println(result);
    }
}
