class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int count1 = 0, count2 = 0;
        int candidate1 = Integer.MIN_VALUE, candidate2 = Integer.MIN_VALUE;

        for(int i = 0 ; i < n ; i++) {
            if(count1 == 0 && nums[i] != candidate2) {
                count1 = 1;
                candidate1 = nums[i];
            } else if(count2 == 0 && nums[i] != candidate1) {
                count2 = 1;
                candidate2 = nums[i];
            } else if(nums[i] == candidate1) {
                count1++;
            } else if(nums[i] == candidate2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        List<Integer> list = new ArrayList<>();
        int min = (n / 3) + 1;
        count1 = 0;
        count2 = 0;
        for(int i = 0 ; i < n ; i++) {
            if(nums[i] == candidate1) count1++;
            if(nums[i] == candidate2) count2++;
        }
        if(count1 >= min) list.add(candidate1);
        if(count2 >= min) list.add(candidate2);

        return list;
    }
}