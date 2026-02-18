class Solution {
    private boolean helper(String s, int index, int count, int[][] dp) {
        if(count < 0) return false;
        if(index == s.length()) return (count == 0);
        if(dp[index][count] != -1) return dp[index][count] == 1;

        boolean ans = false;
        if(s.charAt(index) == '(') ans = helper(s, index + 1, count + 1, dp);
        else if(s.charAt(index) == ')') ans = helper(s, index + 1, count - 1, dp);
        else {
            for(int i = -1 ; i <= 1 ; i++) {
                ans = ans || helper(s, index + 1, count + i, dp);
            }
        }

        dp[index][count] = (ans) ? 1 : 0;
        return ans;
    }
    public boolean checkValidString(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < n ; j++)
                dp[i][j] = -1;

        return helper(s, 0, 0, dp);
    }
}