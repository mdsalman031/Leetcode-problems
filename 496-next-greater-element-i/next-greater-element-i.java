class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] res = new int[n1];
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < n2 ; i++) map.put(nums2[i], i);

        for(int i = n2 - 1 ; i >= 0 ; i--) {
            while(!stack.isEmpty() && stack.peek() <= nums2[i]) stack.pop();

            int nextGreater = (stack.isEmpty()) ? -1 : stack.peek();
            stack.push(nums2[i]);
            map.put(nums2[i], nextGreater);
        }

        for(int i = 0 ; i < n1 ; i++) {
            res[i] = map.get(nums1[i]);
        }

        return res;
    }
}