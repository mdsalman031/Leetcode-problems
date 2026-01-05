class Solution {
    private boolean bfs(int V, List<List<Integer>> adj, boolean[] visited, int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;

        int nodes = 0;
        int degreeSum = 0;
        while(!queue.isEmpty()) {
            int ele = queue.poll();
            nodes++;
            degreeSum += adj.get(ele).size();

            for(int neighbour : adj.get(ele)) {
                if(!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }

        // Check if the subgraph is complete
        int edgeCount = degreeSum / 2;
        if(edgeCount == nodes * (nodes - 1) / 2) return true; // formula for complete graph k*(k-1)/2
        return false;
    }
    public int countCompleteComponents(int V, int[][] edges) {
        // Step 1: Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for(int i = 0 ; i < edges.length ; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u); 
        }
        // Step 2: BFS components
        boolean[] visited = new boolean[V];
        int components = 0;
        for(int i = 0 ; i < V ; i++) {
            if(!visited[i]) {
                if(bfs(V, adj, visited, i)) {
                    components++;
                }
                
            }
        }
        return components;
    }
}