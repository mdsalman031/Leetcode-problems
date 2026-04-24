class Solution {
    private int helper(String moves, int index, int count, int[][] dp) {
        int n = moves.length();
        if(index == moves.length()) return Math.abs(count);

        if(dp[index][count + n] != -1) return dp[index][count + n];

        char direction = moves.charAt(index);
        if(direction == 'L') {
            return dp[index][count + n] = helper(moves, index + 1, count - 1, dp);
        } else if(direction == 'R') {
            return dp[index][count + n] = helper(moves, index + 1, count + 1, dp);
        } else {
            int ifLeft = helper(moves, index + 1, count - 1, dp);
            int ifRight = helper(moves, index + 1, count + 1, dp);
            return dp[index][count + n] = Math.max(ifLeft, ifRight);
        }
    }
    public int furthestDistanceFromOrigin(String moves) {
        int n = moves.length();
        int[][] dp = new int[n][2 * n + 1];
        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < 2 * n + 1 ; j++)
                dp[i][j] = -1;
        return helper(moves, 0, 0, dp);
    }
}