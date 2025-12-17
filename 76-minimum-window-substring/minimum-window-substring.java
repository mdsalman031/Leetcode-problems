class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int left = 0, right = 0, count = 0, startIdx = -1, minLen = (int)1e9;
        int[] hash = new int[256];
        for(int i = 0 ; i < m ; i++) hash[t.charAt(i)]++;
        while(right < n) {
            if(hash[s.charAt(right)] > 0) count++;
            hash[s.charAt(right)]--;
            while(count == m) {
                if(right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIdx = left;
                }
                hash[s.charAt(left)]++;
                if(hash[s.charAt(left)] > 0) count--;
                left++;
            }
            right++;
        }
        return (startIdx == -1) ? "" : s.substring(startIdx, startIdx + minLen);
    }
}