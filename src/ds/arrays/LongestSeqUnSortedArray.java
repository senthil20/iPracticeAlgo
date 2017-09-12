package ds.arrays;

import java.util.*;
import java.util.Arrays;


public class LongestSeqUnSortedArray {

    //Solution from Sam - byte-by-byte.com
    public int consecutive(int[] a) {

        HashSet<Integer> values = new HashSet();
        for (int i : a) {
            values.add(i);
        }

        int maxLength = 0;
        for (int i : values) {
            // If it is not the leftmost value in the sequence, don't bother
           /* if (values.contains(i - 1)) {
                continue;
            }*/
            int length = 0;

            // Iterate through sequence
            while (values.contains(i++)) {
                length++;
            }
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }


    public int longestSequence(int[] nums) {
            if(nums==null || nums.length==0)
                return 0;

            int[] max = new int[nums.length];
            Arrays.fill(max, 1);

            int result = 1;
            for(int i=0; i<nums.length; i++){
                for(int j=0; j<i; j++){
                    if(nums[i]>nums[j]){
                        max[i]= Math.max(max[i], max[j]+1);

                    }
                }
                result = Math.max(max[i], result);
            }

            return result;

    }

    public static int divide(int a, int b) {
        int c = -1;
        try {
            c = a/b;
        }
        catch(Exception e) {
            System.out.print("Exception");
        }
        finally {
            System.out.print("Finally");
        }
        return c;
    }

    void increment(int[] i) {
        i[i.length-1]++;
    }


    public void add(int a) {
        loop: for (int i = 1; i < 3; i++) {
            for (int j = 1; j < 3; j++) {
                if (a == 5) {
                    break loop;
                }
                System.out.print(i * j);
            }
        }

    }


    public static void main(String ar[]) {


        boolean a = false;
        if (a = true) {
            System.out.print("hello");
        }
        else {
            System.out.print("goodbye");
        }
        //4.new LongestSeqUnSortedArray().add(5);
        /*3.String s1 = "abc";
        String s2 = "def";
        String s3 = s1.concat(s2.toUpperCase());
        System.out.print(s1+s2+s3);*/
        /*2. int[]a = {1};
        new LongestSeqUnSortedArray().increment(a);
        System.out.print(a[a.length - 1]);*/

        //1.LongestSeqUnSortedArray.divide(4, 0);
        //LongestSeqUnSortedArray la = new LongestSeqUnSortedArray();
        //System.out.println(la.longestSequence(new int[]{1,4,5,2,6}));
        //System.out.println(la.consecutive(new int[]{4, 2, 1, 3, 3}));
        //System.out.println(la.consecutive(new int[]{1, 1001, 1002}));
    }
}
