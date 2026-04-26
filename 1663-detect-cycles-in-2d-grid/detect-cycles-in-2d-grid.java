class Solution {
    private boolean dfs(char[][] grid, boolean[][] visited, int row, int col, int pRow, int pCol) {
        visited[row][col] = true;
        int n = grid.length;
        int m = grid[0].length;

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        for(int k = 0 ; k < 4 ; k++) {
            int nrow = row + drow[k];
            int ncol = col + dcol[k];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == grid[row][col]) {
                if(!visited[nrow][ncol]) {
                    if(dfs(grid, visited, nrow, ncol, row, col)) return true;
                } else if(nrow != pRow || ncol != pCol) {
                    return true;
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