package ds.trees;

public class BuildTreeFromInAndPostOrder {

    public TreeNode buildTree(int[] in, int[] post) {

        return buildTreeRecursively(in, post, 0, in.length - 1, 0, post.length - 1);
    }

    public TreeNode buildTreeRecursively(int[] in, int[] post, int instart, int inend, int poststart, int postend) {

        if (poststart > postend || instart > inend) return null;

        TreeNode root = new TreeNode(post[postend]);

        int k = findIndex(in, instart, inend, root.val);

        root.left = buildTreeRecursively(in, post, instart, k - 1, poststart, poststart + k - (instart + 1));
        root.right = buildTreeRecursively(in, post, k + 1, inend, poststart + k - instart, postend - 1);

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
        BuildTreeFromInAndPostOrder build = new BuildTreeFromInAndPostOrder();
        int[] in = new int[]{4, 2, 5, 1, 3, 6};
        int[] post = new int[]{4, 5, 2, 6, 3, 1};
        TreeNode root = build.buildTree(in, post);
        build.printInOrder(root);
    }
}
