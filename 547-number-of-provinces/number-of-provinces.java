class Solution {
    private void bfs(int[][] adj, boolean[] visited, int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()) {
            int ele = q.poll();
            visited[ele] = true;
            for(int neighbour = 0 ; neighbour < adj.length ; neighbour++) {
                if(!visited[neighbour] && adj[ele][neighbour] == 1) {
                    q.add(neighbour);
                }
            }
        }
    }
    public int findCircleNum(int[][] adj) {
        int V = adj.length;
        boolean[] visited = new boolean[V];
        int components = 0;

        for(int i = 0 ; i < V ; i++) {
            if(!visited[i]) {
                bfs(adj, visited, i);
                components++;
            }
        }

        return components;
    }
}