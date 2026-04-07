class Solution {
    public int[][] updateMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int[][] dist = new int[n][m];
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(grid[i][j] == 0) {
                    q.add(new int[]{i, j, 0});
                    visited[i][j] = 1;
                }
            }
        }

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        while(!q.isEmpty()) {
            int[] node = q.poll();
            int r = node[0];
            int c = node[1];
            int step = node[2];
            dist[r][c] = step;

            for(int k = 0 ; k < 4 ; k++) {
                int nrow = r + drow[k];
                int ncol = c + dcol[k];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] != 1 && grid[nrow][ncol] == 1) {
                    q.add(new int[]{nrow, ncol, step + 1});
                    visited[nrow][ncol] = 1;
                }
            }
        }
        return dist;
    }
}