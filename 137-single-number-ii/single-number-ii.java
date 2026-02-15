class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int bitIndex = 0 ; bitIndex < 32 ; bitIndex++) {
            int count = 0;
            for(int num : nums) {
                if((num & (1 << bitIndex)) != 0) count++;
            }
            if(count % 3 != 0) ans = ans | (1 << bitIndex);
        }
        return ans;
    }
}