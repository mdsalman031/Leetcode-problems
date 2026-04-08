class Solution {
    private boolean check(int[][] graph, int[] color, int start, int V) {
        color[start] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()) {
            int node = q.poll();
            for(int adjNode : graph[node]) {
                if(color[adjNode] == -1) {
                    color[adjNode] = 1 - color[node];
                    q.add(adjNode);
                } else if(color[adjNode] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];

        for(int i = 0 ; i < V ; i++) color[i] = -1;

        for(int i = 0 ; i < V ; i++) {
            if(color[i] == -1) {
                if(check(graph, color, i, V) == false) return false;
            }
        }

        return true;
    }
}