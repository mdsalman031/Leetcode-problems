class Solution {
    public int countPrimes(int n) {
        int[] primes = new int[n];

        for(int i = 2 ; i * i < n ; i++) {
            if(primes[i] == 0) {
                for(int j = 2 * i ; j < n ; j += i) {
                    primes[j] = 1;
                }
            }
        }

        int count = 0;
        for(int i = 2 ; i < n ; i++) {
            if(primes[i] == 0) count++;
        }

        return count;
    }
}