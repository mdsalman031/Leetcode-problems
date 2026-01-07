class Pair {
    int first;
    int second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    private void bfs(int[][] image, int[][] visited, int r, int c, int original, int newColor) {
        int n = image.length;
        int m = image[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(r, c));
        visited[r][c] = 1;
        image[r][c] = newColor;

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while(!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.poll();

            for(int k = 0 ; k < 4 ; k++) {
                int nrow = row + drow[k];
                int ncol = col + dcol[k];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                        visited[nrow][ncol] == 0 && image[nrow][ncol] == original) {
                    visited[nrow][ncol] = 1;
                    image[nrow][ncol] = newColor;
                    q.offer(new Pair(nrow, ncol));
                }
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int[][] visited = new int[n][m];

        int original = image[sr][sc];
        if(original == color) return image;

        bfs(image, visited, sr, sc, original, color);
        
        return image;
    }
}