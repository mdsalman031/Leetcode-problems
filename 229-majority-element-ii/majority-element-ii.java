class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = Integer.MIN_VALUE, candidate2 = Integer.MIN_VALUE; 
        int count1 = 0, count2 = 0;
        List<Integer> result = new ArrayList<>();

        for(int num : nums) {
            if(count1 == 0 && num != candidate2) {
                count1++;
                candidate1 = num;
            } else if(count2 == 0 && num != candidate1) {
                count2++;
                candidate2 = num;
            } else if(num == candidate1) {
                count1++;
            } else if(num == candidate2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        int min = nums.length / 3;
        count1 = 0;
        count2 = 0;

        for(int num : nums) {
            if(num == candidate1) count1++;
            if(num == candidate2) count2++;
        }

        if(count1 > min) result.add(candidate1);
        if(count2 > min) result.add(candidate2);

        return result;
    }
}