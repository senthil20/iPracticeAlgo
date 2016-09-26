package ds.trees;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversalBST {

    //tc: o(n) sc: o(n)
    public void postOrderRecursive(TreeNode root) {
        if (root == null) return;
        postOrderRecursive(root.left);
        postOrderRecursive(root.right);
        System.out.print(root.val + " ");
    }

    // nodes won't be retained
    //tc: o(n) sc: o(n)
    public List<Integer> postOrderIterative1(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) return result;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            TreeNode temp = st.peek();

            if (temp.left == null || temp.right == null)
                result.add(st.pop().val);
            else {
                if (temp.right != null) {
                    st.push(temp.right);
                    temp.right = null;
                }
                if (temp.left != null) {
                    st.push(temp.left);
                    temp.left = null;
                }
            }
        }
        return result;
    }

    //tc: o(n) sc: o(n)
    public ArrayList<Integer> postorderIterative(TreeNode root) {

        ArrayList<Integer> lst = new ArrayList<Integer>();

        if(root == null)
            return lst;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        TreeNode prev = null;

        while(!stack.empty()){

            TreeNode curr = stack.peek();

            if (prev == null || prev.left == curr || prev.right == curr) {

                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                } else {
                    stack.pop();
                    lst.add(curr.val);
                }
            } else if (curr.left == prev) {
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            }
            else {
                stack.pop();
                lst.add(curr.val);
            }
            prev = curr;
        }
        return lst;
    }


    public static void main(String a[]) {
        PostOrderTraversalBST pt = new PostOrderTraversalBST();
        int[] ar = new int[]{1, 3, 5, 7, 9, 14, 18, 21};
        TreeNode root = new BSTBasicOperations().buildTreeSortedArray(new TreeNode(), ar, 0, ar.length - 1);
        pt.postorderIterative(root);
        //pt.postOrderIterative1(root);
        //pt.postOrderRecursive(root);
    }
 }
