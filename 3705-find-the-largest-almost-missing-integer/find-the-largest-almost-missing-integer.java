class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int[] freq = new int[51];

        for(int i = 0 ; i < n ; i++) {
            freq[nums[i]]++;
        }

        // if k == n them max(nums) is the answer
        if(k == n) {
            for(int i = 50 ; i >= 0 ; i--) {
                if(freq[i] > 0) return i;
            }
        }

        // if k == 1, then max(nums) which appears only once in the nums
        if(k == 1) {
            for(int i = 50 ; i >= 0 ; i--) {
                if(freq[i] == 1) return i;
            }
        }

        // if 1 <= k < n, then answer will be nums[0] or nums[n-1]
        int candidate1 = -1, candidate2 = -1;
        if(freq[nums[0]] == 1) candidate1 = nums[0];
        if(freq[nums[n - 1]] == 1) candidate2 = nums[n - 1];

        return Math.max(candidate1, candidate2);
    }
}