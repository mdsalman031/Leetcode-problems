class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int zeros = 0, ones = 0, twos = 0;

        for(int i = 0 ; i < n ; i++) {
            if(nums[i] == 0) zeros++;
            else if(nums[i] == 1) ones++;
            else twos++;
        } 

        int index = 0;
        while(zeros-- > 0) {
            nums[index++] = 0;
        }

        while(ones-- > 0) {
            nums[index++] = 1;
        }

        while(twos-- > 0) {
            nums[index++] = 2;
        }
    }
}