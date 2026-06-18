class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int start = 0, end = 0, jumps = 0;

        while(end < n - 1) {
            int farthest = 0;
            for(int i = start ; i <= end ; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            start = end + 1;
            end = farthest;
            jumps++;
        }

        return jumps;
    }
}