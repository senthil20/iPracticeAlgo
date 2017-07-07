package ds.trees;

import ds.binarysearch.BinarySearch;

import java.security.Key;
import java.util.*;

class TreeNode {
    int val;
    String value;
    char c;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    TreeNode(char val, TreeNode left, TreeNode right) {
        this.c = val;
        this.left = left;
        this.right = right;
    }
}

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

    TreeLinkNode(int val, TreeLinkNode left, TreeLinkNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = null;
    }
}

public class BSTBasicOperations {
    TreeNode root;

    //insert element in binary search tree
    //tc: o(n)
    public void buildTree(int a[]) {
        if (a == null || a.length == 0) return;
        for (int val : a)
            root = buildRecursively(root, val);
    }

    public TreeNode buildRecursively(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val, null, null);
            return root;
        }

        if(val <= root.val)
            root.left = buildRecursively(root.left, val);
        else
            root.right = buildRecursively(root.right, val);

        return root;
    }

    //tc: o(n)
    public TreeNode insert(TreeNode root, int val) {

        if (root == null) {
            root = new TreeNode(val, null, null);
            return root;
        }

        if(val <= root.val)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);

        return root;
    }

    //search element in binary search tree
    //tc: o(log n), o(n) worst case if BST is a skew tree
    public boolean searchElement(TreeNode root, int key) {

        if (root == null) return false;

        if (key == root.val) return true;

        else if (key < root.val) return searchElement(root.left, key);

        else return searchElement(root.right, key);
    }

    //build from sorted array
    //tc: o(n) fetching mid can be constant but total complexity is o(n) as each element is visited to build the tree
    //T(n) = 2T(n/2) + C, C --> finding mid

    //1, 2, 3, 4, 5, 6, 7, 8, 11, 12
    /*
                     5
                  /     \
                 2        8
               / \       / \
              1   3     6   11
                   \    \    \
                    4    7   12

    */
    public TreeNode buildTreeSortedArray(TreeNode root, int[] a, int s, int e) {

        if (s > e) return null;
        int mid = s + (e-s)/2;

        root = new TreeNode(a[mid], null, null);

        root.left = buildTreeSortedArray(root.left, a, s, mid - 1);
        root.right = buildTreeSortedArray(root.right, a, mid + 1, e);

        return root;
    }

    public TreeNode findNode(TreeNode root, int val) {

        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp.val == val) return temp;
            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
        }
        return null;
    }

    public int sum(TreeNode root) {
        if (root == null) return 0;
        return sum(root.left)+ sum(root.right) + root.val;
    }
    public TreeNode decompressTree(String str){

        if (str == null || str.length() == 0) return null;
        Queue<TreeNode> current = new LinkedList<>();
        String[] nodes = str.split(",");
        int count = 0;
        TreeNode root = new TreeNode(Integer.valueOf(nodes[count++]), null, null);
        current.add(root);
        TreeNode temp = null;
        while (count < nodes.length) {
            if (!current.isEmpty()) temp = current.poll();
            if (!nodes[count].equals("*")) {
                temp.left = new TreeNode(Integer.valueOf(nodes[count++]), null, null);
                current.add(temp.left);
            }
            else count++;
            if (!nodes[count].equals("*")) {
                temp.right = new TreeNode(Integer.valueOf(nodes[count++]), null, null);
                current.add(temp.right);
            }
            else count++;
        }
        return root;
    }

   public TreeNode insert1(TreeNode root, int data) {
        if (root == null) return new TreeNode(data, null, null);
        if (data < root.val) root.left = insert(root.left, data);
        else root.right = insert(root.right, data);
        return root;
    }
    /**
     Tree
            5
          /   \
         4     7
        /     / \
       2     6  11
      / \      /  \
     1  3     8  12

     output = true
     */

    public static ArrayList<Integer> rangeList = new ArrayList<Integer>();
    public void printRange(TreeNode root, int a, int b) {
        if (root == null) return;
        if (root.val >= a && root.val <= b) rangeList.add(root.val);
        printRange(root.left, a, b);
        printRange(root.right, a, b);
        Collections.sort(rangeList);
    }

    public static void main(String a[]) {
        BSTBasicOperations bst = new BSTBasicOperations();
        //TreeNode result = bst.decompressTree("1,2,3,4,*,6,*");
        //System.out.println(result);
        //bst.buildTree(new int[]{15, 10, 20, 25, 8, 12});
        //bst.insert(bst.root, 9);
        //int[] ar = new int[]{8, 10, 12, 15, 17, 19, 20, 25};
        int[] ar = new int[]{1, 3, 5, 7, 8, 9, 11, 12, 13, 14, 15, 17, 18, 20};
        ar = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 11, 12};
        bst.root = bst.buildTreeSortedArray(bst.root, ar, 0, ar.length - 1);
        System.out.println(bst.root);
        //System.out.println(bst.searchElement(bst.root, 25));
        //System.out.println(bst.findNode(bst.root, 20));
        //bst.printRange(bst.root, 4, 11);
       // System.out.println(rangeList);
    }
}
