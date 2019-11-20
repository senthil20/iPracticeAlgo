package DataStructures.twopointers;

import java.util.ArrayList;
import java.util.List;

class Node implements Comparable<Node>{
    int val;
    int index;

    Node(int index, int val) {
        this.val = val;
        this.index = index;
    }

    @Override
    public int compareTo(Node o) {
        return 0;
    }
}

public class TwoPointers1 {

    public static void moveZeroes(int[] nums) {

        if (nums == null || nums.length == 0) return;
        int zeroCount = 0;
        int index = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            } else {
                zeroCount++;
            }
        }
        if (zeroCount == n) return;
        while (zeroCount != 0) {
            nums[--n] = 0;
            zeroCount--;
        }
        System.out.println(nums);
    }

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int count = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
                count++;
            }
        }
        return count;
    }

    public static int removeDuplicates(int nums[]) {
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    public static int removeDuplicates(ArrayList<Integer> a) {

        if (a == null || a.size() == 0) return 0;
        int index = 1;
        for (int i = 1; i < a.size(); i++) {
            if (!(a.get(i).equals(a.get(i - 1)))) {
                a.set(index++, a.get(i));
            }
        }
        System.out.println(a);
        return index;
    }

    //1,1,1,2,2,3
    //1,2,4,4,5,6
    public static int removeDuplicatesII(int[] a) {
        int n = a.length;
        if (n < 3) return n;
        int end = 1;
        for (int i = 2; i < n; i++) {
            if (a[i] != a[end - 1])
                a[++end] = a[i];
        }
        return end + 1;
    }

    public static int removeDuplicatesIII(int[] a) {
        int n = a.length;
        if (n < 4) return n;
        int end = 2;
        for (int i = 3; i < n; i++) {
            if (a[i] != a[end - 1])
                a[++end] = a[i];
        }
        return end + 1;
    }

    public static int removeDuplicatesII(ArrayList<Integer> a) {

        if (a == null || a.size() == 0) return 0;
        int index = 1;
        int dCount = 0;
        for (int i = 1; i < a.size(); i++) {
            if (!(a.get(i).equals(a.get(i - 1)))) {
                a.set(index++, a.get(i));
                dCount = 0;
            } else if (dCount != 1) {
                a.set(index++, a.get(i));
                dCount++;
            }
        }
        System.out.println(a);
        return index;
    }

    //1,1,1,2,2,3
    //1,2,4,4,5,6
    public static void moveZeros(ArrayList<Integer> a) {

        if (a == null || a.size() == 0) return;
        int zeroCount = 0;
        int index = 0;
        int n = a.size();
        for (int i = 0; i < n; i++) {
            if (!(a.get(i).equals(0))) {
                a.set(index++, a.get(i));
            } else {
                zeroCount++;
            }
        }
        if (zeroCount == n) return;
        while (zeroCount != 0) {
            a.set(--n, 0);
            zeroCount--;
        }
        System.out.println(a);
    }

    public static void sortColors1(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }

        int redIndex = 0;
        int blueIndex = A.length - 1;
        int i = 0;

        while (i <= blueIndex) {
            if (A[i] == 0) {
                swap(A, redIndex, i);
                i++;
                redIndex++;
            } else if (A[i] == 1) {
                i++;
            } else {
                swap(A, blueIndex, i);
                blueIndex--;
            }
        }
        System.out.println(A);
    }

    public static void sortColors2(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }

        int[] count = new int[3];
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                count[0]++;
            } else if (A[i] == 1) {
                count[1]++;
            } else {
                count[2]++;
            }
        }

        int i = 0;
        for (int k = 0; k < count.length; k++) {
            while (count[k] > 0) {
                A[i] = k;
                i++;
                count[k]--;
            }
        }
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void swap1(int[] A, int val1, int val2) {
        int temp = A[val1];
        A[val1] = A[val2];
        A[val2] = temp;
    }

    public static void sortColors3(int[] nums) {

        if (nums == null || nums.length == 0) return;
        int red = 0;
        int green = nums.length - 1;
        int i = 0;
        while (i <= green) {
            if (nums[i] == 0) {
                swap1(nums, i, red);
                red++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap1(nums, i, green);
                green--;
            }
        }
    }

    public List<Integer> slidingWindowMax(int a[]) {

        if (a == null || a.length < 3) return null;
        List<Integer> list = new ArrayList<Integer>();
        return list;

    }

    public static ArrayList<Integer> maxone(ArrayList<Integer> a, int b) {

        if (a == null || a.size() == 0) return null;
        ArrayList<Integer> list = new ArrayList<Integer>();
        int wL = 0;
        int wR = 0;
        int n = a.size();
        int zC = 0;
        int max = 0;
        int start = 0;

        while (wR < n) {
            if (zC <= b) {
                if (a.get(wR) == 0)
                    zC++;
                wR++;
            }

            if (zC > b) {
                if (a.get(wL) == 0)
                    zC--;
                wL++;
            }

            if (wR - wL > max) {
                max = wR - wL;
                start = wL;
            }
        }
        for (int i = 0; i < max; i++)
            list.add(start + i);
        return list;
    }


    public static List<Integer> maxSubArray(int[] a) {
        if (a == null || a.length == 0) return null;
        List<Integer> list = new ArrayList<Integer>();
        int sum = 0;
        int max = 0;
        int sIndex = 0;
        int eIndex = 0;

        for (int i = 0; i < a.length; i++) {
            if (sum > 0) {
                sum = sum + a[i];
            } else {
                sum = a[i];
                sIndex = i;
            }
            if (sum > max) {
                max = sum;
                eIndex = i;
            }
        }
        list.add(sIndex);
        list.add(eIndex);
        list.add(max);
        return list;
    }


    public static void main(String[] args) {
        //[−2,1,−3,4,−1,2,1,−5,4]
        TwoPointers1.maxSubArray(new int[]{-2, 10, -3, 4, -1, 2, 1, -14, 0, 0});
        //A : [ 0, 1, 1, 1 ]
        //B : 0
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(0);
        list1.add(1);
        list1.add(1);
        list1.add(1);
        TwoPointers1.maxone(list1, 1);
        //TwoPointers1.sortColors3(new int[]{2});
        TwoPointers1 t = new TwoPointers1();
        int nums[] = {1, 1, 1, 1, 1, 2, 3, 3, 3, 3};
        //System.out.println(TwoPointers1.removeElement(nums, 3));
        //nums = new int[]{0,0,1,0,0,0,0};
        //TwoPointers1.moveZeroes(nums);
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(5);
        //System.out.println(TwoPointers1.removeDuplicates(list));
        //TwoPointers1.moveZeros(list);
        //TwoPointers1.removeDuplicatesII(nums);
        //TwoPointers1.removeDuplicatesIII(nums);
    }
}
