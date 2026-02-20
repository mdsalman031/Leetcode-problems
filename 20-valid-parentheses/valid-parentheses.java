class Solution {
    public boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        int n = str.length();
        for(int i = 0 ; i < n ; i++) {
            char ch = str.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{') stack.push(ch);
            else {
                if(!stack.isEmpty()) {
                    if(ch == ')' && stack.peek() != '(' ||
                        ch == ']' && stack.peek() != '[' ||
                        ch == '}' && stack.peek() != '{') return false; 
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty() ? true : false;
    }
}