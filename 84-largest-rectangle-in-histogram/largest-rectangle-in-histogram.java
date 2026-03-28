class Solution {
    private int[] prevSmallerElement(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] pse = new int[n];

        for(int i = 0 ; i < n ; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            pse[i] = (stack.isEmpty()) ? -1 : stack.peek();
            stack.push(i);
        }

        return pse;
    }
    private int[] nextSmallerElement(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] nse = new int[n];

        for(int i = n - 1 ; i >= 0 ; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nse[i] = (stack.isEmpty()) ? n : stack.peek();
            stack.push(i);
        }

        return nse;
    }
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] pse = prevSmallerElement(heights, n);
        int[] nse = nextSmallerElement(heights, n);
        int maxi = 0;

        for(int i = 0 ; i < n ; i++) {
            maxi = Math.max(maxi, heights[i] * (nse[i] - pse[i] - 1));
        }

        return maxi;
    }
}