class Solution {
    private int reverse(int num) {
        int rev = 0;
        while(num > 0) {
            rev = rev * 10 + (num % 10);
            num /= 10;
        }
        return rev;
    }
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>(); // array element, index
        int minDist = Integer.MAX_VALUE;

        for(int j = 0 ; j < n ; j++) {
            if(map.containsKey(nums[j])) {
                minDist = Math.min(minDist, j - map.get(nums[j]));
            }
            int target = reverse(nums[j]);
            map.put(target, j);
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}