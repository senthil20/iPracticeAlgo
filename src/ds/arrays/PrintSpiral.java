package ds.arrays;

import java.util.ArrayList;

/**
 * Created by senthil on 21/8/16.
 */
public class PrintSpiral {

    public void printSpiral(int a[][]) {

        int rowLen = a.length;
        int colLen = a[0].length;

        int top = 0;
        int right = colLen - 1;
        int bottom = rowLen - 1;
        int left = 0;
        int path = 0;

        while(top <= bottom && left <= right) {
            if(path == 0) {
                for(int i = left; i <= right; i++) {
                    System.out.print(a[top][i] + " ");
                }
                top++;
            }
            else if(path == 1) {
                for(int i = top; i <= bottom; i++) {
                    System.out.print(a[i][right] + " ");
                }
                right--;
            }
            else if(path == 2) {
                for(int i = right; i >= left; i--) {
                    System.out.print(a[bottom][i] + " ");
                }
                bottom--;
            }
            else if(path == 3) {
                for(int i = bottom; i >= top; i--) {
                    System.out.print(a[i][left] + " ");
                }
                left++;
            }
            path = (path + 1) % 4;
        }
    }

    public void printSpiralII(int n) {

            ArrayList<ArrayList<Integer>> spList = new ArrayList<>();

            int a[][] = new int[n][n];
            int rowLen = n;
            int colLen = n;
            int top = 0;
            int right = colLen - 1;
            int bottom = rowLen - 1;
            int left = 0;
            int path = 0;
            int count = 1;

            while (top <= bottom && left <= right) {
                if (path == 0) {
                    for (int i = left; i <= right; i++) {
                        a[top][i] = count++;
                    }
                    top++;
                } else if (path == 1) {
                    for (int i = top; i <= bottom; i++) {
                        a[i][right] = count++;
                    }
                    right--;
                } else if (path == 2) {
                    for (int i = right; i >= left; i--) {
                        a[bottom][i] = count++;
                    }
                    bottom--;
                } else if (path == 3) {
                    for (int i = bottom; i >= top; i--) {
                        a[i][left] = count++;
                    }
                    left++;
                }
                path = (path + 1) % 4;
            }

            ArrayList<Integer> rowList = null;

            for (int i = 0; i < rowLen; i++) {
                rowList = new ArrayList<>();

                for (int j = 0; j < colLen; j++) {
                    rowList.add(a[i][j]);
                }

                spList.add(rowList);
            }
            System.out.println(spList);
        }

    public static void main(String ar[]) {

        PrintSpiral ps = new PrintSpiral();

        int[][] a = new int[][]{
                {2,3,4,5},
                {6,7,8,9},
                {10,11,12,13},
                {14,15,16,17}
        };
        //ps.printSpiral(a);
        ps.printSpiralII(3);
    }
}
