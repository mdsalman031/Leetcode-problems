class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        int q = queries.length;
        int d = dictionary.length;
        int wordLength = queries[0].length();
        List<String> ans = new ArrayList<>();

        for(int i = 0 ; i < q ; i++) {
            String cur = queries[i];
            for(int j = 0 ; j < d ; j++) {
                String dictWord = dictionary[j];
                int cnt = 0;
                for(int ptr = 0 ; ptr < wordLength ; ptr++) {
                    if(cur.charAt(ptr) == dictWord.charAt(ptr)) cnt++;
                }
                if(cnt >= wordLength - 2) {
                    ans.add(queries[i]);
                    break;
                } 
            }
        }

        return ans;
    }
}