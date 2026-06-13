class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder result = new StringBuilder();

        for(String word : words) {
            int sum = 0;
            for(char ch : word.toCharArray()) {
                sum += weights[ch - 'a'];
            }
            char value = (char)('z' - (sum % 26));
            result.append(value);
        }

        return result.toString();
    }
}