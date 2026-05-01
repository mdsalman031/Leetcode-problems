class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;

        long sum = 0;
        for(int i = 0 ; i < n ; i++) sum += nums[i];

        long prev = 0;
        for(int i = 0 ; i < n ; i++) {
            prev += i*nums[i];
        }
        if(n == 1) return (int)prev;

        int maxValue = (int)prev;
        for(int i = 1 ; i < n ; i++) {
            long cur = sum + prev - n*nums[n-i];
            prev = cur;
            maxValue = Math.max(maxValue, (int)cur);
        }

        return maxValue;
    }
}