class Solution {
    private int lowerBound(List<Integer> temp, int low, int high, int target) {
        while(low < high) {
            int mid = low + (high - low) / 2;

            if(temp.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
    
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);

        for(int i = 1 ; i < n ; i++) {
            if(nums[i] > temp.get(temp.size() - 1)) {
                temp.add(nums[i]);
            } else {
                int ind = lowerBound(temp, 0, temp.size() - 1, nums[i]);
                temp.set(ind, nums[i]);
            }
        }

        return temp.size();
    }
}