class Solution {
    private boolean dfs(char[][] grid, boolean[][] visited, int r, int c, int parentRow, int parentCol) {
        visited[r][c] = true;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        int n = grid.length;
        int m = grid[0].length;

        for(int k = 0 ; k < 4 ; k++) {
            int nrow = r + drow[k];
            int ncol = c + dcol[k];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == grid[r][c]) {
                if(visited[nrow][ncol] && (nrow != parentRow || ncol != parentCol)) {
                    return true;
                } else if(!visited[nrow][ncol]) {
                    if(dfs(grid, visited, nrow, ncol, r, c)) return true;
                }
            } 
        }
        return false;
    }
    public boolean containsCycle(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(!visited[i][j]) {
                    if(dfs(grid, visited, i, j, -1, -1)) return true;
                }
            }
        }

        return false;
    }
}