package ds.arrays;

import java.util.ArrayList;

/**
 Find out the maximum sub-array of non negative numbers from an array.
 The sub-array should be continuous. That is, a sub-array created by choosing the second and fourth element and
 skipping the third element is invalid.

 Maximum sub-array is defined in terms of the sum of the elements in the sub-array.
 Sub-array A is greater than sub-array B if sum(A) > sum(B).

 Example:

 A : [1, 2, 5, -7, 2, 3]
 The two sub-arrays are [1, 2, 5] [2, 3].
 The answer is [1, 2, 5] as its sum is larger than [2, 3]
 NOTE: If there is a tie, then compare with segment's length and return segment which has maximum length
 NOTE 2: If there is still a tie, then return the segment with minimum starting index
 */
public class MaxNonNegativeSubArray {

    public ArrayList<Integer> maxset(ArrayList<Integer> a) {
        if (a == null || a.size() ==0) return new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        long max = 0;
        long sum = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) >= 0) {
                sum += a.get(i);
                curr.add(a.get(i));
            }
            else {
                if (sum > max || (sum == max && curr.size() > result.size())) {
                    max = sum;
                    result = curr;
                }
                sum = 0;
                curr = new ArrayList<>();
            }
        }
        if (sum > max || (sum == max && curr.size() > result.size())) return curr;
        return result;
    }

    public void convertArrayToList(int[] A, ArrayList<Integer> result) {
        for (int val : A) result.add(val);
    }

    public static void main(String a[]) {
        MaxNonNegativeSubArray ms = new MaxNonNegativeSubArray();
        ArrayList<Integer> list = new ArrayList<>();
        //1, 2, 5, -7, 2, 3
        //list.add(1);list.add(2);list.add(5);list.add(-7);list.add(2);list.add(3);list.add(1);list.add(2);
        //list.add(0);list.add(0);list.add(-1);list.add(0);
        ms.convertArrayToList(new int[]{24115, -75629, -46517, 30105, 19451, -82188, 99505, 6752, -36716, 54438, -51501, 83871, 11137, -53177, 22294,
                 -21609, -59745, 53635, -98142, 27968, -260, 41594, 16395, 19113, 71006, -97942, 42082, -30767, 85695, -73671}, list);
        ms.maxset(list);
    }
}
