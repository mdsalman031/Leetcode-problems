class Solution {
    private void dfs(int node, List<List<Integer>> graph, boolean[] visited, int comp, int[] components) {
        visited[node] = true;
        components[node] = comp;

        for(int neigh : graph.get(node)) {
            if(!visited[neigh]) {
                dfs(neigh, graph, visited, comp, components);
            }
        }
    }

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0 ; i < n - 1 ; i++) {
            if(nums[i + 1] - nums[i] <= maxDiff) {
                graph.get(i).add(i + 1);
                graph.get(i + 1).add(i);
            }
        }

        boolean[] visited = new boolean[n];
        int comp = 0;
        int[] components = new int[n];
        for(int i = 0 ; i < n ; i++) {
            if(!visited[i]) {
                dfs(i, graph, visited, comp, components);
                comp++;
            }
        }

        int q = queries.length;
        boolean[] ans = new boolean[q];
        for(int i = 0 ; i < q ; i++) {
            if(components[queries[i][0]] == components[queries[i][1]]) {
                ans[i] = true;
            } else {
                ans[i] = false;
            }
        }

        return ans;
    }
}