class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = 0, maxLen = 0;
        int zeros = 0;
        while(right < n) {
            if(nums[right] == 0) zeros++;
            if(zeros <= k) maxLen = Math.max(maxLen, right - left + 1);
            else {
                if(nums[left] == 0) zeros--;
                left++;
            }
            right++;
        }
        return maxLen;
    }
}