class Solution {
    public int[] separateDigits(int[] nums) {
        int n = nums.length;
        List<Integer> temp = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < n ; i++) {
            int num = nums[i];
            while(num > 0) {
                stack.push(num % 10);
                num /= 10;
            }
            while(!stack.isEmpty()) {
                temp.add(stack.pop());
            }
        }

        int[] seperated = new int[temp.size()];
        for(int i = 0 ; i < temp.size() ; i++) {
            seperated[i] = temp.get(i);
        }

        return seperated;
    }
}