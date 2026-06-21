class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        int n = nums.length, result = 0;
        
        for(int i = 0 ; i < n ; i++) {
            long sum = 0;
            for(int j = i ; j < n ; j++) {
                sum += nums[j];
    
                long lastDigit = sum % 10;
                long numDigitsMinusOne = (long) Math.log10(sum);
                long firstDigit = (long) (sum / Math.pow(10, numDigitsMinusOne));
                if(firstDigit == x && lastDigit == x) result++;
            }
        }

        return result;
    }
}