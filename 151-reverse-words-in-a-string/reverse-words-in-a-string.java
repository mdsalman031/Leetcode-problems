class Solution {
    public String reverseWords(String s) {
        s = s.trim();

        String[] arr = s.split("\\s+");

        int n = arr.length;
        int left = 0, right = n - 1;
        while(left < right) {
            String temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        StringBuilder sb = new StringBuilder();
        for(String word : arr) {
            sb.append(word).append(' ');
        }

        return sb.toString().trim();
    }
}