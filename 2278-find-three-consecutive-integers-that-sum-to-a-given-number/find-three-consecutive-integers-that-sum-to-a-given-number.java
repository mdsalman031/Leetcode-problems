class Solution {
    public long[] sumOfThree(long num) {
        long temp = (long) Math.ceil((double)num / 3);
        long a = temp - 1, b = temp, c = temp + 1;
        
        return (a + b + c) == num ? new long[]{a, b, c} : new long[]{};
    }
}