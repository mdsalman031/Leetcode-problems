class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == divisor) return 1;

        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        int ans = 0;

        while(n >= d) {
            int count = 0;
            while(n >= (d << (count + 1))) {
                count++;
            }
            ans += (1 << count);
            n = n - (d << count);
        }

        if(ans == (1 << 31) && sign == 1) return Integer.MAX_VALUE;
        if(ans == (1 << 31) && sign == -1) return Integer.MIN_VALUE;

        return (sign == 1) ? ans : (-1 * ans);
    }
}