class Solution {
    public void solve(char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<int[]> q = new ArrayDeque<>();

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    if(mat[i][j] == 'O') {
                        mat[i][j] = '#';
                        q.offer(new int[]{i, j});
                    }
                }
            }
        }

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int row = cur[0], col = cur[1];

            for(int k = 0 ; k < 4 ; k++) {
                int nrow = row + drow[k];
                int ncol = col + dcol[k];
                
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m) {
                    if(mat[nrow][ncol] == 'O') {
                        mat[nrow][ncol] = '#';
                        q.offer(new int[]{nrow, ncol});
                    }
                }
            }
        }

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(mat[i][j] == 'O') mat[i][j] = 'X';
                else if(mat[i][j] == '#') mat[i][j] = 'O';
            }
        }
    }
}