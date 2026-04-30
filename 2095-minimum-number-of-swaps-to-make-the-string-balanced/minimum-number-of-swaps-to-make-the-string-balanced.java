class Solution {
    public int minSwaps(String s) {
        int n = s.length();
        int opening = 0, closing = 0;

        for(int i = 0 ; i < n ; i++) {
            char ch = s.charAt(i);
            if(ch == '[') opening++;
            else if(ch == ']' && opening > 0) opening--;
            else closing++;
        }

        return ((opening/2) + (opening % 2) + (closing / 2) + (closing % 2)) / 2;
    }
}