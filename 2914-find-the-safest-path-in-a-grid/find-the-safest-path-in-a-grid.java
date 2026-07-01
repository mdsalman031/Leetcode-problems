class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] A = new int[n][n];
        int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        if(grid.get(0).get(0) == 1 && grid.get(n - 1).get(n - 1) == 1) return 0;

        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < n ; j++)
                A[i][j] = grid.get(i).get(j);
        
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < n ; j++)
                if(A[i][j] == 1) q.add(new int[]{i, j});

        while(!q.isEmpty()) {
            int[] head = q.poll();
            int i = head[0];
            int j = head[1];
            int v = A[i][j];

            for(int[] d : dir) {
                int x = i + d[0];
                int y = j + d[1];

                if(x >= 0 && x < n && y >= 0 && y < n && A[x][y] == 0) {
                    A[x][y] = v + 1;
                    q.add(new int[]{x, y});
                }
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        pq.add(new int[]{A[0][0], 0, 0});

        while(!pq.isEmpty()) {
            int[] head = pq.poll();
            int sf = head[0];
            int i = head[1];
            int j = head[2];

            if(i == n - 1 && j == n - 1) return sf - 1;

            for(int[] d : dir) {
                int x = i + d[0];
                int y = j + d[1];

                if(x >= 0 && y >= 0 && x < n && y < n && A[x][y] > 0) {
                    pq.add(new int[]{Math.min(sf, A[x][y]), x, y});
                    A[x][y] *= -1;
                }
            }
        }

        return A[n - 1][n - 1] - 1;
    }
}