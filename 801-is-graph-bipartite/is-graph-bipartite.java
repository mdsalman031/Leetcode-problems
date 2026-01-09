// Equivalent definitions of a bipartite graph:

// There is no cycle of odd length

// we can split the nodes of the graph
// (vertex set of the graph) into 2 subsets so
// that there is all the edges go from 1 subset
// to the other subset.

// 3.The graph should be bi-colourable.
class Solution {
    private boolean colorGraph(int[][] graph, int numNodes, int[] color, int start) {
        color[start] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()) {
            int node = q.poll();

            for(int adjacent : graph[node]) {
                if(color[adjacent] == -1) {
                    color[adjacent] = 1 - color[node];
                    q.add(adjacent);
                } else if(color[adjacent] == color[node]) {
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
                if(!colorGraph(graph, V, color, i)) return false;
            }
        }

        return true;
    }
}