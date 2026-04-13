class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < numCourses ; i++) adj.add(new ArrayList<>());

        for(int i = 0 ; i < prerequisites.length ; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int V = adj.size();
        int[] indegree = new int[V];
        for(int i = 0 ; i < V ; i++) {
            for(int adjNode : adj.get(i)) {
                indegree[adjNode]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < V ; i++) {
            if(indegree[i] == 0) q.add(i);
        }

        int totalTasks = 0;
        while(!q.isEmpty()) {
            int node = q.poll();
            totalTasks++;
            for(int adjNode : adj.get(node)) {
                indegree[adjNode]--;
                if(indegree[adjNode] == 0) q.add(adjNode);
            }
        }

        return totalTasks == V;
    }
}