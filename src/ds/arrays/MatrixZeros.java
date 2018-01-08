package ds.arrays;

/**
 * Given a m * n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * 1  1   1   0
 * 1  1   1   0
 * 1  1   0   0
 * 1  0   0   0
 */
public class MatrixZeros {

    public static void setZeroes(int[][] A) {
        if (A == null) return;
        int rowLen = A.length;
        int colLen = A[0].length;

        //set flag for zeroth row/col
        boolean firstRowZero = false;
        boolean firstColZero = false;

        for (int i = 0; i < colLen; i++) {
            if (A[0][i] == 0)
                firstRowZero = true;
        }

        for (int i = 0; i < rowLen; i++) {
            if (A[i][0] == 0)
                firstColZero = true;
        }

        //traverse all row/col
        for (int i = 1; i < rowLen; i++) {
            for (int j = 1; j < colLen; j++) {
                if (A[i][j] == 0) {
                    A[i][0] = 0;
                    A[0][j] = 0;
                }
            }
        }
        //mark resp row/col to zero
        for (int i = 1; i < rowLen; i++) {
            for (int j = 1; j < colLen; j++) {
                if (A[i][0] == 0 || A[0][j] == 0) {
                    A[i][j] = 0;
                }
            }
        }
        //finally make first row/col to zero
        for (int i = 0; i < colLen; i++) {
            if (firstColZero)
                A[0][i] = 0;
        }
        for (int i = 0; i < rowLen; i++) {
            if (firstRowZero)
                A[i][0] = 0;
        }
    }

    public static void main(String args[]) {
        int[][] A = new int[][]{
                {1, 1, 1, 0},
                {1, 1, 1, 0},
                {1, 1, 0, 0},
                {1, 0, 0, 0}
        };
        MatrixZeros.setZeroes(A);
        System.out.println(A);
    }
}
