package DataStructures.arrays;

public class PathsToReachEnd {

    //Using recursion
    public static int countPath(int[][] A, int rLen, int cLen, int i, int j) {
        if (i > rLen - 1 || j > cLen - 1) return 0;
        if (i == rLen - 1 && j == cLen - 1) return 1;
        return countPath(A, rLen,cLen, i + 1, j) + countPath(A, rLen,cLen, i, j + 1);
    }

    //Using DP
    public static int path(int [][] A){
        int rowLen = A.length;
        int colLen = A[0].length;
        int result [][] = new int[rowLen][colLen];
        result[0][0] = 1;
        for (int i = 0; i < rowLen; i++) {
            result[0][i] = 1;
        }
        for (int i = 0; i < colLen; i++) {
            result[i][0] = 1;
        }
        for (int i = 1; i < rowLen; i++) {
            for (int j = 1; j < colLen; j++) {
                result[i][j] = result[i - 1][j] + result[i][j - 1];
            }
        }
        return result[A.length-1][A.length-1];
    }


    public static void main(String a[]) {
        int A[][] = new int[4][4];
        System.out.print(PathsToReachEnd.countPath(A, A.length, A[0].length, 0, 0));
        //System.out.println(PathsToReachEnd.path(A));
    }
}
