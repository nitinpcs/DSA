class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        for(int i=1; i<n; i++) stones[i] += stones[i-1];
        Integer[] dp = new Integer[n];
        
        return getDiff(1, stones, dp);
    }

    int getDiff(int i, int[] stones, Integer[] dp) {
        if(i == stones.length-1) return stones[stones.length - 1];
        if(dp[i] != null) return dp[i];
        
        int pick = stones[i] - getDiff(i+1, stones, dp);
        int notpick = getDiff(i+1, stones, dp);

        return dp[i] = Math.max(pick, notpick);
    }
}