class Solution {
    public int maxDistinct(String s) {
        int[] hash = new int[26];

        for(char ch : s.toCharArray()) {
            hash[ch - 'a']++;
        }

        int count = 0;
        for(int i = 0 ; i < 26 ; i++) {
            if(hash[i] > 0) count++;
        }

        return count;
    }
}