class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        if(k > n) return false;

        int total = 1 << k; // 2 ^ k
        int count = 0, code = 0;
        boolean[] seen = new boolean[total];

        for(int i = 0 ; i < n ; i++) {
            code = ((code << 1) & (total - 1)) | (s.charAt(i) - '0');

            if(i >= k - 1) {
                if(!seen[code]) {
                    seen[code] = true;
                    count++;
                    if(count == total) return true;
                }
            }
        }

        return false;
    }
}