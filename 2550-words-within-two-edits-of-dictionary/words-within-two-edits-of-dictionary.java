class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();

        for(String query : queries) {
            for(String word : dictionary) {
                int maxDiff = 2;
                for(int i = 0 ; i < word.length() ; i++) {
                    if(query.charAt(i) != word.charAt(i)) maxDiff--;
                }
                if(maxDiff >= 0) {
                    ans.add(query);
                    break;
                }
            }
        }

        return ans;
    }
}