package ds.trees;

public class BuildTreeFromInAndPreOrder {

    public TreeNode buildTree(int[] in, int[] pre) {

        return buildTreeRecursively(in, pre, 0, in.length - 1, 0, pre.length - 1);
    }

    public TreeNode buildTreeRecursively(int[] in, int[] pre, int instart, int inend, int prestart, int preend) {

        if (prestart > preend || instart > inend) return null;

        TreeNode root = new TreeNode(pre[prestart]);

        int k = findIndex(in, instart, inend, root.val);

        root.left = buildTreeRecursively(in, pre, instart, k - 1, prestart + 1, prestart + (k - instart));
        root.right = buildTreeRecursively(in, pre, k + 1, inend, prestart + (k - instart) + 1, preend);

        return root;
    }

    public int findIndex(int[] in, int s, int e, int val) {
        int i = s;
        for (; i <= e; i++) {
            if (in[i] == val) break;
        }
        return i;
    }

    public void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }
    public static void main(String a[]) {
        BuildTreeFromInAndPreOrder build = new BuildTreeFromInAndPreOrder();
        int[] in = new int[]{10, 12, 20, 30, 37, 40, 45};
        int[] pre = new int[]{30, 20, 10, 12, 40, 37, 45};
        TreeNode root = build.buildTree(in, pre);
        build.printInOrder(root);
    }
}
