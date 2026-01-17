class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int left = 0, right = cols - 1, top = 0, bot = rows - 1;

        while(left <= right && top <= bot) {
            for(int i = left ; i <= right ; i++) {
                ans.add(matrix[top][i]);
            }
            top++;
            for(int i = top ; i <= bot ; i++) {
                ans.add(matrix[i][right]);
            }
            right--;
            if(top <= bot) {
                for(int i = right ; i >= left ; i--) {
                    ans.add(matrix[bot][i]);
                }
                bot--;
            }
            if(left <= right) {
                for(int i = bot ; i >= top ; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }   
        }

        return ans;
    }
}