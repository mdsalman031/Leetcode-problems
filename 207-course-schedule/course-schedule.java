class Solution {
    private boolean dfsCheck(List<List<Integer>> adj, boolean[] visited, boolean[] pathVisited, int node) {
        visited[node] = true;
        pathVisited[node] = true;

        for(int adjacent : adj.get(node)) {
            if(!visited[adjacent]) {
                if(dfsCheck(adj, visited, pathVisited, adjacent)) 
                    return true;
            }
            else if(pathVisited[adjacent])
                return true;
        }

        pathVisited[node] = false;

        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];

        for(int i = 0 ; i < numCourses ; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : prerequisites) {
            int src = edge[0];
            int dest = edge[1];
            adj.get(src).add(dest);
        }

        for(int i = 0 ; i < numCourses ; i++) {
            if(!visited[i]) {
                if(dfsCheck(adj, visited, pathVisited, i)) 
                    return false;
            }
        }
        return true;
    }
}