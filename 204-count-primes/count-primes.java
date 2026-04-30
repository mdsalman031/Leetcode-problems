class Solution {
    public int countPrimes(int n) {
        int[] seive = new int[n + 1];

        for(int i = 2 ; i*i <= n ; i++) {
            if(seive[i] == 0) {
                for(int j = i * i ; j <= n ; j += i) {
                    seive[j] = 1;
                }
            }
        }

        int count = 0;
        for(int i = 2 ; i < n ; i++) {
            if(seive[i] == 0) count++;
        }

        return count;
    }
}