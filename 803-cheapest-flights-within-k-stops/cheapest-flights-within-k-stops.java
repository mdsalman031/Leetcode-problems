class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) graph.add(new ArrayList<>());

        for(int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            graph.get(from).add(new int[]{to, price});
        }

        int[] dist = new int[n];
        for(int i = 0 ; i < n ; i++) {
            dist[i] = (int)1e9;
        }
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0, src, 0});

        int cheapestFlight = Integer.MAX_VALUE;

        while(!pq.isEmpty()) {
            int step = pq.peek()[0];
            int node = pq.peek()[1];
            int cost = pq.peek()[2];
            pq.poll();

            if(node == dst) {
                cheapestFlight = Math.min(cheapestFlight, cost);
            }

            for(int i = 0 ; i < graph.get(node).size() ; i++) {
                int adjNode = graph.get(node).get(i)[0];
                int adjPrice = graph.get(node).get(i)[1];

                if(step <= k && cost + adjPrice < dist[adjNode]) {
                    dist[adjNode] = cost + adjPrice;
                    pq.add(new int[]{step + 1, adjNode, dist[adjNode]});
                }
            }
        }

        return cheapestFlight != Integer.MAX_VALUE ? cheapestFlight : -1;
    }
}