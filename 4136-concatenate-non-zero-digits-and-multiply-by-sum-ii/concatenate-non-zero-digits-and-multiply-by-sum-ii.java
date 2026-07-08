class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        int q = queries.length;
        int mod = (int) 1e9 + 7;
        int[] ans = new int[q];

        long[] prefixSum = new long[n + 1];
        long[] prefixProduct = new long[n + 1];
        int[] cnt = new int[n + 1];
        long[] pow10 = new long[n + 1];
        pow10[0] = 1;
        for (int i = 1; i <= n; i++) pow10[i] = pow10[i - 1] * 10 % mod;

        for(int i = 1 ; i <= n ; i++) {
            int digit = s.charAt(i - 1) - '0';

            prefixSum[i] = prefixSum[i - 1] + digit;

            if (digit > 0) {
                prefixProduct[i] = (prefixProduct[i - 1] * 10 + digit) % mod;
                cnt[i] = cnt[i - 1] + 1;
            } else {
                prefixProduct[i] = prefixProduct[i - 1];
                cnt[i] = cnt[i - 1];
            }
        }

        for(int i = 0 ; i < q ; i++) {
            int l = queries[i][0] + 1;
            int r = queries[i][1] + 1;

            long sum = prefixSum[r] - prefixSum[l - 1];

            int shift = cnt[r] - cnt[l - 1];
            long x = (prefixProduct[r] - prefixProduct[l - 1] * pow10[shift]) % mod;
            if (x < 0) x += mod;

            ans[i] = (int) (x * (sum % mod) % mod);
        }

        return ans;
    }
}