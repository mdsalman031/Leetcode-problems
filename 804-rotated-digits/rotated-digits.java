class Solution {
    public int rotatedDigits(int n) {
        int totalValid = 0;

        for(int i = 1 ; i <= n ; i++) {
            int num = i;
            boolean hasChangingDigit = false;
            while(num > 0) {
                int rem = num % 10;
                if(rem == 3 || rem == 4 || rem == 7) {
                    hasChangingDigit = false;
                    break;
                }
                if(rem == 2 || rem == 5 || rem == 6 || rem == 9) {
                    hasChangingDigit = true;
                } 
                num /= 10;
            }
            if(hasChangingDigit) totalValid++;
        }

        return totalValid;
    }
}