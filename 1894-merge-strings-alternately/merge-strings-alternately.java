class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder merged = new StringBuilder();
        int n1 = word1.length(), n2 = word2.length();
        int index1 = 0, index2 = 0;
        boolean isWord1 = true;

        while(index1 < n1 && index2 < n2) {
            if(isWord1) {
                merged.append(word1.charAt(index1));
                index1++;
                isWord1 = false;
            }  else {
                merged.append(word2.charAt(index2));
                index2++;
                isWord1 = true;
            }
        }

        if(index1 < n1) {
            merged.append(word1.substring(index1, n1));
        }

        if(index2 < n2) {
            merged.append(word2.substring(index2, n2));
        }

        return merged.toString();
    }
}