class Solution {
    public int[] separateDigits(int[] nums) {
        int n = nums.length;
        List<Integer> temp = new ArrayList<>();

        for(int i = 0 ; i < n ; i++) {
            String num = Integer.toString(nums[i]);
            int index = 0;
            while(index < num.length()) {
                int digit = num.charAt(index) - '0';
                temp.add(digit);
                index++;
            }
        }

        int[] seperated = new int[temp.size()];
        for(int i = 0 ; i < temp.size() ; i++) {
            seperated[i] = temp.get(i);
        }

        return seperated;
    }
}