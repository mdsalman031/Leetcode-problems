class Solution {
    private int[][] convert(char[][] grid, int n, int m) {
        int[][] helper = new int[n][m];
        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < m ; j++) {
                if(grid[i][j] == 'X') helper[i][j] = 1;
                else if(grid[i][j] == 'Y') helper[i][j] = -1;
                else helper[i][j] = 0;
            }
        return helper;
    }
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] helper = convert(grid, n, m);
        int[][] xCount = new int[n][m];

        int balance = 0, X_count = 0, ans = 0;
        // 1st row sum
        for(int j = 0 ; j < m ; j++) {
            if(grid[0][j] == 'X') X_count++;
            balance += helper[0][j];
            helper[0][j] = balance;
            xCount[0][j] = X_count;
            if(balance == 0 && X_count >= 1) ans++;
        }
        // 1st col sum
        balance = helper[0][0];
        X_count = (grid[0][0] == 'X') ? 1 : 0;
        xCount[0][0] = X_count;
        for(int i = 1 ; i < n ; i++) {
            if(grid[i][0] == 'X') X_count++;
            balance += helper[i][0];
            helper[i][0] = balance;
            xCount[i][0] = X_count;
            if(balance == 0 && X_count >= 1) ans++;
        }

        for(int i = 1 ; i < n ; i++) {
            for(int j = 1 ; j < m ; j++) {
                if(grid[i][j] == 'X') X_count++;
                helper[i][j] = helper[i-1][j] + helper[i][j-1] - helper[i-1][j-1] + helper[i][j];
                xCount[i][j] = xCount[i-1][j] + xCount[i][j-1] - xCount[i-1][j-1] + (grid[i][j] == 'X' ? 1 : 0);
                if(helper[i][j] == 0 && xCount[i][j] >= 1) ans++;
            }
        }

        return ans;
    }
}