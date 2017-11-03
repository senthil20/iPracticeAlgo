package revise.graphs;

public class JoinIsland {

    public static int findNumberOfIslands(int[][] A, int row, int col) {
        int count = 0;
        boolean[][] visited = new boolean[A.length][A[0].length];
        for (int r = 0; r < A.length; r++) {
            for (int c = 0; c < A[0].length; c++) {
                if (!visited[r][c] && A[r][c] != 0) {
                    ++count;
                    dfs(A, visited, r, c);
                }
            }
        }
        return count;
    }

    public static void dfs(int[][] A, boolean[][] visited, int r, int c) {
        if (r < 0 || r >= A.length || c < 0 || c >= A[0].length
                || visited[r][c] || A[r][c] == 0) return;

        visited[r][c] = true;

        dfs(A, visited, r, c-1);
        dfs(A, visited, r-1, c-1);
        dfs(A, visited, r-1, c);
        dfs(A, visited, r-1, c+1);
        dfs(A, visited, r, c+1);
        dfs(A, visited, r+1, c+1);
        dfs(A, visited, r+1, c);
        dfs(A, visited, r+1, c-1);
    }

    public static void main(String a[]) {
        int A[][] = {
                {1, 0, 1, 0, 1},
                {1, 1, 0, 0, 0},
                {0, 1, 0, 1, 1}
        };
        System.out.println(findNumberOfIslands(A, 0, 0));
    }
}
