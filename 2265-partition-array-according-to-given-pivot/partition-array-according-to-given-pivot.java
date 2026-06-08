class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        List<Integer> smaller = new ArrayList<>();
        List<Integer> bigger = new ArrayList<>();

        for(int i = 0 ; i < n ; i++) {
            if(nums[i] < pivot) smaller.add(nums[i]);
            if(nums[i] > pivot) bigger.add(nums[i]);
        }

        int pivotCount = n - (smaller.size() + bigger.size());

        int index = 0;
        for(int ele : smaller) {
            nums[index++] = ele;
        }

        while(pivotCount > 0) {
            nums[index++] = pivot;
            pivotCount--;
        }

        for(int ele : bigger) {
            nums[index++] = ele;
        }

        return nums;
    }
}