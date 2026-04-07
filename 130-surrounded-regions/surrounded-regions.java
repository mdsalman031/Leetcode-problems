class Solution {
    private void dfs(int row, int col, char[][] mat, boolean[][] visited, int[] drow, int[] dcol) {
        visited[row][col] = true;
        int n = mat.length;
        int m = mat[0].length;
        for(int k = 0 ; k < 4 ; k++) {
            int nrow = row + drow[k];
            int ncol = col + dcol[k];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !visited[nrow][ncol] && mat[nrow][ncol] == 'O') {
                dfs(nrow, ncol, mat, visited, drow, dcol);
            }
        }
    }
    public void solve(char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] visited = new boolean[n][m];
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        for(int j = 0 ; j < m ; j++) {
            if(!visited[0][j] && mat[0][j] == 'O') {
                dfs(0, j, mat, visited, drow, dcol);
            }
            if(!visited[n-1][j] && mat[n-1][j] == 'O') {
                dfs(n-1, j, mat, visited, drow, dcol);
            }
        }
        for(int i = 0 ; i < n ; i++) {
            if(!visited[i][0] && mat[i][0] == 'O') {
                dfs(i, 0, mat, visited, drow, dcol);
            }
            if(!visited[i][m-1] && mat[i][m-1] == 'O') {
                dfs(i, m-1, mat, visited, drow, dcol);
            }
        }

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(!visited[i][j] && mat[i][j] == 'O') {
                    mat[i][j] = 'X';
                }
            }
        }
    }
}