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

            chars[ptr++] = ch;

            if(count > 1) {
                String countStr = String.valueOf(count);
                for(char num : countStr.toCharArray()) {
                    chars[ptr++] = num;
                }
            } 
        }
        return ptr;
    }
}