package DataStructures.codility;

import java.util.HashSet;
import java.util.Set;

public class TimeComplexity {
//Problem 1
    /**
     A small frog wants to get to the other side of the road. The frog is currently located at position X and
     wants to get to a position greater than or equal to Y. The small frog always jumps a fixed distance, D.

     Count the minimal number of jumps that the small frog must perform to reach its target.

     Write a function:

     int solution(int X, int Y, int D);
     that, given three integers X, Y and D, returns the minimal number of jumps from position X to a position equal to or greater than Y.

     For example, given:

     X = 10
     Y = 85
     D = 30
     the function should return 3, because the frog will be positioned as follows:

     after the first jump, at position 10 + 30 = 40
     after the second jump, at position 10 + 30 + 30 = 70
     after the third jump, at position 10 + 30 + 30 + 30 = 100
     Assume that:

     X, Y and D are integers within the range [1..1,000,000,000];
     X ≤ Y.
     Complexity:

     expected worst-case time complexity is O(1);
     expected worst-case space complexity is O(1).
     */
    public int frogJump(int X, int Y, int D) {
        if (X == Y || D < 1) return 0;
        return (int)Math.ceil((double) (Y - X) / D);
    }

//Problem 2
    /**
     A zero-indexed array A consisting of N different integers is given.
     The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.

     Your goal is to find that missing element.

     Write a function:

     int solution(int A[], int N);
     that, given a zero-indexed array A, returns the value of the missing element.

     For example, given array A such that:

     A[0] = 2
     A[1] = 3
     A[2] = 1
     A[3] = 5
     the function should return 4, as it is the missing element.

     Assume that:

     N is an integer within the range [0..100,000];
     the elements of A are all distinct;
     each element of array A is an integer within the range [1..(N + 1)].
     Complexity:

     expected worst-case time complexity is O(N);
     expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
     Elements of input arrays can be modified.
     */
    public int missingElem(int[] A) {
        Set<Integer> set = new HashSet<>();
        int val = 1;
        for (int value : A) {
            set.add(value);
        }
        while (!set.isEmpty()) {
            if (set.contains(val++)) continue;
            return val - 1;
        }
        return 0;
    }

    //Best solution would be to XOR all array elements. Then XOR numbers from 1 to N+1.
    //Then doing a XOR of both the results will give the missing number.
    public int missingElemXOR(int[] A) {
        int xor1 = A[0];
        int xor2 = 1;
        for (int i = 1; i < A.length; i++) {
            xor1 ^= A[i];
        }
        for (int i = 2; i <= A.length + 1; i++) {
            xor2 ^= i;
        }
        return xor1 ^ xor2;
    }


//Problem 3
    /**
     A non-empty zero-indexed array A consisting of N integers is given. Array A represents numbers on a tape.

     Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].

     The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|

     In other words, it is the absolute difference between the sum of the first part and the sum of the second part.

     For example, consider array A such that:

     A[0] = 3
     A[1] = 1
     A[2] = 2
     A[3] = 4
     A[4] = 3
     We can split this tape in four places:

     P = 1, difference = |3 − 10| = 7
     P = 2, difference = |4 − 9| = 5
     P = 3, difference = |6 − 7| = 1
     P = 4, difference = |10 − 3| = 7
     Write a function:

     int solution(int A[], int N);
     that, given a non-empty zero-indexed array A of N integers, returns the minimal difference that can be achieved.

     For example, given:

     A[0] = 3
     A[1] = 1
     A[2] = 2
     A[3] = 4
     A[4] = 3
     the function should return 1, as explained above.

     Assume that:

     N is an integer within the range [2..100,000];
     each element of array A is an integer within the range [−1,000..1,000].
     Complexity:

     expected worst-case time complexity is O(N);
     expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
     Elements of input arrays can be modified.
     */
    public int equalParts(int[] A) {
        if (A == null || A.length == 0) return 0;
        int total = sum(A);
        int left = A[0];
        int right = total - left;
        int min = Math.abs(right - left);
        for (int i = 1; i < A.length - 1; i++) {
            left += A[i];
            right -= A[i];
            min = Math.min(min, Math.abs(right - left));
        }
        return min;
    }

    public int sum(int[] A) {
        int sum = 0;
        for (int val : A) sum += val;
        return sum;
    }

    public static void main(String a[]) {
        TimeComplexity tc = new TimeComplexity();
        //System.out.println(tc.frogJump(10, 50, 30));
        //System.out.println(tc.missingElem(new int[]{2, 3, 1, 5}));
        //System.out.println(tc.missingElemXOR(new int[]{2, 3, 1, 5}));
        tc.equalParts(new int[]{3, 1, 2, 4, 3});
    }
}