package ds.codility;

import java.util.*;
import java.util.Arrays;

public class Sorting {

    /**
     Write a function

     int solution(int A[], int N);
     that, given a zero-indexed array A consisting of N integers, returns the number of distinct values in array A.

     Assume that:

     N is an integer within the range [0..100,000];
     each element of array A is an integer within the range [−1,000,000..1,000,000].
     For example, given array A consisting of six elements such that:

     A[0] = 2    A[1] = 1    A[2] = 1
     A[3] = 2    A[4] = 3    A[5] = 1
     the function should return 3, because there are 3 distinct values appearing in array A, namely 1, 2 and 3.

     Complexity:

     expected worst-case time complexity is O(N*log(N));
     expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
     Elements of input arrays can be modified.
     */

    public int distinct(int[] A) {
        if (A == null || A.length == 0) return 0;
        //if it's Integer[] we can use the below statement
        //return new TreeSet<Integer>(Arrays.asList(A)).size();
        Arrays.sort(A);
        int count = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] == A[i]) continue;
            else count++;
        }
        return count;
    }

    /**
     A non-empty zero-indexed array A consisting of N integers is given. The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).

     For example, array A such that:

     A[0] = -3
     A[1] = 1
     A[2] = 2
     A[3] = -2
     A[4] = 5
     A[5] = 6
     contains the following example triplets:

     (0, 1, 2), product is −3 * 1 * 2 = −6
     (1, 2, 4), product is 1 * 2 * 5 = 10
     (2, 4, 5), product is 2 * 5 * 6 = 60
     Your goal is to find the maximal product of any triplet.

     Write a function:

     int solution(int A[], int N);
     that, given a non-empty zero-indexed array A, returns the value of the maximal product of any triplet.

     For example, given array A such that:

     A[0] = -3
     A[1] = 1
     A[2] = 2
     A[3] = -2
     A[4] = 5
     A[5] = 6
     the function should return 60, as the product of triplet (2, 4, 5) is maximal.

     Assume that:

     N is an integer within the range [3..100,000];
     each element of array A is an integer within the range [−1,000..1,000].
     Complexity:

     expected worst-case time complexity is O(N*log(N));
     expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
     Elements of input arrays can be modified.
     */
    public int maxProductThree(int[] A) {
        if (A == null || A.length < 4) return 0;
        Arrays.sort(A);
        int len = A.length;
        int max = Math.max((A[len - 1] * A[len - 2] * A[len - 3]), (A[0] * A[1] * A[len - 1]));
        return max;
    }

    /**
     A zero-indexed array A consisting of N integers is given. A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:

     A[P] + A[Q] > A[R],
     A[Q] + A[R] > A[P],
     A[R] + A[P] > A[Q].
     For example, consider array A such that:

     A[0] = 10    A[1] = 2    A[2] = 5
     A[3] = 1     A[4] = 8    A[5] = 20
     Triplet (0, 2, 4) is triangular.

     Write a function:

     class Solution { public int solution(int[] A); }

     that, given a zero-indexed array A consisting of N integers, returns 1 if there exists a triangular triplet for this array and returns 0 otherwise.

     For example, given array A such that:

     A[0] = 10    A[1] = 2    A[2] = 5
     A[3] = 1     A[4] = 8    A[5] = 20
     the function should return 1, as explained above. Given array A such that:

     A[0] = 10    A[1] = 50    A[2] = 5
     A[3] = 1
     the function should return 0.

     Assume that:

     N is an integer within the range [0..100,000];
     each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
     Complexity:

     expected worst-case time complexity is O(N*log(N));
     expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
     Elements of input arrays can be modified.
     */
    public int triangle(int[] A) {
        /*if (A == null || A.length < 3) return 0;
        Arrays.sort(A);
        for (int i = 0; i < A.length - 2; i++)
            if (A[i] + A[i + 1] > A[i + 2]) return 1;
        return 0;*/
        if (A == null || A.length < 3) return 0;
        Arrays.sort(A);
        for (int i = 0; i < A.length - 2; i++) {
            long sum = (long)A[i] + A[i + 1];
            if (sum > (long)A[i + 2]) return 1;
        }
        return 0;
    }


    public static void main(String a[]) {
        Sorting s = new Sorting();
        //System.out.println(s.distinct(new int[]{1, 1, 1, 1, 1, 2}));
        //System.out.println(s.maxProductThree(new int[]{-3, 1, 2, -2, 5, 6}));
        System.out.println(s.triangle(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE}));
    }
}
