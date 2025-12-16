class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 0) return 0;
        int[] hash = new int[256];
        Arrays.fill(hash, -1);
        int left = 0, right = 0, maxLen = 0;
        while(right < n) {
            char item = s.charAt(right);
            if(hash[item] != -1 && hash[item] >= left) {
                left = hash[item] + 1;
            } 
            maxLen = Math.max(maxLen, right - left + 1);
            hash[item] = right;
            right++;
        }
        return maxLen;
    }
}