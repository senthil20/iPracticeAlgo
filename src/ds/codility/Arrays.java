package ds.codility;

public class Arrays {
//Problem 1
    /**
     A non-empty zero-indexed array A consisting of N integers is given. The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value, except for one element that is left unpaired.

     For example, in array A such that:

     A[0] = 9  A[1] = 3  A[2] = 9
     A[3] = 3  A[4] = 9  A[5] = 7
     A[6] = 9
     the elements at indexes 0 and 2 have value 9,
     the elements at indexes 1 and 3 have value 3,
     the elements at indexes 4 and 6 have value 9,
     the element at index 5 has value 7 and is unpaired.
     Write a function:

     int solution(int A[], int N);
     that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.

     For example, given array A such that:

     A[0] = 9  A[1] = 3  A[2] = 9
     A[3] = 3  A[4] = 9  A[5] = 7
     A[6] = 9
     the function should return 7, as explained in the example above.

     Assume that:

     N is an odd integer within the range [1..1,000,000];
     each element of array A is an integer within the range [1..1,000,000,000];
     all but one of the values in A occur an even number of times.
     Complexity:

     expected worst-case time complexity is O(N);
     expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
     Elements of input arrays can be modified.
     */
    public int oddOccurencesInArray(int[] A) {
        if (A == null || A.length == 0) return 0;
        java.util.Arrays.sort(A);
        for (int i = 1; i < A.length; i = i + 2) {
            if (i - 1 == 0 && A[i - 1] != A[i]) {
                return A[i - 1];
            }
            if (A[i - 1] != A[i])
                return A[i - 1];
        }
        return A[A.length - 1];
    }

//Problem 2
    /**
     * A zero-indexed array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index,
     and the last element of the array is also moved to the first place.

     For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7]. The goal is to rotate array A K times; that is,
     each element of A will be shifted to the right by K indexes.

     Write a function:

     struct Results solution(int A[], int N, int K);
     that, given a zero-indexed array A consisting of N integers and an integer K, returns the array A rotated K times.

     For example, given array A = [3, 8, 9, 7, 6] and K = 3, the function should return [9, 7, 6, 3, 8].

     Assume that:

     N and K are integers within the range [0..100];
     each element of array A is an integer within the range [−1,000..1,000].
     In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
     */
    public int[] cyclicRotation(int[] A, int K) {
        int i = 0;
        if (A == null || A.length == 0 || K < 1) return A;
        if (K > A.length) K = K % A.length;
        swap(A, 0, A.length - K - 1);
        swap(A, A.length - K, A.length - 1);
        swap(A, 0, A.length - 1);
        return A;
    }

    public void swap(int[] A, int start, int end) {
        while (start <= end) {
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;
            start++;
            end--;
        }
    }

    public int solutionMin(int[] A) {
        if (A == null || A.length == 0) return 0;
        int sum = 0;
        int initialValue = A[0];
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        for (int i = 1; i < A.length; i++) {
            minValue = Math.min(minValue, Math.abs(initialValue - (sum - initialValue)));
            initialValue += A[i];
        }
        return minValue;
    }

    public int solution1(int[] A) {
        int missingNumber = 0;
        for (int i = 0; i < A.length; i++)
            missingNumber ^= A[i];
        return missingNumber;
    }



    public static void main(String a[]) {
        Arrays gap = new Arrays();
        System.out.println(gap.oddOccurencesInArray(new int[]{9, 3, 9, 3, 9, 7, 9}));
        System.out.println(gap.cyclicRotation(new int[]{3, 8, 9, 7, 6}, 7));
        System.out.println(gap.solutionMin(new int[]{3, 1, 2, 4, 3}));
    }
}
