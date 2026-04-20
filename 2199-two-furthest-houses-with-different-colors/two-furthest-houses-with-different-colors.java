class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int maxDist = 0;

        int left = 0, right = n - 1;
        while(right > 0 && colors[right] == colors[left]) right--;
        maxDist = Math.max(maxDist, Math.abs(left - right));

        left = 0;
        right = n - 1;
        while(left < n && colors[left] == colors[right]) left++;
        maxDist = Math.max(maxDist, Math.abs(left - right));

        return maxDist;
    }
}