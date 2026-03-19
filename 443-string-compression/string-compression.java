class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int i = 0, ptr = 0;
        while(i < n) {
            char ch = chars[i];
            int count = 0;
            while(i < n && ch == chars[i]) {
                i++;
                count++;
            }
            if(count > 1) {
                chars[ptr] = ch;
                StringBuilder sb = new StringBuilder(String.valueOf(count));
                while(sb.length() > 0) {
                    chars[++ptr] = sb.charAt(0);
                    sb.deleteCharAt(0);
                }
            } else {
                chars[ptr] = ch;
            }
            ptr++;
        }
        return ptr;
    }
}