class Solution {
    private void reverse(int row, int[][] matrix) {
        int left = 0, right = matrix.length - 1;

        while(left < right) {
            int temp = matrix[row][left];
            matrix[row][left] = matrix[row][right];
            matrix[row][right] = temp;
            left++;
            right--;
        }
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for(int i = 0 ; i < n ; i++) {
            for(int j = i + 1 ; j < n ; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i = 0 ; i < n ; i++) {
            reverse(i, matrix);
        }
    }
}