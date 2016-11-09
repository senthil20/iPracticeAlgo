package ds.hashing;

import java.util.*;

public class MaxLengthZeroSumSubArray {

    public int subArraySumsZeroBruteForce(int a[]) {

        if (a == null || a.length == 0) return -1;
        int max = 0;
        int n = a.length;

        for (int i = 0; i < n; i++) {
            int currSum = 0;
            for (int j = i; j < n; j++) {
                currSum += a[j];
                if (currSum == 0) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    public Map<Integer, Integer> subArraySumsZero(int a[]) {

        int currSum = 0;
        Map<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
        int max = 0;
        for (int i = 0 ; i < a.length ; i ++)
        {
            currSum += a[i];
            if(currSum == 0) {
                max = Math.max(max, i);
                System.out.println("subset : { 0 - " + i + " }");
            }
            else if(sumMap.get(currSum) != null) {

                max = Math.max(max, (i - (sumMap.get(currSum) + 1)));
                System.out.println("subset : { "
                        + (sumMap.get(currSum) + 1)
                        + " - " + i + " }");
                sumMap.put(currSum, i);
            }
            else
                sumMap.put(currSum, i);
        }
        System.out.println(max);
        return sumMap;
    }


    public ArrayList<Integer> lszero(int[] A) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        if(A == null) return rst;
        int len = 0;
        int sum = 0;
        int l = -1, r = -1;
        map.put(0, -1);
        for(int i = 0; i < A.length; i++){
            sum += A[i];
            if(!map.containsKey(sum))
                map.put(sum, i);
            else{
                if(i - map.get(sum) > len){
                    l = map.get(sum) + 1;
                    r = i;
                    len = i - map.get(sum);
                }
            }
        }
        if(l >=0 && r >= 0){
            for(int i = l; i <= r; i++){
                rst.add(A[i]);
            }
        }
        return rst;
    }

    public static void main(String a[]) {
        MaxLengthZeroSumSubArray max = new MaxLengthZeroSumSubArray();
        //int [] ar = new int[] {1,2,3,4,-9,6,7,-8,1,9};
        //int [] ar = new int[] {15, 10, 2, -8, -1, -5, 12, 23};
        //int [] ar = new int[] {15, -2, 2, -8, 1, 7, 10, 23};
        //int[] ar = new int[]{1, 2, 3};
        //Map<Integer, Integer> result = max.subArraySumsZero(ar);
        //System.out.println(max.subArraySumsZeroBruteForce(ar));
        //int [] ar = new int[] {-1, 1, 1, -1, -1, 1, 1, -1};
        int [] ar = new int[] {1 ,2 ,-2 ,4 ,-4};
        //int [] ar = new int[] {1, 2, -3, 3};
        //int [] ar = new int[] {-19, 8, 2, -8, 19, 5, -2, -23};
        //max.lszero(ar);
    }
}
