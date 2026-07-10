class Solution {
    public int maxDistinct(String s) {
        int[] hash = new int[26];
        int count = 0;
        
        for(char ch : s.toCharArray()) {
            int idx = ch - 'a';
            if(hash[idx] == 0) count++;
            hash[idx]++;
        }

        return count;
    }
}