class Solution {
    private int gcd(int a, int b) {
        if(b == 0) return a;

        return gcd(b, a % b);
    }
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = 0, odd = 1;
        int sumEven = 0, even = 2;

        for(int i = 0 ; i < n ; i++) {
            sumOdd += odd;
            odd += 2;
            sumEven += even;
            even += 2;
        }

        return gcd(sumOdd, sumEven);
    }
}