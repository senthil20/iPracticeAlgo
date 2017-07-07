package ds.trees;

/**
 * Created by senthil on 25/9/16.
 */
/*
* the tree...
       4
      / \
     2   5
    / \
   1   3

 is changed to...
       4
      / \
     5   2
        / \
       3   1
*
* */
public class MirrorTree {

    public void mirrorTree(TreeNode root) {
        if (root == null) return;
        mirrorTree(root.left);
        mirrorTree(root.right);
        swap(root);
    }

    public void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
    public TreeNode mirror(TreeNode root) {
        if (root.left == null || root.right == null) return root;
        mirror(root.left);
        mirror(root.right);
        return swap1(root);
    }

    public TreeNode swap1(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        return node;
    }

    public static void main(String a[]) {
        MirrorTree mt = new MirrorTree();
        TreeNode root = new TreeNode(4,
                                new TreeNode(2,
                                        new TreeNode(1, null, null),
                                        new TreeNode(3, null, null)),
                                new TreeNode(5, null, null));
        //mt.mirrorTree(root);
        mt.mirror(root);
        System.out.println(root);
    }
 }
