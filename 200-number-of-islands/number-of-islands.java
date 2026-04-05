class Solution {
    private void bfs(char[][] grid, boolean[][] visited, int row, int col) {
        visited[row][col] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});
        int n = grid.length;
        int m = grid[0].length;

        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};

        while(!q.isEmpty()) {
            int[] node = q.poll();
            int r = node[0];
            int c = node[1];
            for(int i = 0 ; i < 4 ; i++) {
                int nrow = drow[i] + r;
                int ncol = dcol[i] + c;
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&grid[nrow][ncol] == '1' && !visited[nrow][ncol]) {
                    visited[nrow][ncol] = true;
                    q.add(new int[]{nrow, ncol});
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int islands = 0;

        for(int row = 0 ; row < n ; row++) {
            for(int col = 0 ; col < m ; col++) {
                if(grid[row][col] == '1' && !visited[row][col]) {
                    bfs(grid, visited, row, col);
                    islands++;
                }
            }
        }

        return islands;
    }
}