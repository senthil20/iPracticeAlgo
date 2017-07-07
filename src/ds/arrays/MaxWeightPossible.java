package ds.arrays;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class MaxWeightPossible {

    public static double maxWeightPossible(int maxWt, double wt[], int val[], int n) {
        double result[][] = new double[n + 1][maxWt + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= maxWt; j++) {
                if (i == 0 || j == 0)
                    result[i][j] = 0;
                else if (wt[i - 1] <= j)
                    result[i][j] = Math.max(val[i - 1] + result[i - 1][(int) (j - wt[i - 1])], result[i - 1][j]);
                else
                    result[i][j] = result[i - 1][j];
            }
        }
        return result[n][maxWt];
    }

    public static void main(String a[]) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("C:\\Package_Problem\\input.txt"));
        while (sc.hasNextLine()) {
            String temp = sc.nextLine();
            String[] item = temp.split(":");
            int maxWt = Integer.parseInt(item[0]);
            String[] str = item[1].split(" ");

            int[] index = new int[str.length];
            int[] val = new int[str.length];
            double[] wt = new double[str.length];
            int count = 0;

            for (String s : str) {
                String key = s.substring(1, s.length() - 1);
                String[] value = key.split(",");
                index[count] = Integer.parseInt(value[0]);
                wt[count] = Double.parseDouble(value[1]);
                val[count] = Integer.parseInt(value[2].substring(1));
                count++;
            }
            System.out.println(maxWeightPossible(maxWt, wt, val, val.length));
        }
    }
}