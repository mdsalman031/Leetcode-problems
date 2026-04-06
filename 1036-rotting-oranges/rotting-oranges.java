class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] visited = new int[n][m] ;

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i, j, 0});
                    visited[i][j] = 2;
                }
            }
        }   

        int time = 0;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while(!q.isEmpty()) {
            int[] node = q.poll();
            int r = node[0];
            int c = node[1];
            int t = node[2];
            time = Math.max(time, t);
            for(int k = 0 ; k < 4 ; k++) {
                int nrow = r + drow[k];
                int ncol = c + dcol[k];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] != 2 && grid[nrow][ncol] == 1) {
                    q.add(new int[]{nrow, ncol, t + 1});
                    visited[nrow][ncol] = 2;
                }
            }
        }

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(grid[i][j] == 1 && visited[i][j] != 2) {
                    return -1;
                }
            }
        }   

        return time;
    }
}