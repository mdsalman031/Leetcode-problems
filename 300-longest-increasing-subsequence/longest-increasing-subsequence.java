class Solution {
    private int lowerBound(List<Integer> list, int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(list.get(mid) >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<Integer>();

        list.add(nums[0]);
        for(int i = 1 ; i < n ; i++) {
            if(nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
            } else {
                int pos = lowerBound(list, 0, list.size() - 1, nums[i]);
                list.set(pos, nums[i]);
            }
        }

        return list.size();
    }
}

// ***Recursion solution - Runtime error***

// class Solution {
//     private int helper(int[] nums, int cur, int prev, int n) {
//         if(cur == n) return 0;

//         int notTaken = 0 + helper(nums, cur + 1, prev, n);
//         int taken = 0;
//         if(prev == -1 || nums[cur] > nums[prev]) taken = 1 + helper(nums, cur + 1, cur, n);

//         return Math.max(taken, notTaken);
//     }
//     public int LIS(int[] nums) {
//         return helper(nums, 0, -1, nums.length);
//     }
// }

// ***Memoization - Runtime error***

// class Solution {
//     private int helper(int[] nums, int cur, int prev, int n, int[][] dp) {
//         if(cur == n) return 0;
//         if(dp[cur][prev + 1] != -1) return dp[cur][prev + 1];

//         int notTaken = 0 + helper(nums, cur + 1, prev, n, dp);
//         int taken = 0;
//         if(prev == -1 || nums[cur] > nums[prev]) taken = 1 + helper(nums, cur + 1, cur, n, dp);

//         return dp[cur][prev + 1] = Math.max(taken, notTaken);
//     }
//     public int LIS(int[] nums) {
//         int n = nums.length;
//         int[][] dp = new int[n][n + 1];

//         for(int i = 0 ; i < n ; i++) 
//             for(int j = 0 ; j <= n ; j++)
//                 dp[i][j] = -1;

//         return helper(nums, 0, -1, n, dp);
//     }
// }

// ***Tabulation - Runtime error***

// class Solution {
//     public int LIS(int[] nums) {
//         int n = nums.length;
//         int[][] dp = new int[n + 1][n + 1];

//         for(int cur = n - 1 ; cur >= 0 ; cur--) {
//             for(int prev = cur - 1 ; prev >= -1 ; prev--) {
//                 int notTaken = dp[cur + 1][prev + 1];
//                 int taken = 0;
//                 if(prev == -1 || nums[cur] > nums[prev]) taken = 1 + dp[cur + 1][cur + 1];
//                 dp[cur][prev + 1] = Math.max(taken, notTaken);
//             }
//         }

//         return dp[0][0];
//     }
// }

// ***Space optimization - TLE***

// class Solution {
//     public int LIS(int[] nums) {
//         int n = nums.length;
//         int[] current = new int[n + 1];
//         int[] after = new int[n + 1];

//         for(int cur = n - 1 ; cur >= 0 ; cur--) {
//             for(int prev = cur - 1 ; prev >= -1 ; prev--) {
//                 int notTaken = after[prev + 1];
//                 int taken = 0;
//                 if(prev == -1 || nums[cur] > nums[prev]) taken = 1 + after[cur + 1];
//                 current[prev + 1] = Math.max(taken, notTaken);
//             }
//             int[] temp = after;
//             after = current;
//             current = temp;
//         }

//         return after[0];
//     }
// }







