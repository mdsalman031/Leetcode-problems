class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == divisor) return 1;

        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        if(divisor == 1) return dividend;

        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        long sum = 0;
        int count = 0;
        while(sum + b <= a) {
            count++;
            sum += b;
        }

        return sign*count;
    }
}