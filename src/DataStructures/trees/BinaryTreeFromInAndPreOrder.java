package DataStructures.trees;

/**
 * Created by senthil on 29/9/16.
 */
public class BinaryTreeFromInAndPreOrder {

    public TreeNode buildBTFromInAndPreOrder(char[] in, char[] pre) {

        if (in == null || pre == null || in.length != pre.length) return null;

        return buildTreeRecursively(in, 0, in.length - 1, pre, 0, pre.length - 1, null);

    }

    public TreeNode buildTreeRecursively(char[] in, int instart, int inend,
                                         char[] pre, int prestart, int preend, TreeNode root) {

        if (prestart <= preend) {

            if (root == null) root = new TreeNode(pre[prestart], null, null);

            int offset = findIndex(in, pre[prestart]);

            root.left = buildTreeRecursively(in, instart, offset - 1, pre, prestart + 1, preend, root);
            root.right = buildTreeRecursively(in, instart, offset + 1, pre, prestart + 1, preend, root);

        }

        return root;
    }

    public int findIndex(char[] in, char pre) {
        int i = 0;
        for (;i < in.length; i++) {
            if (in[i] == pre) break;
        }
        return i;
    }


    public static void main(String a[]) {

        char in[] = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        char pre[] = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};


    }
}
