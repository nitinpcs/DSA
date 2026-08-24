class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        for(int i=1; i<n; i++) stones[i] += stones[i-1];
        int[] dp = new int[n];
        dp[n-1] = stones[n-1];
        for(int i=n-2; i>=1; i--) {
            dp[i] = Math.max(dp[i+1], stones[i] - dp[i+1]);
        }

        return dp[1];
    }
}