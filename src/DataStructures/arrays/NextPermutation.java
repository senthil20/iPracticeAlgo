package DataStructures.arrays;

import java.util.ArrayList;

/**
 * Created by senthil on 22/8/16.
 */
public class NextPermutation {

    public void swap(int a[], int s , int d) {
        int temp = a[s];
        a[s] = a[d];
        a[d] = temp;
    }

    public void nextPermutation(int[] nums) {

        if(nums == null || nums.length < 2) return;

        int n = nums.length;

        int p = n-1;

        while(p > 0 && nums[p-1] >= nums[p]) {
            p--;
        }

        p = p - 1;

        if(p < 0) {
            reverse(nums, 0, n-1);
            return;
        }

        int q = n-1;

        while(q > p && nums[q] <= nums[p]) {
            q--;
        }

        swap(nums, p, q);

        reverse(nums, p+1, n-1);
    }

    public void reverse(int a[], int s, int e) {

        while(s < e) {
            swap(a, s, e);
            s++;
            e--;
        }
    }

    public void printElements(int a[]) {
        for(int a1: a)
            System.out.print(a1+" ");
        System.out.println();
    }

    private void perm(int[] a, int n) {
        if (n == 1) {
            printElements(a);
            return;
        }
        for (int i = 0; i < n; i++) {
            swap(a, i, n-1);
            perm(a, n-1);
            swap(a, i, n-1);
        }
    }

    public ArrayList<Integer> findPerm(final String A, int B) {

        ArrayList<Integer> list = new ArrayList<>();

        int a[] = new int[B];
        char[] C = A.toCharArray();

        int count = 1;

        for(int i = 0; i < B; i++) {
            a[i] = count++;
        }

        perm(a, C, a.length, list);
        return list;
    }

    public void perm(int a[], char[] C, int n, ArrayList<Integer> list) {

        if(n == 1) {
            int s = 0;
            int e = C.length;

            while(s < e) {
                if(C[s] == 'D' && a[s+1] > a[s]) {
                    return;
                }
                else if(C[s] == 'I' && a[s+1] < a[s]) {
                    return;
                }
                s++;
            }

            for(int val: a) {
                list.add(val);
            }

        }

        for(int i = 0; i < n; i++) {
            swap(a, i, n-1);
            perm(a, C, n-1, list);
            if(list.size() > 0) {
                break;
            }
            swap(a, i, n-1);
        }
    }

    /*public void perm1(String s) {
        perm1("", s);
    }

    private void perm1(String prefix, String s) {
        int n = s.length();
        if (n == 0) {
            System.out.println(prefix);
        }
        else {
            for (int i = 0; i < n; i++)
                perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, n));
        }
    }*/

    public boolean jump(int[] a) {

        if(a == null || a.length == 0) return false;
        if(a.length <=1) return true;

        int s = 0;
        int e = a.length;

        int sum = a[0];

        while(s < e) {

            if(sum <= s && a[s] == 0) {
                return false;
            }

            if(s + a[s] > sum) {
                sum = s + a[s];
            }

            if(sum >= e-1) {
                return true;
            }

            s++;
        }
        return false;
    }


    public static void main(String a[]) {
        NextPermutation np = new NextPermutation();
        int[] ar = new int[]{1,5,1};
        //np.nextPermutation(ar);
        //np.perm(new int[]{1, 2, 3}, 3);
        //System.out.println(np.jump(new int[]{3,2,2,0,0,4}));
        for(int val: np.findPerm("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD" , 354)) {
            System.out.print(val + " ");
        }
    }
}
