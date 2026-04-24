class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        if(n == 0) return 0;
        int index = 0;
        boolean sign = true;

        // removing leading whitespace
        while(index < n && s.charAt(index) == ' ') index++;

        // checking the sign
        if(index < n && s.charAt(index) == '-') {
            sign = false;
            index++;
        } else if(index < n && s.charAt(index) == '+') {
            index++;
        }

        int startIdx = index;

        while(index < n && Character.isDigit(s.charAt(index))) {
            index++;
        }

        s = s.substring(startIdx, index);

        index = 0;
        // check for leading zeroes
        while(index < s.length() && s.charAt(index) == 0) index++;
        if(index == s.length()) return 0;

        long result = 0;
        while(index < s.length()) {
            int digit = s.charAt(index) - '0';
            if(sign) {
                if(result > (Integer.MAX_VALUE - digit) / 10.0)
                    return Integer.MAX_VALUE;
            } else {
                if(-result < (Integer.MIN_VALUE + digit) / 10.0)
                    return Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            index++;
        }

        return sign ? (int)result : (int)-result;
    }
}