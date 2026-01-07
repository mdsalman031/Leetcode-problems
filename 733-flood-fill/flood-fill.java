class Solution {
    private void dfs(int[][] image, int[][] ans, int row, int col, int[] drow, int[] dcol, int orgColor, int newColor) {
        int n = image.length;
        int m = image[0].length;

        ans[row][col] = newColor;

        for(int k = 0 ; k < 4 ; k++) {
            int nrow = row + drow[k];
            int ncol = col + dcol[k];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                image[nrow][ncol] == orgColor && ans[nrow][ncol] != newColor) {
                dfs(image, ans, nrow, ncol, drow, dcol, orgColor, newColor);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int[][] ans = image;

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        dfs(image, ans, sr, sc, drow, dcol, image[sr][sc], color);

        return ans;
    }
}