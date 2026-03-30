class Solution {
    private int maxAreaOfHistogram(int[] heights, int m) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for(int i = 0 ; i < m ; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int ele = stack.pop();
                int nse = i, pse = (stack.isEmpty()) ? -1 : stack.peek();
                maxArea = Math.max(maxArea, heights[ele] * (nse-pse-1));
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            int nse = m;
            int ele = stack.pop();
            int pse = (stack.isEmpty()) ? -1 : stack.peek();
            maxArea = Math.max(maxArea, heights[ele] * (nse-pse-1));
        }

        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] heights = new int[m];
        int maxArea = 0;

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(matrix[i][j] == '1') heights[j]++;
                else heights[j] = 0;
            }
            maxArea = Math.max(maxArea, maxAreaOfHistogram(heights, m));
        }

        return maxArea;
    }
}