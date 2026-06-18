class Solution {
    private void reverse(int[] nums, int i, int j) {
        while(i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++; j--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = -1;

        for(int i = n - 2 ; i >= 0 ; i--) {
            if(nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }
        if(pivot != -1) {
            for(int i = n - 1 ; i >= 0 ; i--) {
                if(nums[i] > nums[pivot]) {
                    int temp = nums[i];
                    nums[i] = nums[pivot];
                    nums[pivot] = temp;
                    break;
                }
            }
            reverse(nums, pivot + 1, n - 1);
        } else {
            reverse(nums, 0, n - 1);
        } 
    }
}