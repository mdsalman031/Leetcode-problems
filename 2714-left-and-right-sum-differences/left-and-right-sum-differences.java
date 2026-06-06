class Solution {
    public int[] leftRightDifference(int[] nums) {
        int leftSum = 0, rightSum = 0, n = nums.length;
        int[] ans = new int[n];

        for(int num : nums) rightSum += num;

        for(int i = 0 ; i < n ; i++) {
            int val = nums[i];
            rightSum -= val;

            ans[i] = Math.abs(leftSum - rightSum);

            leftSum += val;
        }

        return ans;
    }
}