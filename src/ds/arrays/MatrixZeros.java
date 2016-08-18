package ds.arrays;

import ds.binarysearch.BinarySearch;

/**
 * Created by senthil on 13/8/16.
 */
public class MatrixZeros {

    public static void setZeroes(int[][] matrix) {

        if(matrix == null) return;

        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        //set flag for zeroth row/col
        boolean firstRowZero = false;
        boolean firstColZero = false;

        for(int i = 0; i < colLen; i++) {
            if(matrix[0][i] == 0)
                firstRowZero = true;
        }

        for(int i = 0; i < rowLen; i++) {
            if(matrix[i][0] == 0)
                firstColZero = true;
        }

        //traverse all row/col
        for(int i = 1; i < rowLen; i++) {
            for(int j = 1; j < colLen; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //mark resp row/col to zero
        for(int i = 1; i < rowLen; i++) {
            for(int j = 1; j < colLen; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        //make first row/col to zero
        for(int i = 0; i < colLen; i++) {
            if(firstRowZero)
                matrix[0][i] = 0;
        }
        for(int i = 0; i < rowLen; i++) {
            if(firstRowZero)
                matrix[i][0] = 0;
        }
    }

    public static void main(String args[]) {
        int[][] a = new int[][]{
                {1,0}};
        MatrixZeros.setZeroes(a);
    }
}
