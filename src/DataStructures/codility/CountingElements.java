package DataStructures.codility;


import java.util.*;

public class CountingElements {

    /**
     A non-empty zero-indexed array A consisting of N integers is given.

     A permutation is a sequence containing each element from 1 to N once, and only once.

     For example, array A such that:

     A[0] = 4
     A[1] = 1
     A[2] = 3
     A[3] = 2
     is a permutation, but array A such that:

     A[0] = 4
     A[1] = 1
     A[2] = 3
     is not a permutation, because value 2 is missing.

     The goal is to check whether array A is a permutation.

     Write a function:

     int solution(int A[], int N);
     that, given a zero-indexed array A, returns 1 if array A is a permutation and 0 if it is not.

     For example, given array A such that:

     A[0] = 4
     A[1] = 1
     A[2] = 3
     A[3] = 2
     the function should return 1.

     Given array A such that:

     A[0] = 4
     A[1] = 1
     A[2] = 3
     the function should return 0.

     Assume that:

     N is an integer within the range [1..100,000];
     each element of array A is an integer within the range [1..1,000,000,000].
     Complexity:

     expected worst-case time complexity is O(N);
     expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
     Elements of input arrays can be modified.
     */
    public int permCheck(int[] A) {
        if (A == null || A.length == 0) return 1;
        Set<Integer> set = new HashSet<>();
        for (int val : A) {
            if (set.contains(val)) return 0;
            set.add(val);
        }
        int val = 1;
        while (!set.isEmpty()) {
            if (!set.contains(val++))
                return 0;
            else
                set.remove(val - 1);
        }
        return 1;
    }

    public int permCheck1(int[] A) {
        if (A == null || A.length == 0) return 1;
        int result = 1;
        int aLen = A.length;
        java.util.Arrays.sort(A);
        for (int i = 0; i < aLen; i++) {
            if (A[i] != i + 1)
                return 0;
        }
        return result;
    }

    /**
     A small frog wants to get to the other side of a river. The frog is initially located on one bank of the river (position 0) and wants to get to the opposite bank (position X+1). Leaves fall from a tree onto the surface of the river.

     You are given a zero-indexed array A consisting of N integers representing the falling leaves. A[K] represents the position where one leaf falls at time K, measured in seconds.

     The goal is to find the earliest time when the frog can jump to the other side of the river. The frog can cross only when leaves appear at every position across the river from 1 to X (that is, we want to find the earliest moment when all the positions from 1 to X are covered by leaves). You may assume that the speed of the current in the river is negligibly small, i.e. the leaves do not change their positions once they fall in the river.

     For example, you are given integer X = 5 and array A such that:

     A[0] = 1
     A[1] = 3
     A[2] = 1
     A[3] = 4
     A[4] = 2
     A[5] = 3
     A[6] = 5
     A[7] = 4
     In second 6, a leaf falls into position 5. This is the earliest time when leaves appear in every position across the river.

     Write a function:

     int solution(int X, int A[], int N);
     that, given a non-empty zero-indexed array A consisting of N integers and integer X, returns the earliest time when the frog can jump to the other side of the river.

     If the frog is never able to jump to the other side of the river, the function should return −1.

     For example, given X = 5 and array A such that:

     A[0] = 1
     A[1] = 3
     A[2] = 1
     A[3] = 4
     A[4] = 2
     A[5] = 3
     A[6] = 5
     A[7] = 4
     the function should return 6, as explained above.

     Assume that:

     N and X are integers within the range [1..100,000];
     each element of array A is an integer within the range [1..X].
     Complexity:

     expected worst-case time complexity is O(N);
     expected worst-case space complexity is O(X), beyond input storage (not counting the storage required for input arguments).
     Elements of input arrays can be modified.
     */
    public int frogRiverOne(int X, int[] A) {
        if (A == null || A.length == 0) return -1;
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= X; i++) {
            set.add(i);
        }
        for (int i = 0; i < A.length; i++) {
            if (set.contains(A[i])) {
                set.remove(A[i]);
            }
            if (set.isEmpty()) {
                return i;
            }
        }
        return -1;
    }

    /**
     Write a function:

     int solution(int A[], int N);
     that, given a non-empty zero-indexed array A of N integers, returns the minimal positive integer (greater than 0) that does not occur in A.

     For example, given:

     A[0] = 1
     A[1] = 3
     A[2] = 6
     A[3] = 4
     A[4] = 1
     A[5] = 2
     the function should return 5.

     Assume that:

     N is an integer within the range [1..100,000];
     each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
     Complexity:

     expected worst-case time complexity is O(N);
     expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
     Elements of input arrays can be modified.
     */

    public int missingInteger(int A[]) {
        Set<Integer> set = new HashSet<>();
        int result = 1;
        for (int val : A)
            set.add(val);
        while (set.contains(result++));
        return result - 1;
    }

    /**
     You are given N counters, initially set to 0, and you have two possible operations on them:

     increase(X) − counter X is increased by 1,
     max counter − all counters are set to the maximum value of any counter.
     A non-empty zero-indexed array A of M integers is given. This array represents consecutive operations:

     if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
     if A[K] = N + 1 then operation K is max counter.
     For example, given integer N = 5 and array A such that:

     A[0] = 3
     A[1] = 4
     A[2] = 4
     A[3] = 6
     A[4] = 1
     A[5] = 4
     A[6] = 4
     the values of the counters after each consecutive operation will be:

     (0, 0, 1, 0, 0)
     (0, 0, 1, 1, 0)
     (0, 0, 1, 2, 0)
     (2, 2, 2, 2, 2)
     (3, 2, 2, 2, 2)
     (3, 2, 2, 3, 2)
     (3, 2, 2, 4, 2)
     The goal is to calculate the value of every counter after all operations.

     Assume that the following declarations are given:

     struct Results {
     int * C;
     int L;
     };
     Write a function:

     struct Results solution(int N, int A[], int M);
     that, given an integer N and a non-empty zero-indexed array A consisting of M integers, returns a sequence of integers representing the values of the counters.

     The sequence should be returned as:

     a structure Results (in C), or
     a vector of integers (in C++), or
     a record Results (in Pascal), or
     an array of integers (in any other programming language).
     For example, given:

     A[0] = 3
     A[1] = 4
     A[2] = 4
     A[3] = 6
     A[4] = 1
     A[5] = 4
     A[6] = 4
     the function should return [3, 2, 2, 4, 2], as explained above.

     Assume that:

     N and M are integers within the range [1..100,000];
     each element of array A is an integer within the range [1..N + 1].
     Complexity:

     expected worst-case time complexity is O(N+M);
     expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
     Elements of input arrays can be modified.
    */

    public int maxCounters(int[] A) {
        return 0;
    }


    public static void main(String a[]) {
        CountingElements ce = new CountingElements();
        //System.out.println(ce.permCheck(new int[]{4, 1, 2, 3}));
        //System.out.println(ce.frogRiverOne(5, new int[]{1, 3, 5, 4, 2, 3, 5, 4}));
        System.out.println(ce.missingInteger(new int[]{1, 3, 6, 4, 1, 2}));
    }
}
