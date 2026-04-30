class Solution {
    private int[] getPrimes() {
        int[] seive = new int[1001];

        for(int i = 2 ; i*i <= 1000 ; i++) {
            if(seive[i] == 0) {
                for(int j = i*i ; j <= 1000 ; j += i) {
                    seive[j] = 1;
                }
            }
        }

        return seive;
    }
    public int distinctPrimeFactors(int[] nums) {
        int n = nums.length;
        int[] primes = getPrimes();
        Set<Integer> set = new HashSet<>();

        for(int i = 0 ; i < n ; i++) {
            int num = nums[i];
            for(int j = 2 ; j*j <= num ; j++) {
                while(num % j == 0 && primes[j] == 0) {
                    set.add(j);
                    num /= j;
                }
            }
            if(num > 1) set.add(num);
        }

        return set.size();
    }
}