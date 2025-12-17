class Solution {
    private int helper(int[] nums, int goal) {
        if(goal < 0) return 0;
        int n = nums.length;
        int count = 0, sum = 0;
        int left = 0, right = 0;
        while(right < n) {
            sum += nums[right] % 2;
            while(sum > goal) {
                sum -= nums[left] % 2;
                left++;
            }
            count += (right - left + 1);
            right++;
        }
        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        // Using the same logic as Binary Subarrays with sum, 
        // considering the odd numbers as 1 and even numbers as 0
        return helper(nums, k) - helper(nums, k - 1);
    }
}