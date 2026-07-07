class FreqMap {
    int freq, letter;
    FreqMap(int freq, int letter) {
        this.freq = freq;
        this.letter = letter;
    }
}

class Solution {
    public String frequencySort(String s) {
        FreqMap[] map = new FreqMap[128];

        for(int i = 0 ; i < 128 ; i++) {
            map[i] = new FreqMap(0, (char) i);
        }

        for(int i = 0 ; i < s.length() ; i++) {
            map[s.charAt(i)].freq++;
        }

        Arrays.sort(map, (a, b) -> {
            if(a.freq != b.freq) {
                return Integer.compare(b.freq, a.freq);
            }
            return 0;
        });

        StringBuilder ans = new StringBuilder();
        for(int i = 0 ; i < 128 ; i++) {
            if(map[i].freq == 0) break;
            int range = map[i].freq;
            char ch = (char) map[i].letter;
            while(range-- > 0) {
                ans.append(ch);
            }
        }

        return ans.toString();
    }
}