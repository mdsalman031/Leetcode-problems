class Solution {
    private boolean dfs(int[][] adj, boolean[] visited, boolean[] pathVisited, int[] check, int node) {
        visited[node] = true;
        pathVisited[node] = true;

        for(int adjNode : adj[node]) {
            if(!visited[adjNode]) {
                if(dfs(adj, visited, pathVisited, check, adjNode)) return true;
            } else if(pathVisited[adjNode]) {
                return true;
            }
        }
        pathVisited[node] = false;
        check[node] = 1;

        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] adj) {
        int V = adj.length;
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];
        int[] check = new int[V];

        for(int i = 0 ; i < V ; i++) {
            dfs(adj, visited, pathVisited, check, i);
        }

        List<Integer> res = new ArrayList<>();
        for(int i = 0 ; i < V ; i++) {
            if(check[i] == 1) res.add(i);
        }

        return res;
    }
}