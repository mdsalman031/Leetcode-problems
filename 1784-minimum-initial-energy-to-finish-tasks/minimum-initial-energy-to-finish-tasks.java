class Solution {
    public int minimumEffort(int[][] tasks) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(b[1] - b[0]) - (a[1] - a[0]));

        for(int[] task : tasks) {
            pq.add(task);
        }

        int ans = 0;
        int enerygyLeft = 0;
        while(!pq.isEmpty()) {
            int[] task = pq.poll();
            ans += (enerygyLeft < task[1]) ? task[1] - enerygyLeft : 0;
            enerygyLeft = (enerygyLeft < task[1]) ? task[1] - task[0] : enerygyLeft - task[0];
        }

        return ans;
    }
}