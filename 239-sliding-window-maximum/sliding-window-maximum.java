class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[n - k + 1];
        int idx = 0;

        for(int i = 0 ; i < n ; i++) {
            while(!dq.isEmpty() && dq.getFirst() <= i - k) {
                dq.removeFirst();
            }
            while(!dq.isEmpty() && arr[dq.getLast()] <= arr[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
            if(i >= k - 1) ans[idx++] = arr[dq.getFirst()];
        }
        
        return ans;
    }
}