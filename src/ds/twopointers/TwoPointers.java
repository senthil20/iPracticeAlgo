package ds.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by senthil on 8/6/16.
 */

class ListNode {
    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class TwoPointers {
    ListNode head;
    ListNode tail;
    ListNode head2;
    ListNode tail2;

    public static void threeSum(int[] a, int b) {
        if(a == null || a.length < 2) return;
        Arrays.sort(a);
        for(int i=0; i<a.length-2; i++) {
            int s = i+1;
            int e = a.length-1;
            while(s < e) {
                int sum = a[i] + a[s] + a[e];
                if(sum == b) {
                    System.out.println("Indices are " + i + "," + s + "," + e);
                    s++;
                    e--;
                    continue;
                }
                else if(sum > b) {
                    e--;
                }
                else {
                    s++;
                }
            }
        }
    }

    public static int removeDuplicates(int[] a) {
        if(a == null || a.length < 2) return a.length;
        int n = a.length;
        int i=0;
        for(int j=1; j<n; j++) {

            if(a[j] != a[j-1]) {
                a[i] = a[j-1];
                i++;
            }

         }
        return i;
    }

    public static int removeDuplicates(ArrayList<Integer> a) {
        if(a == null || a.size() == 0) return 0;
        int index = 1;
        for(int i=1; i<a.size(); i++) {
            if(!(a.get(i).equals(a.get(i-1)))) {
                a.set(index++, a.get(i));
            }
        }
        return index;
    }

    public static ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {

        if(a == null || b == null) return null;

        int sA = 0;
        int sB = 0;
        int eA = a.size();
        int eB = b.size();
        ArrayList<Integer> list = new ArrayList<>();
        while(sA < eA && sB < eB) {
            if(a.get(sA).equals(a.get(sB))) {
                list.add(a.get(sA));
                sA++;
                sB++;
            }
            else if(a.get(sA) < b.get(sB))
                sA++;
            else
                sB++;
        }
        return list;
    }

    public static ListNode mergeList(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        else if(l1 == null) return l2;
        else if(l2 == null) return l1;
        ListNode resultant = null;
        ListNode p = new ListNode(-1);
        p.next = l1;

        while(p != null && p.next != null && l2 != null) {
            if(p.next.val < l2.val) {
                p = p.next;
            }
            else {
                ListNode temp = new ListNode(l2.val);
                if(resultant == null) resultant = temp;
                ListNode n = p.next;
                p.next = temp;
                temp.next = n;
                p = temp;
                l2 = l2.next;
            }
        }
        p.next = l2;

        return resultant;
    }

    public static ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;

        while(l1!=null||l2!=null){
            if(l1!=null&&l2!=null){
                if(l1.val < l2.val){
                    p.next = l1;
                    l1=l1.next;
                }else{
                    p.next=l2;
                    l2=l2.next;
                }
                p = p.next;
            }else if(l1==null){
                p.next = l2;
                break;
            }else if(l2==null){
                p.next = l1;
                break;
            }
        }
        return head.next;
    }

