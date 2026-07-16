class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int left = 0, right = 0;
        int totalSum = 0;
        int maxLen = -1;

        for(int num : nums) totalSum += num;
        
        int target = totalSum - x;
        int windowSum = 0;

        while(right < n) {
            windowSum += nums[right];

            while(left <= right && windowSum > target) {
                windowSum -= nums[left];
                left++;
            }

            if(windowSum == target) maxLen = Math.max(maxLen, right - left + 1);

            right++;
        }

        return maxLen != -1 ? n - maxLen : -1;
    }
}