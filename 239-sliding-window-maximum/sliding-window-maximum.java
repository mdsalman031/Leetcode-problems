class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        for(int i = 0 ; i < n ; i++) {
            while(!dq.isEmpty() && dq.getFirst() <= i - k) {
                dq.removeFirst();
            }
            while(!dq.isEmpty() && arr[dq.getLast()] <= arr[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
            if(i >= k - 1) res.add(arr[dq.getFirst()]);
        }
        int[] ans = new int[res.size()];
        for(int i = 0 ; i < res.size() ; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}