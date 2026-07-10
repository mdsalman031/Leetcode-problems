class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        int minDist = n;
        for(int i = n - 1 ; i >= 0 ; i--) {
            int num = nums[i];
            int rev = 0;
            while(num > 0) {
                rev = rev * 10 + (num % 10);
                num /= 10;
            }

            if(map.containsKey(rev)) minDist = Math.min(minDist, map.get(rev) - i);
            map.put(nums[i], i);
        }

        return minDist == n ? -1 : minDist;
    }
}