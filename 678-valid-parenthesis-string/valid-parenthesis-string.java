class Solution {
    private boolean helper(int index, String s, int count, Boolean[][] dp) {
        if(count < 0) return false;

        if(index == s.length()) return count == 0;
        if(dp[index][count] != null) return dp[index][count];

        char ch = s.charAt(index);
        boolean result;

        if(ch == '(') {
            result = helper(index + 1, s, count + 1, dp);
        } else if(ch == ')') {
            result = helper(index + 1, s, count - 1, dp);
        } else {
            result = helper(index + 1, s, count + 1, dp) ||
                    helper(index + 1, s, count - 1, dp) ||
                    helper(index + 1, s, count, dp);
        }

        return dp[index][count] = result;
    }
    public boolean checkValidString(String s) {
        int n = s.length();
        Boolean[][] dp = new Boolean[n][n];
        return helper(0, s, 0, dp);
    }
}