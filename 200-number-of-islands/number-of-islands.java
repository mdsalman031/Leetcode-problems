class Pair {
    int first;
    int second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    private void bfs(char[][] grid, int[][] visited, int ro, int co, int n, int m) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(ro, co));
        visited[ro][co] = 1;

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while(!queue.isEmpty()) {
            int row = queue.peek().first;
            int col = queue.peek().second;
            queue.poll();
            
            for(int k = 0 ; k < 4 ; k++) {
                int nrow = row + drow[k];
                int ncol = col + dcol[k];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                        visited[nrow][ncol] == 0 && grid[nrow][ncol] == '1') {
                    visited[nrow][ncol] = 1;
                    queue.offer(new Pair(nrow, ncol));
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];

        int count = 0;
        for(int row = 0 ; row < n ; row++) {
            for(int col = 0 ; col < m ; col++) {
                if(visited[row][col] == 0 && grid[row][col] == '1') {
                    bfs(grid, visited, row, col, n, m);
                    count++;
                }
            }
        }
        return count;
    }
}