    public static ListNode MergeLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = MergeLists(list1.next, list2);
            return list1;
        } else {
            list2.next = MergeLists(list2.next, list1);
            return list2;
        }
    }


    public void addNode(ListNode n) {
        if(head == null) {
            head = tail = n;
            return;
        }
        tail.next = n;
        tail = tail.next;
    }

    public void addNode1(ListNode n) {
        if(head2 == null) {
            head2 = tail2 = n;
            return;
        }
        tail2.next = n;
        tail2 = tail2.next;
    }

    public static int[] searchRange(int[] nums, int target) {

        int[] result = new int[]{-1, -1};

        if(nums == null || nums.length == 0) return result;

        int index = Arrays.binarySearch(nums, target);

        if(index < 0) return result;

        int l = index;
        int r = index;

        if(index >= 0) {
            while(l > 0 && nums[l-1] == target)
                l--;
            while(r < nums.length-1 && nums[r+1] == target)
                r++;
        }
        result[0] = l;
        result[1] = r;

        return result;
    }

    public static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        if(a == null || a.size() == 0) {
            a=b;
            return;
        }
        int sA = -1;
        int sB = 0;
        int eA = a.size();
        int eB = b.size();

        while(sA < eA-1 && sB < eB) {
            System.out.println(a.get(sA+1));
            System.out.println(b.get(sB));
            if(a.get(sA+1).compareTo(b.get(sB).intValue()) < 0) {
                sA++;
            }
            else {
                a.add((sA+1), b.get(sB));
                sB++;
            }
        }
        while(sB < eB)
            a.add((sA+1), b.get(sB++));

        System.out.println(a);
    }

    public static void merge(int A[], int m, int B[], int n) {
        int pa = m-1, pb = n-1, pc = m+n-1;
        while(pa>=0 && pb>=0) {
            if(A[pa]>B[pb])
                A[pc--] = A[pa--];
            else
                A[pc--] = B[pb--];
        }
        while(pa>=0) A[pc--] = A[pa--];
        while(pb>=0) A[pc--] = B[pb--];

        System.out.println(A);
    }

    public static int containerWith(int a[]) {

        if(a == null || a.length == 0) return -1;
        int i = 0;
        int j = a.length-1;
        int water = 0;

        while(i < j) {
            water = Math.max(water, Math.min(a[i], a[j]) * (j-i));

            if(a[i] < a[j]) {
                i++;
            }
            else {
                j--;
            }
        }
        return water;
    }


    public static void findZeroes(int arr[], int n, int m)
    {
        int wL = 0, wR = 0;
        int bestL = 0, bestWindow = 0;
        int zeroCount = 0;
        while (wR < n)
        {
            if (zeroCount <= m)
            {
                if (arr[wR] == 0)
                    zeroCount++;
                wR++;
            }
            if (zeroCount > m)
            {
                if (arr[wL] == 0)
                    zeroCount--;
                wL++;
            }
            if (wR-wL > bestWindow)
            {
                bestWindow = wR-wL;
                bestL = wL;
            }
        }
        // Print positions of zeroes in the widest window
        for (int i=0; i<bestWindow; i++)
        {
            if (arr[bestL+i] == 0)
                System.out.println(bestL+i+ " ");
        }
    }


    public static ArrayList<Integer> maxone(ArrayList<Integer> a, int b) {
        ArrayList<Integer> result = new ArrayList<>();
        if (a.size() == 0 || b < 0) {
            return result;
        }
        int start = 0; // start index of current window
        int count = 0; // number of zeros in current window
        int globalStart = -1;
        int globalEnd = -1;
        int len = 0; // global longest
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) == 0) {
                count++;
            }
            if (count > b) {
                // current 0 breaks current window ([start : i] has b + 1 0s)
                // until current window has only b times 0
                // find the new start position s.t. [start:i] has only b 0s
                for (int j = start; j <= i; j++) {
                    if (a.get(j) == 0) {
                        count--;
                        // start from position after current 0
                        start = j + 1;
                        break;
                    }
                }
            } else {
                // update global result
                if (i - start + 1 > len) {
                    len = i - start + 1;
                    globalStart = start;
                    globalEnd = i;
                }
            }
        }
        if (globalStart != -1) {
            for (int i = globalStart; i <= globalEnd; i++) {
                result.add(i);
            }
        }
        return result;
    }


    public static void main(String a[]) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(0);
        list.add(1);
        list.add(1);
        TwoPointers.maxone(list, 1);

        int a3[] = new int[]{1,0,0,1,1,1,1,1,1,1};
        //TwoPointers.findZeroes(a3,a3.length,1);
        int ar[] = new int[]{3,3,5,1,4,4};
        //TwoPointers.containerWith(ar);
        int key = 3;

        ArrayList<Integer> list1= new ArrayList<>();
        list1.add(1);
        list1.add(7);
        list1.add(8);

        ArrayList<Integer> list2= new ArrayList<>();
        list2.add(-4);
        list2.add(14);
        list1.add(15);
        int a1[] = new int[]{1,7,8,0,0,0};
        int a2[] = new int[]{-4,14,15};

        //TwoPointers.merge(a1, 3, a2, a2.length);
        //TwoPointers.merge(list1, list2);
        //TwoPointers.searchRange(ar, key);

        TwoPointers p = new TwoPointers();
        //p.searchRange1(ar, 3);

        p.addNode(new ListNode(2));
        p.addNode(new ListNode(3));
        p.addNode(new ListNode(3));
        p.addNode(new ListNode(6));
        p.addNode(new ListNode(7));

        p.addNode1(new ListNode(1));
        p.addNode1(new ListNode(4));
        p.addNode1(new ListNode(5));
        p.addNode1(new ListNode(7));
        p.addNode1(new ListNode(7));

        //ListNode temp = TwoPointers.MergeLists(p.head, p.head2);
        //ListNode node = TwoPointers.MergeLists(p.head, p.head2);

        //ListNode node = TwoPointers.mergeLists(p.head, p.head2);
        //System.out.println(node);

        //TwoPointers.threeSum(new int[]{1,2,4,5,3,9,6,1}, 7);
        //TwoPointers.removeDuplicates(new int[]{1,2,3,3,3,5,6,7,10,10});
        //TwoPointers.removeDuplicates(new int[]{1,2,3,4,5,6,7,8,9,10});
        /*List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        //1, 3, 8, 10, 13, 13, 16, 16, 16, 18, 21, 23, 24, 31, 31, 31
        list1.add(17);
        //list1.add(18);
        //list1.add(20);
        //5, 7, 14, 14, 25, 28, 28, 34, 35, 38, 38, 39, 46, 53, 65
        list2.add(15);
        list2.add(16);
        list2.add(17);
        list2.add(18);
        list2.add(20);*/

        //list.add(5000);
        //list.add(5000);
        //list.add(5000);
        //TwoPointers.removeDuplicates(list);
        //TwoPointers.intersect(list1,list2);
    }
}
