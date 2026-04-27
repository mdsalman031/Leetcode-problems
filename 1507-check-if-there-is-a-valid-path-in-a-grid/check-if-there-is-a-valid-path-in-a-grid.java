class Solution {
    private boolean dfs(int[][] grid, boolean[][] visited, int row, int col) {
        int n = grid.length;
        int m = grid[0].length;
        visited[row][col] = true;
        if(row == n - 1 && col == m - 1) return true;

        int node = grid[row][col];
        int nrow = 0, ncol = 0;
        if(node == 1) {
            ncol = col - 1; //left
            if(ncol >= 0 && !visited[row][ncol] && (grid[row][ncol] == 1 || grid[row][ncol] == 4 || grid[row][ncol] == 6)) {
                if(dfs(grid, visited, row, ncol)) return true;
            }
            ncol = col + 1; //right
            if(ncol < m && !visited[row][ncol] && (grid[row][ncol] == 1 || grid[row][ncol] == 3 || grid[row][ncol] == 5)) {
                if(dfs(grid, visited, row, ncol)) return true;
            }
        } else if(node == 2) {
            nrow = row - 1; //up
            if(nrow >= 0 && !visited[nrow][col] && (grid[nrow][col] == 2 ||grid[nrow][col] == 3 || grid[nrow][col] == 4)) {
                if(dfs(grid, visited, nrow, col)) return true;
            }
            nrow = row + 1; //down
            if(nrow < n && !visited[nrow][col] && (grid[nrow][col] == 2 || grid[nrow][col] == 5 || grid[nrow][col] == 6)) {
                if(dfs(grid, visited, nrow, col)) return true;
            }
        } else if(node == 3) {
            ncol = col - 1; //left
            if(ncol >= 0 && !visited[row][ncol] && (grid[row][ncol] == 1 ||grid[row][ncol] == 4 || grid[row][ncol] == 6)) {
                if(dfs(grid, visited, row, ncol)) return true;
            }
            nrow = row + 1; //down
            if(nrow < n && !visited[nrow][col] && (grid[nrow][col] == 2 || grid[nrow][col] == 5 || grid[nrow][col] == 6)) {
                if(dfs(grid, visited, nrow, col)) return true;
            }
        } else if(node == 4) {
            ncol = col + 1; //right
            if(ncol < m && !visited[row][ncol] && (grid[row][ncol] == 1 || grid[row][ncol] == 3 || grid[row][ncol] == 5)) {
                if(dfs(grid, visited, row, ncol)) return true;
            }
            nrow = row + 1; //down
            if(nrow < n && !visited[nrow][col] && (grid[nrow][col] == 2 || grid[nrow][col] == 5 || grid[nrow][col] == 6)) {
                if(dfs(grid, visited, nrow, col)) return true;
            }
        } else if(node == 5) {
            ncol = col - 1; //left
            if(ncol >= 0 && !visited[row][ncol] && (grid[row][ncol] == 1 ||grid[row][ncol] == 4 || grid[row][ncol] == 6)) {
                if(dfs(grid, visited, row, ncol)) return true;
            }
            nrow = row - 1; //up
            if(nrow >= 0 && !visited[nrow][col] && (grid[nrow][col] == 2 ||grid[nrow][col] == 3 || grid[nrow][col] == 4)) {
                if(dfs(grid, visited, nrow, col)) return true;
            }
        } else {
            ncol = col + 1; //right
            if(ncol < m && !visited[row][ncol] && (grid[row][ncol] == 1 || grid[row][ncol] == 3 || grid[row][ncol] == 5)) {
                if(dfs(grid, visited, row, ncol)) return true;
            }
            nrow = row - 1; //up
            if(nrow >= 0 && !visited[nrow][col] && (grid[nrow][col] == 2 ||grid[nrow][col] == 3 || grid[nrow][col] == 4)) {
                if(dfs(grid, visited, nrow, col)) return true;
            }
        }

        return false;
    }
    public boolean hasValidPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        return dfs(grid, visited, 0, 0);
    }
}