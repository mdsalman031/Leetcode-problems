class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();

        for(int i = 2*n - 1 ; i >= 0 ; i--) {
            while(!stack.isEmpty() && stack.peek() <= nums[i % n]) stack.pop();

            int nextGreater = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % n]);
            if(i < n) nums[i] = nextGreater;
        }

        return nums;
    }
}