class Solution {
    private int[] getPrefixProduct(int[] nums, int n) {
        int[] prefix = new int[n];

        prefix[0] = nums[0];
        for(int i = 1 ; i < n ; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }

        return prefix;
    }

    private int[] getSuffixProduct(int[] nums, int n) {
        int[] suffix = new int[n];

        suffix[n - 1] = nums[n - 1];
        for(int i = n - 2 ; i >= 0 ; i--) {
            suffix[i] = suffix[i + 1] * nums[i];
        }

        return suffix;
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = getPrefixProduct(nums, n);
        int[] suffix = getSuffixProduct(nums, n);
        int[] result = new int[n];

        for(int i = 0 ; i < n ; i++) {
            int leftProduct = i > 0 ? prefix[i - 1] : 1;
            int rightProduct = i < n - 1 ? suffix[i + 1] : 1;
            result[i] = leftProduct * rightProduct;
        }

        return result;
    }
}