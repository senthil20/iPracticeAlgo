package DataStructures.codility;


public class PrefixSums {

    /**
     Write a function:

     int solution(int A, int B, int K);
     that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:

     { i : A ≤ i ≤ B, i mod K = 0 }
     For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.

     Assume that:

     A and B are integers within the range [0..2,000,000,000];
     K is an integer within the range [1..2,000,000,000];
     A ≤ B.
     Complexity:

     expected worst-case time complexity is O(1);
     expected worst-case space complexity is O(1).
     */
    public int countDiv(int A, int B, int K) {
        int diff = B / K - A / K;
        if (A % K == 0) diff++;
        return diff;
    }

    /**
     A non-empty zero-indexed array A consisting of N integers is given. The consecutive elements of array A represent consecutive cars on a road.

     Array A contains only 0s and/or 1s:

     0 represents a car traveling east,
     1 represents a car traveling west.
     The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N, is passing when P is traveling to the east and Q is traveling to the west.

     For example, consider array A such that:

     A[0] = 0
     A[1] = 1
     A[2] = 0
     A[3] = 1
     A[4] = 1
     We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).

     Write a function:

     int solution(int A[], int N);
     that, given a non-empty zero-indexed array A of N integers, returns the number of pairs of passing cars.

     The function should return −1 if the number of pairs of passing cars exceeds 1,000,000,000.

     For example, given:

     A[0] = 0
     A[1] = 1
     A[2] = 0
     A[3] = 1
     A[4] = 1
     the function should return 5, as explained above.

     Assume that:

     N is an integer within the range [1..100,000];
     each element of array A is an integer that can have one of the following values: 0, 1.
     Complexity:

     expected worst-case time complexity is O(N);
     expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
     Elements of input arrays can be modified.
     */
    public int passingCars(int[] A) {
        if (A == null || A.length == 0) return 0;
        int ones = 0;
        int count = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] == 1) ones++;
            else count += ones;
            if (count > 1000000000) return -1;
        }
        return count;
    }


    public static void main(String a[]) {
        PrefixSums ps = new PrefixSums();
        ps.passingCars(new int[]{0, 1, 0, 1, 1});
    }
}
