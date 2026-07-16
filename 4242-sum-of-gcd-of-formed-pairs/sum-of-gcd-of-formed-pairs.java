class Solution {
    private int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];

        int maxi = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++) {
            maxi = Math.max(maxi, nums[i]);
            prefixGcd[i] = gcd(nums[i], maxi);
        }

        Arrays.sort(prefixGcd);

        long result = 0;
        for(int i = 0 ; i < n / 2 ; i++) {
            result += gcd(prefixGcd[i], prefixGcd[n - i - 1]);
        }

        return result;
    }
}