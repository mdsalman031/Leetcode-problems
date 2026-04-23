class Solution {
    private long[] getPrefSum(List<Integer> indices, int size) {
        long[] res = new long[size];
        res[0] = indices.get(0);
        for(int i = 1 ; i < size ; i++) {
            res[i] += res[i - 1] + indices.get(i);
        }
        return res;
    }
    private long[] getSuffSum(List<Integer> indices, int size) {
        long[] res = new long[size];
        res[size - 1] = indices.get(size - 1);
        for(int i = size - 2 ; i >= 0 ; i--) {
            res[i] += res[i + 1] + indices.get(i);
        }
        return res;
    }
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] arr = new long[n];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0 ; i < n ; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }

        for(int key : map.keySet()) {
            int size = map.get(key).size();
            long[] prefSum = getPrefSum(map.get(key), size);
            long[] suffSum = getSuffSum(map.get(key), size);
            for(int i = 0 ; i < size ; i++) {
                // left = freq_count * cur - sum_of_left_indices
                long sumLeftIndices = (i > 0) ? prefSum[i - 1] : 0;
                long left = (long)i * map.get(key).get(i) - sumLeftIndices;
                // right = sum_of_right_indices - freq_count * cur
                long sumRightIndices = (i < size - 1) ? suffSum[i + 1] : 0;
                long right = sumRightIndices - (long)(size - i - 1) * map.get(key).get(i);
                arr[map.get(key).get(i)] = left + right;
            }
        }

        return arr;
    }
}