class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();

        int index = 0;
        while(index < n) {
            char ch = s.charAt(index);
            if(ch == '(' || ch == '[' || ch == '{') st.push(ch);
            else {
                char top = !st.isEmpty() ? st.pop() : '0';
                if(ch == ')' && top != '(' ||
                    ch == '}' && top != '{' ||
                    ch == ']' && top != '[') return false;
            }
            index++;
        }

        return st.isEmpty();
    }
}