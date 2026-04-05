class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if((i == 0 || i == n - 1 || j == 0 || j == m - 1) && grid[i][j] == 1) {
                    visited[i][j] = 1;
                    q.add(new int[]{i, j});
                }
            }
        }

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while(!q.isEmpty()) {
            int[] node = q.poll();
            int r = node[0];
            int c = node[1];
            for(int k = 0 ; k < 4 ; k++) {
                int nrow = r + drow[k];
                int ncol = c + dcol[k];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1 && visited[nrow][ncol] == 0) {
                    visited[nrow][ncol] = 1;
                    q.add(new int[]{nrow, ncol});
                }
            }
        }

        int enclaves = 0;
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(grid[i][j] == 1 && visited[i][j] == 0) enclaves++;
            }
        }
        
        return enclaves;
    }
}