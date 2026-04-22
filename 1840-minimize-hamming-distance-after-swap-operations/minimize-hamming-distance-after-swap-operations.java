class Solution {
    private List<Integer> bfs(Map<Integer, List<Integer>> srcGraph, boolean[] visited, int node) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> comp = new ArrayList<>();
        visited[node] = true;
        q.add(node);
        comp.add(node);

        while(!q.isEmpty()) {
            int ele = q.poll();
            for(int adjNode : srcGraph.get(ele)) {
                if(!visited[adjNode]) {
                    visited[adjNode] = true;
                    q.add(adjNode);
                    comp.add(adjNode);
                }
            }
        }

        return comp;
    }
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;

        Map<Integer, List<Integer>> srcGraph = new HashMap<>();
        for(int i = 0 ; i < n ; i++) srcGraph.put(i, new ArrayList<>());
        for(int[] edge : allowedSwaps) {
            int u = edge[0];
            int v = edge[1];
            srcGraph.get(u).add(v);
            srcGraph.get(v).add(u);
        }

        int answer = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0 ; i < n ; i++) {
            if(!visited[i]) {
                List<Integer> comp = bfs(srcGraph, visited, i);

                Map<Integer, Integer> srcFreq = new HashMap<>();
                for(int idx : comp) {
                    srcFreq.put(source[idx], srcFreq.getOrDefault(source[idx], 0) + 1);
                } 

                for(int idx : comp) {
                    if(srcFreq.getOrDefault(target[idx], 0) > 0) {
                        srcFreq.put(target[idx], srcFreq.get(target[idx]) - 1);
                    } else {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}