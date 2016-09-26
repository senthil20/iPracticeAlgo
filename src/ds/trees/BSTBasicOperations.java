package ds.trees;

import ds.binarysearch.BinarySearch;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() { }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
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
    public TreeNode buildTreeSortedArray(TreeNode root, int[] a, int s, int e) {

        if (s > e) return null;
        int mid = s + (e-s)/2;

        root = new TreeNode(a[mid], null, null);

        root.left = buildTreeSortedArray(root.left, a, s, mid - 1);
        root.right = buildTreeSortedArray(root.right, a, mid + 1, e);

        return root;
    }

    public static void main(String a[]) {
        BSTBasicOperations bst = new BSTBasicOperations();
        //bst.buildTree(new int[]{15, 10, 20, 25, 8, 12});
        //bst.insert(bst.root, 9);
        //int[] ar = new int[]{8, 10, 12, 15, 17, 19, 20, 25};
        int[] ar = new int[]{1, 3, 5, 7, 8, 9, 11, 12, 13, 14, 15, 17, 18, 20};
        bst.root = bst.buildTreeSortedArray(bst.root, ar, 0, ar.length - 1);
        //System.out.println(bst.searchElement(bst.root, 25));
    }
}
