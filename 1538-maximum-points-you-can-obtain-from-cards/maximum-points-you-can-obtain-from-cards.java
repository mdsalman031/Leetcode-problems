class Solution {
    public int maxScore(int[] cardScore, int k) {
        int leftSum = 0;
        for(int i = 0 ; i < k ; i++) {
            leftSum += cardScore[i];
        }
        int maxi = leftSum;

        int rightIndex = cardScore.length - 1;
        int rightSum = 0;
        for(int leftIndex = k - 1 ; leftIndex >= 0 ; leftIndex--) {
            leftSum -= cardScore[leftIndex];
            rightSum += cardScore[rightIndex];
            maxi = Math.max(maxi, leftSum + rightSum);
            rightIndex--;
        }

        return maxi;
    }
}