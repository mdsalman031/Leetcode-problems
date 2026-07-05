class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums) {
            set.add(num);
        }

        int maxCount = 0;
        for(int num : set) {
            if(!set.contains(num - 1)) {
                int count = 0;
                while(set.contains(num)) {
                    count++;
                    num++;
                }
                maxCount = Math.max(maxCount, count);
            }
        }

        return maxCount;
    }
}