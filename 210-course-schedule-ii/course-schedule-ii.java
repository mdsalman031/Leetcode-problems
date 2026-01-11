class Solution {
    private boolean dfsCheck(List<List<Integer>> adj, boolean[] visited, boolean[] pathVisited, Stack<Integer> stack, int node) {
        visited[node] = true;
        pathVisited[node] = true;

        for(int adjacent : adj.get(node)) {
            if(!visited[adjacent]) {
                if(dfsCheck(adj, visited, pathVisited, stack, adjacent))
                    return true;
            }
            else if(pathVisited[adjacent]) 
                return true;
        }

        pathVisited[node] = false;
        stack.push(node);
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < numCourses ; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : prerequisites) {
            int dest = edge[0];
            int src = edge[1];
            adj.get(src).add(dest);
        }

        for(int i = 0 ; i < numCourses ; i++) {
            if(!visited[i])
                if(dfsCheck(adj, visited, pathVisited, stack, i))
                    return new int[]{};
        }

        int[] courseOder = new int[numCourses];
        int idx = 0;
        while(!stack.isEmpty()) courseOder[idx++] = stack.pop();

        return courseOder;
    }
}