class Solution {
    public int characterReplacement(String s, int k) {
        // Number of(Characters needs to changed) = len(string) - maxFreq
        int n = s.length();
        int left = 0, right = 0, maxFreq = 0, maxLen = 0;
        int[] hash = new int[26];
        while(right < n) {
            int item = s.charAt(right) - 'A';
            hash[item]++;
            maxFreq = Math.max(maxFreq, hash[item]);
            if((right - left + 1) - maxFreq > k) {
                hash[s.charAt(left) - 'A']--;
                left++;
                for(int num : hash) maxFreq = Math.max(maxFreq, num);
            } else {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
        }
        return maxLen;
    }
}