class Solution {
    private void heapifyDown(int[] nums, int n, int i) {
        while(true) {
            int lChild = 2 * i + 1;
            int rChild = 2 * i + 2;
            int largest = i;
            if(lChild < n && nums[lChild] > nums[largest]) {
                largest = lChild;
            }
            if(rChild < n && nums[rChild] > nums[largest]) {
                largest = rChild;
            }
            if(largest != i) {
                int temp = nums[i];
                nums[i] = nums[largest];
                nums[largest] = temp;
                i = largest;
            } else {
                break;
            }
        }
    }
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        // Build max heap
        for(int i = (n / 2) - 1 ; i >= 0 ; i--) {
            heapifyDown(nums, n, i);
        }
        // Extractmax k times
        int result = -1;
        int last = n - 1;
        for(int i = 0 ; i < k ; i++) {
            result = nums[0];
            int temp = nums[0];
            nums[0] = nums[last];
            nums[last] = temp;
            last--;
            heapifyDown(nums, last + 1, 0);
        }
        return result;
    }
}