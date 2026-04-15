class Pair {
    String word;
    int step;
    Pair(String word, int step) {
        this.word = word;
        this.step = step;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        Set<String> set = new HashSet<>();
        for(int i = 0 ; i < n ; i++) {
            set.add(wordList.get(i));
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        set.remove(beginWord);

        while(!q.isEmpty()) {
            String word = q.peek().word;
            int step = q.peek().step;
            q.poll();
            if(word.equals(endWord)) return step;
            for(int i = 0 ; i < word.length() ; i++) {
                for(char ch = 'a' ; ch <= 'z' ; ch++) {
                    char[] wordArray = word.toCharArray();
                    wordArray[i] = ch;
                    String transformed = new String(wordArray);
                    if(set.contains(transformed)) {
                        set.remove(transformed);
                        q.add(new Pair(transformed, step + 1));
                    }
                }
            }
        }

        return 0;
    }
}