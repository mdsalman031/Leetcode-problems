class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for(int ele : nums1) {
            map.put(ele, 0);
        }

        for(int ele : nums2) {
            if(map.containsKey(ele)) set.add(ele);
        }

        int[] result = new int[set.size()];
        int index = 0;
        for(int ele : set) {
            result[index++] = ele;
        }

        return result;
    }
}