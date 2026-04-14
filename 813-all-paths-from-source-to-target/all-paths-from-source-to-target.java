class Solution {
    private void dfs(List<List<Integer>> adj, List<Integer> path, List<List<Integer>> res, int node, int goal) {
        path.add(node);
        if(node == goal) {
            res.add(new ArrayList<>(path));
        }
    
        for(int adjNode : adj.get(node)) {
            dfs(adj, path, res, adjNode, goal);
        }

        path.remove(path.size() - 1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int V = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < V ; i++) adj.add(new ArrayList<>());

        for(int i = 0 ; i < V ; i++) {
            for(int j = 0 ; j < graph[i].length ; j++) {
                adj.get(i).add(graph[i][j]);
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(adj, path, res, 0, V - 1);

        return res;
    }
}