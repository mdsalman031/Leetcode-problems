class Pair {
    int first, second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] visited = new int[n][m];

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(grid[i][j] == 2) {
                    q.offer(new Pair(i, j));
                    visited[i][j] = 1;
                } 
            }
        }

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        int minute = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            boolean rotten = false;

            for(int i = 0 ; i < size ; i++) {
                int row = q.peek().first;
                int col = q.peek().second;
                q.poll();

                for(int k = 0 ; k < 4 ; k++) {
                    int nrow = row + drow[k];
                    int ncol = col + dcol[k];

                    if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                            grid[nrow][ncol] == 1 && visited[nrow][ncol] == 0) {
                        grid[nrow][ncol] = 2;
                        visited[nrow][ncol] = 1;
                        q.offer(new Pair(nrow, ncol));
                        rotten = true;
                    }
                }
            } 
            if(rotten) minute++;
        }

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                } 
            }
        }

        return minute;
    }
}