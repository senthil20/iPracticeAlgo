package DataStructures.arrays;

import java.util.Arrays;

/**
 * Given an array of n integers where each value represents number of chocolates in a packet.
 * Each packet can have variable number of chocolates.
 * There are m students, the task is to distribute chocolate packets such that:
 *
 * Each student gets one packet.
 * The difference between the number of chocolates in packet with maximum chocolates and packet with
 * minimum chocolates given to the students is minimum.
 * Examples:
 *
 * Input : arr[] = {7, 3, 2, 4, 9, 12, 56}
 *         m = 3
 * Output: Minimum Difference is 2
 * We have seven packets of chocolates and
 * we need to pick three packets for 3 students
 * If we pick 2, 3 and 4, we get the minimum
 * difference between maximum and minimum packet
 * sizes.
 *
 * Input : arr[] = {3, 4, 1, 9, 56, 7, 9, 12}
 *         m = 5
 * Output: Minimum Difference is 6
 * The set goes like 3,4,7,9,9 and the output
 * is 9-3 = 6
 *
 * Input : arr[] = {12, 4, 7, 9, 2, 23, 25, 41,
 *                  30, 40, 28, 42, 30, 44, 48,
 *                  43, 50}
 *         m = 7
 * Output:  Minimum Difference is 10
 * We need to pick 7 packets. We pick 40, 41,
 * 42, 44, 48, 43 and 50 to minimize difference
 * between maximum and minimum.
 */

public class MinCandyDistribution {

    public static int findMinDiffCandyDistribution(int[] A, int m) { // where A[i] = box of chocolates, m - no. of students

        if (A == null || A.length == 0 || m < 1 || A.length < m) return 0;
        Arrays.sort(A);
        int start = 0;
        int end = A.length - 1;
        int sRange = 0;
        int eRange = 0;
        int minDiff = Integer.MAX_VALUE;

        while (start <= end && start + m - 1 <= end) {
            int startVal = A[start];
            int endVal = A[start + m - 1];

            if (endVal - startVal < minDiff) {
                sRange = start;
                eRange = start + m - 1;
                minDiff = endVal - startVal;
            }
            start++;
        }
        return A[eRange] - A[sRange];
    }

    public static void main(String a[]) {
        //int[] A = new int[]{7, 3, 2, 4, 9, 12, 56};
        //int[] A = new int[]{3, 4, 1, 9, 56, 7, 9, 12};
        int[] A = new int[]{12, 4, 7, 9, 2, 23,
                25, 41, 30, 40, 28,
                42, 30, 44, 48, 43,
                50};
        int result = findMinDiffCandyDistribution(A, 7);
        System.out.println(result);
    }
}
