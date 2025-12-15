class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 0) return 0;
        int[] hash = new int[256];
        int maxLen = 1;
        for(int i = 0 ; i < n ; i++) {
            Arrays.fill(hash, 0);
            for(int j = i ; j < n ; j++) {
                if(hash[s.charAt(j)] == 1) break;
                maxLen = Math.max(maxLen, j - i + 1);
                hash[s.charAt(j)] = 1;
            }
        }
        return maxLen;
    }
}