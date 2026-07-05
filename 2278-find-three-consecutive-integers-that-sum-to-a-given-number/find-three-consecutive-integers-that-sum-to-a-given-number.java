class Solution {
    public long[] sumOfThree(long num) {
        if(num % 3 != 0) return new long[]{};

        long temp = num / 3;
        long[] ans = new long[3];
        ans[0] = temp - 1;
        ans[1] = temp;
        ans[2] = temp + 1;

        return ans;
    }
}