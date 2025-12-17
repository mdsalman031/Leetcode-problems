class Solution {
    private int helper(int[] nums, int goal) {
        //your code goes here
        if(goal < 0) return 0;
        int n = nums.length;
        int count = 0;
        int left = 0, right = 0, sum = 0;
        while(right < n) {
            sum += nums[right];
            while(sum > goal) {
                sum -= nums[left];
                left++;
            }
            count += (right - left + 1);
            right++;
        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sumLessThanEqualGoal = helper(nums, goal);
        int sumLessThanEqualGoalMinus1 = helper(nums, goal - 1);
        return (sumLessThanEqualGoal - sumLessThanEqualGoalMinus1);
    }
}