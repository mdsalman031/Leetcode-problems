class Solution {
    private List<Integer> getPrimes(int[] nums, int left, int right) {
        for(int i = 2 ; i * i <= right ; i++) {
            if(nums[i] == 0) {
                for(int j = i * i ; j <= right ; j += i) {
                    nums[j] = 1;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for(int i = left ; i <= right ; i++) {
            if(i == 1) continue;
            if(nums[i] == 0) primes.add(i);
        }

        return primes;
    }

    public int[] closestPrimes(int left, int right) {
        int[] nums = new int[right + 1];
        List<Integer> primes = getPrimes(nums, left, right);
        
        int minDist = Integer.MAX_VALUE;
        int[] ans = new int[2];
        ans[0] = -1; ans[1] = -1;

        for(int i = 1 ; i < primes.size() ; i++) {
            if((primes.get(i) - primes.get(i - 1)) < minDist) {
                ans[0] = primes.get(i-1);
                ans[1] = primes.get(i);
                minDist = ans[1] - ans[0];
            }  
        }

        return ans;
    }
}