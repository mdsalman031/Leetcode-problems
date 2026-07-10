class Solution {
    public int countElements(int[] nums, int k) {
        int n = nums.length;
        if(k == 0) return n;

        Arrays.sort(nums);

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++) map.put(nums[i], i);

        int count = 0;
        for(int i = 0 ; i < n ; i++) {
            int lastIndex = map.get(nums[i]);
            if(n - lastIndex - 1 >= k) count++;
        }

        return count;
    }
}