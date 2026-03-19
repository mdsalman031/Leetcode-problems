class Solution {
    private int[] pse(int[] nums, int n) {
        int[] prevSmaller = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < n ; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]) stack.pop();

            int index = (stack.isEmpty()) ? -1 : stack.peek();
            stack.push(i);
            prevSmaller[i] = index;
        }

        return prevSmaller;
    }
    private int[] nse(int[] nums, int n) {
        int[] nextSmaller = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = n - 1 ; i >= 0 ; i--) {
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]) stack.pop();

            int index = (stack.isEmpty()) ? n : stack.peek();
            stack.push(i);
            nextSmaller[i] = index;
        }

        return nextSmaller;
    }
    private int[] pge(int[] nums, int n) {
        int[] prevGreater = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < n ; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[i]) stack.pop();

            int index = (stack.isEmpty()) ? -1 : stack.peek();
            stack.push(i);
            prevGreater[i] = index;
        }

        return prevGreater;
    }
    private int[] nge(int[] nums, int n) {
        int[] nextGreater = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = n - 1 ; i >= 0 ; i--) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) stack.pop();

            int index = (stack.isEmpty()) ? n : stack.peek();
            stack.push(i);
            nextGreater[i] = index;
        }

        return nextGreater;
    }
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        int[] prevSmaller = pse(nums, n);
        int[] nextSmaller = nse(nums, n);
        int[] prevGreater = pge(nums, n);
        int[] nextGreater = nge(nums, n);

        long sumMin = 0, sumMax = 0;

        for(int i = 0 ; i < n ; i++) {
            int leftMin = i - prevSmaller[i];
            int rightMin = nextSmaller[i] - i;
            int leftMax = i - prevGreater[i];
            int rightMax = nextGreater[i] - i;

            sumMin += (long) leftMin * rightMin * nums[i];
            sumMax += (long) leftMax * rightMax * nums[i];
        }

        return sumMax - sumMin;
    }
}