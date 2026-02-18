class Solution {
    public boolean hasAlternatingBits(int n) {
        int prev = 1 & n;
        n = n >> 1;
        while(n > 0) {
            int cur = 1 & n;
            if(prev == cur) return false;
            prev = cur;
            n = n >> 1;
        }
        return true;
    }
}