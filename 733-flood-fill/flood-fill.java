class Solution {
    private void dfs(int[][] image, int r, int c, int orgColor, int newColor) {
        image[r][c] = newColor;

        int n = image.length;
        int m = image[0].length;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        for(int k = 0 ; k < 4 ; k++) {
            int nrow = r + drow[k];
            int ncol = c + dcol[k];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == orgColor) {
                image[nrow][ncol] = newColor;
                dfs(image, nrow, ncol, orgColor, newColor);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor) return image;
        
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
}