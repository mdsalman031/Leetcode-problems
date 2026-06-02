class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;
        int ans = Integer.MAX_VALUE;

        int earlyLandEnding = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++) 
            earlyLandEnding = Math.min(earlyLandEnding, landStartTime[i] + landDuration[i]);
        
        for(int j = 0 ; j < m ; j++) {
            int actualStart = Math.max(earlyLandEnding, waterStartTime[j]);
            ans = Math.min(ans, actualStart + waterDuration[j]);
        }

        int earlyWaterEnding = Integer.MAX_VALUE;
        for(int j = 0 ; j < m ; j++) 
            earlyWaterEnding = Math.min(earlyWaterEnding, waterStartTime[j] + waterDuration[j]);

        for(int i = 0 ; i < n ; i++) {
            int actualStart = Math.max(earlyWaterEnding, landStartTime[i]);
            ans = Math.min(ans, actualStart + landDuration[i]);
        }

        return ans;
    }
}