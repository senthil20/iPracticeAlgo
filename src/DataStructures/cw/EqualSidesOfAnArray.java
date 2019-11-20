package DataStructures.cw;

/**
 * Created by sydgsk9 on 2/21/2017.
 */
public class EqualSidesOfAnArray {

    /**
     Let's say you are given the array {1,2,3,4,3,2,1}:
     Your function will return the index 3, because at the 3rd position of the array,
     the sum of left side of the index ({1,2,3}) and the sum of the right side of the index ({3,2,1}) both equal 6.

     Let's look at another one.
     You are given the array {1,100,50,-51,1,1}:
     Your function will return the index 1, because at the 1st position of the array, the sum of left side of the index ({1})
     and the sum of the right side of the index ({50,-51,1,1}) both equal 1.

     The lowest index N where the side to the left of N is equal to the side to the right of N.
     If you do not find an index that fits these rules, then you will return -1.
     */
    public int findEvenIndex(int[] A) {
        if (A == null || A.length == 0) return -1;
        int total = findSum(A);
        int leftSum = 0;
        int rightSum = total - A[0];
        for (int i = 1; i < A.length; i++) {
            leftSum += A[i - 1];
            rightSum -= A[i];
            if (leftSum == rightSum) return i;
        }
        return -1;
    }

    public int findSum(int[] A) {
        int total = 0;
        for (int val : A) total += val;
        return total;
    }

}
