class Solution {
    private int[] prevSmallerElement(int[] arr, int n) {
        int[] pse = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < n ; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            pse[i] = (stack.isEmpty()) ? -1 : stack.peek();
            stack.push(i);
        }

        return pse;
    }
    private int[] nextSmallerElement(int[] arr, int n) {
        int[] nse = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = n - 1 ; i >= 0 ; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) stack.pop();
            nse[i] = (stack.isEmpty()) ? n : stack.peek();
            stack.push(i);
        }

        return nse;
    }
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] pse = prevSmallerElement(arr, n);
        int[] nse = nextSmallerElement(arr, n);
        int sum = 0, mod = 1000000007;

        for(int i = 0 ; i < n ; i++) {
            int left = (i - pse[i]);
            int right = (nse[i] - i);
            long freq = left * right * 1L;
            int val = (int) ((freq * arr[i]) % mod);

            sum = (sum + val) % mod;
        }

        return sum;
    }
}