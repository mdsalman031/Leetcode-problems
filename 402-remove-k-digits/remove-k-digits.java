class Solution {
    public String removeKdigits(String nums, int k) {
        int n = nums.length();
        Stack<Character> stack = new Stack<>();

        for(int i = 0 ; i < n ; i++) {
                while(!stack.isEmpty() && k > 0 && ((stack.peek() - '0') > (nums.charAt(i) - '0'))) {
                stack.pop();
                k--;
            }
            stack.push(nums.charAt(i));
        }

        while(k-- > 0) stack.pop();

        if(stack.isEmpty()) return "0";

        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()) res.append(stack.pop());

        while(res.length() > 0 && res.charAt(res.length() - 1) == '0') {
            res.deleteCharAt(res.length() - 1);
        }

        if(res.length() == 0) return "0";

        return res.reverse().toString();
    }
}