package revise.graphs;

public class SurroundedRegionIslandProblem {

    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            //check for left end
            if (board[i][0] == 'O') {
                merge(board, i, 0);
            }
            //check for right end
            if (board[i][n - 1] == 'O') {
                merge(board, i, n - 1);
            }
        }

        for (int j = 0; j < n; j++) {
            //check for top end
            if (board[0][j] == 'O') {
                merge(board, 0, j);
            }
            //check for bottom end
            if (board[m - 1][j] == 'O') {
                merge(board, m - 1, j);
            }
        }
        //process the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void merge(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return;

        if (board[i][j] != 'O')
            return;

        board[i][j] = '#';

        merge(board, i - 1, j);
        merge(board, i + 1, j);
        merge(board, i, j - 1);
        merge(board, i, j + 1);
    }

    public static void main(String a[]) {
        SurroundedRegionIslandProblem s = new SurroundedRegionIslandProblem();
        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'X', 'O', 'O'},
        };
        s.solve(board);
        System.out.println(board);
    }
}
