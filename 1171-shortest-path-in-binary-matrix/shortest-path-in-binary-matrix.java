class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;

        boolean[][] visited = new boolean[n][n];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0, 0});
        visited[0][0] = true;

        int[] drow = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dcol = {-1, 0, 1, 1, 1, 0, -1, -1};

        while(!q.isEmpty()) {
            int dist = q.peek()[0];
            int r = q.peek()[1];
            int c = q.peek()[2];
            q.poll();

            if(r == n-1 && c == n-1) return dist;

            for(int k = 0 ; k < 8 ; k++) {
                int nr = r + drow[k];
                int nc = c + dcol[k];

                if(nr >= 0 && nr < n && nc >= 0 && nc < n && 
                    !visited[nr][nc] && grid[nr][nc] == 0) {
                    visited[nr][nc] = true;
                    q.add(new int[]{dist + 1, nr, nc});
                }
            }
        }

        return -1;
    }
}