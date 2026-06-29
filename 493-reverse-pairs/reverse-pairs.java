class Solution {
    private void merge(int[] nums, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;

        while(left <= mid && right <= high) {
            if(nums[left] <= nums[right]) {
                temp.add(nums[left]);
                left++;
            } else {
                temp.add(nums[right]);
                right++;
            }
        }

        while(left <= mid) {
            temp.add(nums[left]);
            left++;
        }

        while(right <= high) {
            temp.add(nums[right]);
            right++;
        }

        for(int i = low ; i <= high ; i++) {
            nums[i] = temp.get(i - low);
        }
    }

    private long mergeSort(int[] nums, int low, int high) {
        long count = 0;
        if(low < high) {
            int mid = low + (high - low) / 2;
            count += mergeSort(nums, low, mid);
            count += mergeSort(nums, mid + 1, high);
            count += countReversePairs(nums, low, mid, high);
            merge(nums, low, mid, high);
        }
        return count;
    }

    private long countReversePairs(int[] nums, int low, int mid, int high) {
        int right = mid + 1;
        long count = 0;
        for(int i = low ; i <= mid ; i++) {
            while(right <= high && nums[i] > 2L * nums[right]) right++;
            count += right - (mid + 1);
        }
        return count;
    }

    public int reversePairs(int[] nums) {
        return (int) mergeSort(nums, 0, nums.length - 1);
    }
}