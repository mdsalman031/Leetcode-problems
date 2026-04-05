class Solution {
    private void bfs(int[][] image, int sr, int sc, int orgColor, int newColor) {
        image[sr][sc] = newColor;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});

        int n = image.length;
        int m = image[0].length;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while(!q.isEmpty()) {
            int[] node = q.poll();
            int r = node[0];
            int c = node[1];
            for(int k = 0 ; k < 4 ; k++) {
                int nrow = r + drow[k];
                int ncol = c + dcol[k];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == orgColor) {
                    image[nrow][ncol] = newColor;
                    q.add(new int[]{nrow, ncol});
                }
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor) return image;
        
        bfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
}