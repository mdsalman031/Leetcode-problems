class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int minTime = Integer.MAX_VALUE;
        int n = landStartTime.length;
        int m = waterStartTime.length;

        for(int i = 0 ; i < n ; i++) {
            int curTime = landStartTime[i] + landDuration[i];
            for(int j = 0 ; j < m ; j++) {
                if(curTime >= waterStartTime[j]) {
                    curTime += waterDuration[j];
                } else {
                    curTime = waterStartTime[j] + waterDuration[j];
                }
                minTime = Math.min(minTime, curTime);
                curTime = landStartTime[i] + landDuration[i];
            }
        }

        for(int i = 0 ; i < m ; i++) {
            int curTime = waterStartTime[i] + waterDuration[i];
            for(int j = 0 ; j < n ; j++) {
                if(curTime >= landStartTime[j]) {
                    curTime += landDuration[j];
                } else {
                    curTime = landStartTime[j] + landDuration[j];
                }
                minTime = Math.min(minTime, curTime);
                curTime = waterStartTime[i] + waterDuration[i];
            }
        }

        return minTime;
    }
}