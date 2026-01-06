class Solution {
    private void bfs(List<List<Integer>> adjList, boolean[] visited, int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;

        while(!queue.isEmpty()) {
            int ele = queue.poll();

            for(int neighbour : adjList.get(ele)) {
                if(!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;

        List<List<Integer>> adjList = new ArrayList<>();
        // Adjacency matrix to list
        for(int i = 0 ; i < V ; i++) {
            adjList.add(new ArrayList<Integer>());
            for(int j = 0 ; j < V ; j++) {
                if(isConnected[i][j] == 1 && i != j) {
                    adjList.get(i).add(j);
                }
            }
        }

        // BFS components
        boolean[] visited = new boolean[V];
        int components = 0;
        for(int i = 0 ; i < V ; i++) {
            if(!visited[i]) {
                bfs(adjList, visited, i);
                components++;
            }
        }

        return components;
    }
}