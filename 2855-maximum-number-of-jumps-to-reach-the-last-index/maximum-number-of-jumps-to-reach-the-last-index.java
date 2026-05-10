class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];
        for(int i = 1 ; i < n ; i++) dp[i] = -1;

        for(int j = 1 ; j < n ; j++) {
            for(int i = 0 ; i < j ; i++) {
                int req = nums[j] - nums[i];
                if(-target <= req && req <= target && dp[i] != -1) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }

        return dp[n - 1];
    }
}