package ds.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 You're given a 2D board which contains an m x n matrix of chars - char[][] board.
 Write a method - printPaths that prints all possible paths from the top left cell to the bottom right cell.
 Your method should return an ArrayList of Strings, where each String represents a path with characters appended in the order of movement.
 You're only allowed to move down and right on the board. The order of String insertion in the ArrayList does not matter.
 */
public class PrintPaths {

    public ArrayList<String> printPaths(int[][] board){
        ArrayList<String> result = new ArrayList<>();
        if (board == null || board.length == 0) return result;
        StringBuffer sb = new StringBuffer();
        recursivePrintPaths(result, sb, board, 0, 0);
        return result;
    }

    public void recursivePrintPaths(ArrayList<String> result, StringBuffer sb,
                                                 int[][] board, int row, int col){

        if (row >= board.length || col >= board[0].length) {
            return;
        }
        sb.append(board[row][col]);
        recursivePrintPaths(result, sb, board, row, col + 1);
        recursivePrintPaths(result, sb, board, row + 1, col);
        if (sb.length() == (board.length + board[0].length - 1)) {
            result.add(sb.toString());
        }
        sb.deleteCharAt(sb.length() - 1);
    }

    public void print(char arr[][], int row, int col, char result[], int pos){
        if(row == arr.length-1 && col == arr[0].length-1){
            result[pos] = arr[row][col];
            System.out.println(Arrays.toString(result));
            return;
        }
        if(row >= arr.length || col >= arr[0].length){
            return;
        }
        result[pos] = arr[row][col];
        print(arr,row,col+1,result,pos+1);
        print(arr,row+1,col,result,pos+1);
    }

    public int countPaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        int[][] board = new int[m][n];
        printPaths(board);
        return 0;
    }

    public static void main(String a[]) {
        PrintPaths pp = new PrintPaths();
        char[][] c = new char[][]{
               /* {'A', 'B', 'C'},
                {'D', 'E', 'F'},
                {'G', 'H', 'I'}*/
                {'A', 'B'},
                {'C', 'D'}
        };
        //ArrayList<String> result = pp.printPaths(c);
        //System.out.println(result);
        //char result[] = new char[c.length + c[0].length-1];
        //pp.print(c, 0, 0, result, 0);
        pp.countPaths(3, 3);
    }

}
