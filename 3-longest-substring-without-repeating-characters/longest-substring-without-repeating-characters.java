class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0, left = 0, right = 0;

        while(right < n) {
            char ch = s.charAt(right);
            if(map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }
            maxLen = Math.max(maxLen, right - left + 1);
            map.put(ch, right);
            right++;
        }

        return maxLen;
    }
}