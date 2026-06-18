class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for(int i = 0 ; i < n ; i++) {
            if(nums[i] <= 0 || nums[i] > n) nums[i] = n + 1;
        }

        for(int i = 0 ; i < n ; i++) {
            int index = Math.abs(nums[i]);

            if(index == n) {
                nums[0] = -Math.abs(nums[i]);
            } else if(index < n) {
                nums[index] = -Math.abs(nums[index]);
            }
        }

        for(int i = 1 ; i < n ; i++) {
            if(nums[i] > 0) return i;
        }

        return nums[0] > 0 ? n : n + 1;
    }
}