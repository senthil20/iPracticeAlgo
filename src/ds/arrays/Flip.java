package ds.arrays;

import java.util.ArrayList;
import java.util.List;

public class Flip {

    /**
     You are given a binary string(i.e. with characters 0 and 1) S consisting of characters S1, S2, …, SN.
     In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and flip the characters SL, SL+1, …, SR.
     By flipping, we mean change character 0 to 1 and vice-versa.

     Your aim is to perform ATMOST one operation such that in final string number of 1s is maximised.
     If you don’t want to perform the operation, return an empty array. Else, return an array consisting of two elements
     denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.

     Notes:
     - Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.

     For example,
     S = 010

     Pair of [L, R] | Final string
     _______________|_____________
     [1 1]          | 110
     [1 2]          | 100
     [1 3]          | 101
     [2 2]          | 000
     [2 3]          | 001

     We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1].
     Another example,

     If S = 111

     No operation can give us more than three 1s in final string. So, we return empty array [].
     See Expected Output
     Notes
     */
    public ArrayList<Integer> flip(String A) {
        if (A == null || A.length() == 0) return new ArrayList<>();
        int max = 0;
        int zeroCount = 0;
        int startIndex = 0;
        int endIndex = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if (c == '0') {
                zeroCount++;
                if (max < zeroCount) {
                    max = zeroCount;
                    endIndex = i + 1;
                    result.clear();
                    result.add(startIndex + 1);
                    result.add(endIndex);
                }
            }
            else {
                if (zeroCount == 0)
                    startIndex = i + 1;
                else zeroCount--;
            }
        }
        return result;
    }

    /**
     *
     Find zeroes to be flipped so that number of consecutive 1’s is maximized
     Given a binary array and an integer m, find the position of zeroes flipping which creates
     maximum number of consecutive 1s in array.

     Examples:

     Input:   arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}
     m = 2
     Output:  5 7
     We are allowed to flip maximum 2 zeroes. If we flip
     arr[5] and arr[7], we get 8 consecutive 1's which is
     maximum possible under given constraints

     Input:   arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}
     m = 1
     Output:  7
     We are allowed to flip maximum 1 zero. If we flip
     arr[7], we get 5 consecutive 1's which is maximum
     possible under given constraints.

     Input:   arr[] = {0, 0, 0, 1}
     m = 4
     Output:  0 1 2
     Since m is more than number of zeroes, we can flip
     all zeroes.
     */

    public List<Integer> flipMaximumOnes(int[] A, int m) {
        if (A == null || A.length == 0 || m == 0) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int zeroCount = 0;
        int max = 0;
        int startIndex = 0;
        int endIndex = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                if (m != zeroCount) {
                    zeroCount++;
                    if (startIndex == 0) startIndex = i;
                    endIndex = i;
                    continue;
                }
                else {
                    if (max < (endIndex - startIndex)) {
                        max = endIndex - startIndex;
                        zeroCount = 1;
                        result.clear();
                        result.add(startIndex);
                        result.add(endIndex);
                        startIndex = i;
                    }
                }
            }
        }
        if (A.length - 1 - startIndex > max) {
            result.clear();
            result.add(startIndex);
            result.add(endIndex - 1);
        }
        return result;
    }

    public static void main(String a[]) {
        Flip flip = new Flip();
        //flip.flip("0100011");
        //flip.flip("1011001");
        //flip.flip("010");
        //flip.flip("1110100001");
        //flip.flip("0101");
        flip.flipMaximumOnes(new int[]{1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}, 3);
    }
}
