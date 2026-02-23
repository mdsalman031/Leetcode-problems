class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        Set<String> codes = new HashSet<>();

        if(k > n) return false;

        for(int i = 0 ; i <= n - k ; i++) {
            String sub = s.substring(i, i + k);
            codes.add(sub);
        }

        return (codes.size() == Math.pow(2, k));
    }
}