package DataStructures.arrays;

/**
 Given a two dimensional matrix made up of 0's and 1's,
 find the largest square containing all 1's and return its 'area'.
 The 'area' is simply the sum of all integers enclosed in the square.
 Example:
 Input Matrix :
 1101
 1101
 1111
 Output  : 4
 */
public class LargestSquare2D {

    //solve using DP
    public static int largestSquare(char[][] matrix) {
        return -1;
    }

    public static void main(String a[]) {
        char[][] A = new char[][]{
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 0},
                {0, 0, 1, 1}
        };
        LargestSquare2D.largestSquare(A);
    }
}
