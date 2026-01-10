class Solution {
    private boolean dfs(int[][] graph, boolean[] visited, boolean[] pathVisited, boolean[] check, int node) {
        visited[node] = true;
        pathVisited[node] = true;

        for(int adjacent : graph[node]) {
            if(!visited[adjacent]) {
                if(dfs(graph, visited, pathVisited, check, adjacent)) {
                    return true;
                }
            }
            else if(pathVisited[adjacent]) {
                return true;
            }
        }

        pathVisited[node] = false;
        check[node] = true; // safe node

        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];
        boolean[] check = new boolean[V];

        for(int i = 0 ; i < V ; i++) {
            if(!visited[i]) {
                dfs(graph, visited, pathVisited, check, i);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        for(int i = 0 ; i < V ; i++) {
            if(check[i]) safeNodes.add(i);
        }

        return safeNodes;
    }
}