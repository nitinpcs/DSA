class Solution {
    static int MAX = Integer.MAX_VALUE;
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return minCost(0, costs, dp);
    }

    int minCost(int idx, int[] costs, int[] dp) {
        if(idx > costs.length) return MAX;
        if(dp[idx] != -1) return dp[idx];

        int one = MAX;
        if(idx+1 <= costs.length) {
            one = minCost(idx+1, costs, dp) + costs[idx] + 1;
        }
        int two = MAX;
        if(idx+2 <= costs.length) {
            two = minCost(idx+2, costs, dp) + costs[idx+1] + 4;
        }
        int three = MAX;
        if(idx+3 <= costs.length) {
            three = minCost(idx+3, costs, dp) + costs[idx+2] + 9;
        }
        
        dp[idx] = Math.min(one, Math.min(two, three));
        if(dp[idx] == MAX) dp[idx] = 0;
        return dp[idx];
    }
}