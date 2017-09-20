package revise.trees;

import java.util.Stack;

/**
 Input Tree
            5
          /   \
         4     7
        /     / \
       2     6  9
     / \      /  \
    1  3     8   9

    5,4,2,1,#,#,3,#,#,#,7,6,#,#,11,8,#,#,12,#,#

 */
public class SerializeDeserializeBinaryTree {

    public static void serialize(TreeNode root, StringBuffer sb) {
        if (root == null) {
            sb.append("#").append(",");
            return;
        }
        serialize(root.left, sb.append(root.val).append(","));
        serialize(root.right, sb);
    }

    //5,4,2,1,#,#,3,#,#,#,7,6,#,#,9,8,#,#,9,#,#
    public static TreeNode deserialize(String str) {
        if (str == null || str.length() == 0) return null;
        return buildTreeRecursively(str.split(","), new int[]{0});
    }

    public static TreeNode buildTreeRecursively(String[] str, int[] index) {
        if (index[0] > str.length - 1 || str[index[0]].equalsIgnoreCase("#")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(str[index[0]]));
        index[0]++;
        node.left = buildTreeRecursively(str, index);
        index[0]++;
        node.right = buildTreeRecursively(str, index);
        return node;
    }


    public static void main(String a[]) {
        TreeNode root = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(2,
                                new TreeNode(1, null, null),
                                new TreeNode(3, null, null)),
                        null),
                new TreeNode(7,
                        new TreeNode(6, null, null),
                        new TreeNode(9,
                                new TreeNode(8, null, null),
                                new TreeNode(9, null, null))));

        StringBuffer sb = new StringBuffer();
        serialize(root, sb);
        System.out.println(sb.toString());
        TreeNode node = deserialize(sb.deleteCharAt(sb.length() - 1).toString());
        System.out.println(node);
    }
}
