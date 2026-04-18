class Pair {
    long time;
    int node;
    Pair(long time, int node) {
        this.time = time;
        this.node = node;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = (int) (1e9 + 7);
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) graph.add(new ArrayList<>());

        for(int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int time = road[2];
            graph.get(u).add(new int[]{v, time});
            graph.get(v).add(new int[]{u, time});
        }

        long[] dist = new long[n];
        int[] ways = new int[n];

        for(int i = 0 ; i < n ; i++) dist[i] = Long.MAX_VALUE;

        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Long.compare(a.time,b.time));
        pq.add(new Pair(0, 0));

        while(!pq.isEmpty()) {
            long time = pq.peek().time;
            int node = pq.peek().node;
            pq.poll();

            if(time > dist[node]) continue;

            for(int[] edge : graph.get(node)) {
                int adjNode = edge[0];
                int adjTime = edge[1];

                if(time + adjTime < dist[adjNode]) {
                    dist[adjNode] = time + adjTime;
                    pq.add(new Pair(dist[adjNode], adjNode));
                    ways[adjNode] = ways[node];
                } else if(time + adjTime == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % MOD;
                }
            }
        }

        return ways[n-1] % MOD;
    }
}