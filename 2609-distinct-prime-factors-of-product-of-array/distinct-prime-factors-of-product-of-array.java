class Solution {
    private int[] smallestPrimeFactor() {
        int max = (int)1e5;
        int[] spf = new int[max + 1];
        for(int i = 2 ; i <= max ; i++) spf[i] = i;

        for(int i = 2 ; i*i <= max ; i++) {
            if(spf[i] == i) {
                for(int j = i*i ; j <= max ; j += i) {
                    if(spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }

        return spf;
    }
    public int distinctPrimeFactors(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int[] spf = smallestPrimeFactor();

        for(int i = 0 ; i < n ; i++) {
            int num = nums[i];
            while(num != 1) {
                set.add(spf[num]);
                num /= spf[num];
            }
        }

        return set.size();
    }
}