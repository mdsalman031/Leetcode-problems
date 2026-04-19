class Solution {
    private int floor(int[] nums, int low, int high, int target) {
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] <= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    public int maxDistance(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int maxDist = Integer.MIN_VALUE;
        
        for(int j = 0 ; j < n2 ; j++) {
            int i = (j < n1) ? floor(nums1, 0, j, nums2[j]) : floor(nums1, 0, n1 - 1, nums2[j]);
            if(nums1[i] <= nums2[j]) maxDist = Math.max(maxDist, j - i);
        }

        return maxDist != Integer.MIN_VALUE ? maxDist : 0;
    }
}