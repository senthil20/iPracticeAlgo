package Revise.trees;

class TreeLinkNode {
    int val;
    TreeLinkNode left;
    TreeLinkNode right;
    TreeLinkNode next;

    TreeLinkNode() {
    }
    TreeLinkNode(int val) {
        this.val = val;
    }

    public TreeLinkNode(int val, TreeLinkNode left, TreeLinkNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = null;
    }
}

public class PopulateNextRightPointers {

    public static TreeLinkNode connect(TreeLinkNode root) {
        if (root == null) return root;

        while (root.left != null || root.right != null) {
            if (root.left != null) {

            }
        }
        return null;
    }

    public static void main(String a[]) {
        TreeLinkNode root = new TreeLinkNode(1,
                new TreeLinkNode(2,
                        new TreeLinkNode(4, null, null),
                        new TreeLinkNode(5, null, null)),
                new TreeLinkNode(3,
                        new TreeLinkNode(6, null, null),
                        new TreeLinkNode(7, null, null)));
        TreeLinkNode result = connect(root);
        System.out.println(result);
    }
}
