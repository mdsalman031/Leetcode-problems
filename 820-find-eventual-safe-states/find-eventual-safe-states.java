class Solution {
    public List<Integer> eventualSafeNodes(int[][] adj) {
        int V = adj.length;
        List<List<Integer>> adjRev = new ArrayList<>();
        for(int i = 0 ; i < V ; i++) adjRev.add(new ArrayList<>());
        int[] indegree = new int[V];

        for(int i = 0 ; i < V ; i++) {
            for(int adjNode : adj[i]) {
                adjRev.get(adjNode).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < V ; i++) {
            if(indegree[i] == 0) q.add(i);
        }

        List<Integer> safeNodes = new ArrayList<>();
        while(!q.isEmpty()) {
            int node = q.poll();
            safeNodes.add(node);
            for(int adjNode : adjRev.get(node)) {
                indegree[adjNode]--;
                if(indegree[adjNode] == 0) q.add(adjNode);
            }
        }
        Collections.sort(safeNodes);

        return safeNodes;
    }
}