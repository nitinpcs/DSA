class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suf = new int[n];
        suf[n-1] = piles[n-1];
        for(int i=n-2; i>=0; i--) {
            suf[i] = suf[i+1] + piles[i];
        }
        int[][] dp = new int[n][n];
        return maxStones(suf, 0, 1, dp);
    }

    int maxStones(int[] suf, int idx, int maxR, int[][] dp) {
        if(idx + 2*maxR >= suf.length) return suf[idx];
        if(dp[idx][maxR] > 0) return dp[idx][maxR];

        int res = Integer.MAX_VALUE;
        for(int i=1; i<=2*maxR; i++) {
            res = Math.min(
                res, maxStones(suf, idx+i, Math.max(maxR, i), dp)
            );
        }
        return dp[idx][maxR] = suf[idx] - res;
    }
}