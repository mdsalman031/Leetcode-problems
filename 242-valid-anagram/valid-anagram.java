class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] sMap = new int[26];
        int[] tMap = new int[26];

        for(int i = 0 ; i < s.length() ; i++) {
            int sChar = s.charAt(i) - 'a';
            int tChar = t.charAt(i) - 'a';

            sMap[sChar]++;
            tMap[tChar]++;
        }

        for(int i = 0 ; i < 26 ; i++) {
            if(sMap[i] != tMap[i]) return false;
        }

        return true;
    }
}