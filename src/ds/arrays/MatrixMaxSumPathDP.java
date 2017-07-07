package ds.arrays;

/**
 Given an m x n matrix filled with non-negative integers, use dynamic programming techniques to find the maximum sum
 along a path from the top-left of the grid to the bottom-right. Return this maximum sum.
 The direction of movement is limited to right and down.

 Example:
 Input Matrix :
 1 2 3
 4 5 6
 7 8 9

 Output  : 1 + 4 + 7 + 8 + 9 = 29
 Note:
 You may have previously solved the DFS variant of this problem. That won't work for large sized matrices - just consider
 the size of the recursion tree for a 100x100 matrix! Dynamic Programming should afford a better solution.
 */

public class MatrixMaxSumPathDP {

    public static int matrixMaxSumDP(int[][] grid) {
        return maxPathUsingRecursion(grid, 0, 0, 0, 0);
    }

    public static int maxPathUsingRecursion(int[][] grid, int row, int col, int sum, int max) {
        if (row >= grid.length || col >= grid[0].length) {
            return max;
        }
        sum += grid[row][col];
        /*max = maxPathUsingRecursion(grid, row, col + 1, sum, max);
        max = maxPathUsingRecursion(grid, row + 1, col, sum, max);*/
        max = Math.max(maxPathUsingRecursion(grid, row, col + 1, sum, max), maxPathUsingRecursion(grid, row + 1, col, sum, max));
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            max = Math.max(max, sum);
        }
        return max;
    }

    public static int matrixMaxSumDP1(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int[][] memo = new int[m][n];
        memo[0][0] = grid[0][0];
        // Pre-Fill first Column
        for(int i = 1; i < m; i++){
            memo[i][0] = memo[i-1][0] + grid[i][0];
        }
        // Pre-Fill first Column
        for(int j = 1; j < n; j++){
            memo[0][j] = memo[0][j-1] + grid[0][j];
        }
        // Fill remaining cells
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                memo[i][j] = grid[i][j] + Math.max(memo[i-1][j], memo[i][j-1]);
            }
        }
        return memo[m-1][n-1];
    }

    public static int matrixMaxSumDP2(int[][] grid) {
        int[][] maxSum = new int[grid.length][grid[0].length];

        maxSum[0][0] = grid[0][0];

        for(int index = 1; index < maxSum.length; index++)
            maxSum[index][0] = maxSum[index-1][0] + grid[index][0];

        for(int index = 1; index < maxSum[0].length; index++)
            maxSum[0][index] = maxSum[0][index-1] + grid[0][index];

        for(int row = 1; row < maxSum.length; row++)
            for(int column = 1; column < maxSum[0].length; column++)
                maxSum[row][column] = Math.max(maxSum[row-1][column], maxSum[row][column-1]) + grid[row][column];

        return grid.length == 0 ? 0 : maxSum[grid.length-1][grid[0].length-1];
    }

    public static int matrixMaxSumDP3(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        if (m == 0 && n == 0) return 0;

        // matrix of max sums starting at (0,0)
        int[][] maxSums = new int[m][n];

        maxSums[0][0] = grid[0][0];
        // first row
        for (int j = 1; j < n; j++) maxSums[0][j] = maxSums[0][j-1] + grid[0][j];
        // first column
        for (int i = 1; i < m; i++) maxSums[i][0] = maxSums[i-1][0] + grid[i][0];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                maxSums[i][j] = Math.max(maxSums[i-1][j], maxSums[i][j-1]) + grid[i][j];
            }
        }

        return maxSums[m-1][n-1];
    }

    public static void main(String a[]) {
        int result = MatrixMaxSumPathDP.matrixMaxSumDP(
                new int[][]{
                        {1, 2, 3},
                        {4, 5, 26},
                        {1, 8, 9}});
        System.out.println(result);
    }

}
