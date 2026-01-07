class Pair {
    int first, second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public void solve(char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] visited = new int[n][m];
        Queue<Pair> q = new ArrayDeque<>();

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    if(mat[i][j] == 'O') {
                        q.offer(new Pair(i, j));
                        visited[i][j] = 1;
                    }
                }
            }
        }

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while(!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.poll();

            for(int k = 0 ; k < 4 ; k++) {
                int nrow = row + drow[k];
                int ncol = col + dcol[k];
                
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                        visited[nrow][ncol] == 0) {
                    if(mat[nrow][ncol] == 'O') {
                        visited[nrow][ncol] = 1;
                        q.offer(new Pair(nrow, ncol));
                    }
                }
            }
        }

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(mat[i][j] == 'O' && visited[i][j] == 0) {
                    mat[i][j] = 'X';
                }
            }
        }
    }
}