class Solution {
    public boolean rotateString(String s, String goal) {
        int n = s.length();

        for(int i = 0 ; i < n ; i++) {
            String part1 = (i > 0) ? s.substring(0, i) : "";
            String part2 = s.substring(i, n);
            if((part2 + part1).equals(goal)) return true;
        }

        return false;
    }
}