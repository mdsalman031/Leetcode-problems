class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Using topological sort to determine a schedule of courses
        // If the schedule (linear ordering) contains all the courses, then return true otherwise false
        // Using Kahn's algorithm to find topo sort

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < numCourses ; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : prerequisites) {
            int src = edge[0];
            int dest = edge[1];
            adj.get(src).add(dest);
        }

        // Step 1 : Store all indegrees
        int[] indegree = new int[numCourses];
        for(int i = 0 ; i < numCourses ; i++) {
            for(int adjacent : adj.get(i)) {
                indegree[adjacent]++;
            }
        }

        // Step 2 : Enqueue all the nodes with indegree 0
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < numCourses ; i++) {
            if(indegree[i] == 0) q.add(i);
        }

        // Step 3 : Pop the queue and store element in topo, and if its adjacent nodes have indegree 0 push them to queue
        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);

            for(int adjacent : adj.get(node)) {
                indegree[adjacent]--;
                if(indegree[adjacent] == 0) q.add(adjacent);
            }
        }

        return (topo.size() == numCourses) ? true : false;
    }
}