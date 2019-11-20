package DataStructures.trees;

import java.util.*;

public class SerializeBinaryTree {
    TreeNode result = null;
    /**
    Tree
             5
           /   \
          4     7
         /     / \
        2     6  11
       / \      /  \
      1  3     8  12
    */

    public String serializeTree1(TreeNode root){
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp != null) {
                sb.append(String.valueOf(temp.val)).append(",");
                queue.add(temp.left);
                queue.add(temp.right);
            }
            else
                sb.append("#,");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public TreeNode restoreTree1(String str){
        String[] data = str.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(data[0]));
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp == null) continue;
            if (!"#".equals(data[i])) {
                temp.left = new TreeNode(Integer.valueOf(data[i]));
                queue.add(temp.left);
            }
            else {
                temp.left = null;
                queue.add(null);
            }
            i++;
            if (!"#".equals(data[i])) {
                temp.right = new TreeNode(Integer.valueOf(data[i]));
                queue.add(temp.right);
            }
            else {
                temp.right = null;
                queue.add(null);
            }
            i++;
        }
        return root;
    }


    /*public String serialize(TreeNode root) {
        if(root==null)
            return null;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            TreeNode h = stack.pop();
            if(h!=null){
                sb.append(h.val+",");
                stack.push(h.right);
                stack.push(h.left);
            }else{
                sb.append("#,");
            }
        }

        return sb.toString().substring(0, sb.length()-1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null)
            return null;

        int[] t = {0};
        String[] arr = data.split(",");

        return helper(arr, t);
    }

    public TreeNode helper(String[] arr, int[] t){
        if(arr[t[0]].equals("#")){
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(arr[t[0]]));

        t[0]=t[0]+1;
        root.left = helper(arr, t);
        t[0]=t[0]+1;
        root.right = helper(arr, t);

        return root;
    }*/

    public String serializeTree(TreeNode root){
        if (root == null) return null;
        StringBuffer sb = new StringBuffer();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (temp != null) {
                sb.append(temp.val).append(",");
                stack.push(temp.right);
                stack.push(temp.left);
            }
            else {
                sb.append("$").append(",");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public TreeNode restoreTree(String str){
        if (str == null) return null;
        String[] nodeData = str.split(",");
        int[] count = {0};
        return nodeBuilder(nodeData, count);
    }

    public TreeNode nodeBuilder(String[] nodeData, int[] count) {
        if ("$".equals(nodeData[count[0]])) return null;
        TreeNode root = new TreeNode(Integer.valueOf(nodeData[count[0]]));
        count[0] = count[0] + 1;
        root.left = nodeBuilder(nodeData, count);
        count[0] = count[0]+ 1;
        root.right = nodeBuilder(nodeData, count);
        return root;
    }

    public void test() {
        int i = 5;
        i = i + 1;
        i++;
        i = ++i;

        int[] data = new int[5];
        data[0]++;
        data[0] = data[0]++;
        String s = "testt";
        for (;i < s.length(); i++) {
            char c = s.charAt(i);
            data[c - 'a']++;
        }
    }

    public static void main(String a[]) {
        SerializeBinaryTree sb = new SerializeBinaryTree();
        sb.test();
        TreeNode root = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(2,
                                new TreeNode(1, null, null),
                                new TreeNode(3, null, null)),
                        null),
                new TreeNode(7,
                        new TreeNode(6, null, null),
                        new TreeNode(11,
                                new TreeNode(8, null, null),
                                new TreeNode(12, null, null))));
        //TreeNode node = sb.restoreTree(sb.serializeTree(root));
        //TreeNode node = sb.deserialize(sb.serialize(root));
        TreeNode node = sb.restoreTree1(sb.serializeTree1(root));
        System.out.println(node);

    }
}
