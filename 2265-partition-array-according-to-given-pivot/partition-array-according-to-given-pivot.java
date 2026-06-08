class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] ans = new int[n];
        int si = 0, bi = n - 1;

        for(int i = 0  ; i < n ; i++) {
            if(nums[i] < pivot) ans[si++] = nums[i];
        }

        for(int i = n - 1 ; i >= 0 ; i--) {
            if(nums[i] > pivot) ans[bi--] = nums[i];
        }

        for(int i = si ; i <= bi ; i++) {
            ans[i] = pivot;
        }

        return ans;
    }
}