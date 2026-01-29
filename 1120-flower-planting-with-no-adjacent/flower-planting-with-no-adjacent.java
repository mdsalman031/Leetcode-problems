class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] colours = new int[n];

        for(int i = 0 ; i < n ; i++) adj.add(new ArrayList<>());

        for(int[] edge : paths) {
            int u = edge[0] - 1;
            int v = edge[1] - 1; // 0-based indexing 
            adj.get(u).add(v);
            adj.get(v).add(u); 
        }

        for(int node = 0 ; node < n ; node++) {
            boolean[] used = new boolean[5]; // 1..4 colours
            for(int neighbour : adj.get(node)) {
                used[colours[neighbour]] = true;
            }
            for(int c = 1 ; c <= 4 ; c++) {
                if(!used[c]) {
                    colours[node] = c;
                    break;
                }
            }
        }

        return colours;
    }
}