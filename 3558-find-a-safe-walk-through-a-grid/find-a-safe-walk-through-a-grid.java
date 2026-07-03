class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();
        int[][] dist = new int[n][m];

        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < m ; j++)
                dist[i][j] = Integer.MAX_VALUE;
        
        Deque<int[]> dq = new ArrayDeque<>();

        dist[0][0] = grid.get(0).get(0);
        dq.add(new int[]{0,0});

        int[][] dir = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        while(!dq.isEmpty()) {
            int[] node = dq.poll();
            int r = node[0];
            int c = node[1];

            if(r == n - 1 && c == m - 1) 
                return dist[r][c] < health;

            for(int[] d : dir) {
                int dr = r + d[0];
                int dc = c + d[1];

                if(dr < 0 || dr >= n || dc < 0 || dc >= m) continue;
                int w = grid.get(dr).get(dc);

                if(dist[r][c] + w < dist[dr][dc]) {
                    dist[dr][dc] = dist[r][c] + w;

                    if(w == 0) dq.addFirst(new int[]{dr, dc});
                    else dq.addLast(new int[]{dr, dc});
                }
            }
        }

        return dist[n - 1][m - 1] < health;
    }
}