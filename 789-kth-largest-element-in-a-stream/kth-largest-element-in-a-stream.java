class KthLargest {
    int K;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        K = k;
        pq = new PriorityQueue<>();
        int n = nums.length;
        for(int i = 0 ; i < n ; i++) {
            if(pq.size() < K) pq.add(nums[i]);
            else if(nums[i] > pq.peek()) {
                pq.poll();
                pq.add(nums[i]);
            }
        }
    }

    public int add(int val) {
        if(pq.size() < K) pq.add(val);
        else if(val > pq.peek()) {
            pq.poll();
            pq.add(val);
        }
        return pq.peek();
    }
}