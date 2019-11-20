package DataStructures.trees;

/**
 * Created by senthil on 25/9/16.
 */
public class IdenticalTrees {

    private boolean identicalTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) return true;

        else if (root1 != null && root2 != null){
            return ((root1.val == root2.val) &&
                    identicalTrees(root1.left, root2.left) &&
                    identicalTrees(root1.right, root2.right));
        }
        else
            return false;
    }

    public static void main(String a[]) {

        IdenticalTrees it = new IdenticalTrees();
        TreeNode root1 = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1, null, null),
                        new TreeNode(3, null, null)),
                new TreeNode(5, null, null));

        TreeNode root2 = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1, null, null),
                        new TreeNode(3, null, null)),
                new TreeNode(5,
                        new TreeNode(8, null, null),
                        null));

        System.out.println(it.identicalTrees(root1, root2));
    }
}
