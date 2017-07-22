package ds.arrays;

/**
 Given an m x n matrix filled with non-negative integers,
 find the minimum sum along a path from the top-left of the grid to the bottom-right
 which minimizes the sum of all numbers along it. Return this minimum sum. The direction of movement is limited to right and down.
 Example:

 Input Matrix :

 1 2 3
 4 5 6
 7 8 9

 Output  : 21
 */

public class MinSum2D {
    public static int minWeightedPath(int[][] grid) {
        int[] min = new int[]{Integer.MAX_VALUE};
        minWeightedPathRecursion(grid, 0, 0, 0, min);
        return min[0];
    }

    public static int minWeightedPathRecursion(int [][] grid, int r, int c, int sum, int[] min) {
        if (r > grid.length - 1 || c > grid[0].length - 1) return sum;
        sum += grid[r][c];
        if (r == grid.length - 1 && c == grid[0].length - 1) {
            min[0] = Math.min(min[0], sum + grid[r][c]);
            return sum;
        }
        minWeightedPathRecursion(grid, r, c + 1, sum, min);
        minWeightedPathRecursion(grid, r + 1, c, sum, min);
        return sum;
    }

    public static void main(String a[]) {
        int[][] A ={{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        System.out.println(MinSum2D.minWeightedPath(A));
    }
}
