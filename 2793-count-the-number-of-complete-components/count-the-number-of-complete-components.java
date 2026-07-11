class Solution {
    private boolean bfs(int node, List<List<Integer>> adjList, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        int nodes = 0, degreeSum = 0;
        while(!q.isEmpty()) {
            int u = q.poll();
            nodes++;
            degreeSum += adjList.get(u).size();

            for(int v : adjList.get(u)) {
                if(!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }

        int edgeCount = degreeSum / 2;
        return edgeCount == (nodes * (nodes - 1) / 2);
    }

    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0 ; i < n ; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        int components = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0 ; i < n ; i++) {
            if(!visited[i]) {
                visited[i] = true;
                if(bfs(i, adjList, visited)) components++;
            }
        }

        return components;
    }
}