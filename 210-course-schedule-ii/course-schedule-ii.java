class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < numCourses ; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : prerequisites) {
            int dest = edge[0];
            int src = edge[1];
            adj.get(src).add(dest);
        }

        int[] indegree = new int[numCourses];
        for(int i = 0 ; i < numCourses ; i++) {
            for(int adjacent : adj.get(i)) {
                indegree[adjacent]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < numCourses ; i++) {
            if(indegree[i] == 0) q.add(i);
        }

        int[] courseOrder = new int[numCourses];
        int idx = 0;
        while(!q.isEmpty()) {
            int node = q.poll();
            courseOrder[idx++] = node;

            for(int adjacent : adj.get(node)) {
                indegree[adjacent]--;
                if(indegree[adjacent] == 0) q.add(adjacent);
            }
        }

        if(idx != numCourses) return new int[]{};

        return courseOrder;
    }
}