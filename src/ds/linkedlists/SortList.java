package ds.linkedlists;

import java.util.ArrayList;
import java.util.List;

public class SortList {

    private ListNode root;

    SortList() {
    }
    SortList(int a[]) {
        addNodes(a);
    }

    public void addNodes(int a[]) {
        if (a == null) return;

        ListNode p = new ListNode(-1);
        ListNode tail = p;

        //p.next = new ListNode(100);

        System.out.println(tail);

        for (int val : a) {
            tail.next = new ListNode(val);
            tail = tail.next;
        }
        root = p.next;

        System.out.println(p);
        System.out.println(tail);
        System.out.println(root);
    }

    public int sizeOf(ListNode root) {
        int count = 0;
        while (root != null) {
            root = root.next;
            count++;
        }
        return count;
    }

    public ListNode sortList(ListNode root) {

        int count = sizeOf(root);

        if (root == null || count == 1) return root;

        int mid = count/2;

        ListNode left = new ListNode(-1);
        left.next = root;

        ListNode right = null;

        while (mid > 1) {
            root = root.next;
            mid--;
        }
        right = root.next;
        root.next = null;
        left = left.next;

        left = sortList(left);
        right = sortList(right);

        root = sort(left, right);

        return root;
    }

    public ListNode sort(ListNode l1, ListNode l2) {

        ListNode p = new ListNode(-1);
        ListNode tail = p;

        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            }
            else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        while (l1 != null) {
            tail.next = l1;
            break;
        }

        while (l2 != null) {
            tail.next = l2;
            break;
        }

        return p.next;
    }


    public static void main(String a[]) {

        int ar[] = new int[]{5, 3, 1, 4, 6, 9};
        //SortList sl = new SortList(ar);
        //ListNode result = sl.sortList(sl.root);
        //System.out.println(result);

        //see this example too
        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList<String> list2 = list1;

        list1 = null;
        System.out.println(list2);

        list1.add("IB");
        list1.add("LC");
        list2.add("GFG");

        System.out.println(list1);
        System.out.println(list2);
    }
}
