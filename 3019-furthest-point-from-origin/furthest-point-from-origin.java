class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int n = moves.length();
        int leftCount = 0, rightCount = 0;
        
        for(int i = 0 ; i < n ; i++) {
            char direction = moves.charAt(i);
            if(direction == 'L') leftCount++;
            else if(direction == 'R') rightCount++;
        }

        int dist = 0;
        boolean isLeftMax = (leftCount > rightCount) ? true : false;
        for(int i = 0 ; i < n ; i++) {
            char direction = moves.charAt(i);
            if(direction == 'L') dist--;
            else if(direction == 'R') dist++;
            else {
                if(isLeftMax) dist--;
                else dist++;
            }
        }

        return Math.abs(dist);
    }
}