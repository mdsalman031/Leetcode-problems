class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int left = 0, right = 0, maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while(right < n) {
            int item = fruits[right];
            map.put(item, map.getOrDefault(item, 0) + 1);
            while(map.size() > 2) {
                int leftItem = fruits[left];
                map.put(leftItem, map.get(leftItem) - 1);
                if(map.get(leftItem) == 0) map.remove(leftItem);
                left++;
            } 
            maxLen = Math.max(maxLen, right - left + 1);
            
            right++;
        }
        return maxLen;
    }
}