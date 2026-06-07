class Solution {
    public int removeDuplicates(int[] nums) {
        int candidate = nums[0];
        int n = nums.length, index = 1;

        for(int i = 1 ; i < n ; i++) {
            if(nums[i] == candidate) continue;
            else {
                candidate = nums[i];
                nums[index++] = candidate;
            }
        }

        return index;
    }
}