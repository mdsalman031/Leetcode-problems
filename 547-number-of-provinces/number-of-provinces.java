class Solution {
    private void bfs(int[][] adj, boolean[] visited, int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;

        while(!queue.isEmpty()) {
            int ele = queue.poll();

            for(int neighbour = 0 ; neighbour < adj.length ; neighbour++) {
                if(adj[ele][neighbour] == 1 && !visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;

        // BFS components
        boolean[] visited = new boolean[V];
        int components = 0;
        for(int i = 0 ; i < V ; i++) {
            if(!visited[i]) {
                bfs(isConnected, visited, i);
                components++;
            }
        }

        return components;
    }
}