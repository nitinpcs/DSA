class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] pre = new int[n];
        pre[0] = stoneValue[0];
        for(int i=1; i<n; i++) pre[i] = pre[i-1] + stoneValue[i];

        int[][] dp = new int[n][n];
        for(int[] row : dp) Arrays.fill(row, -1);
        
        return maxScore(pre, 0, n-1, stoneValue, dp);
    }

    int maxScore(int[] pre, int i,  int j, int[] stoneValue, int[][] dp) {
        if(i >= j) return 0;
        if(j-i == 1) return Math.min(stoneValue[i], stoneValue[j]);
        if(dp[i][j] != -1) return dp[i][j];
        int ans = 0;
        for(int k=i; k<j; k++) {
            int left = pre[k] - (i==0 ? 0 : pre[i-1]);
            int right = pre[j] - pre[k];
            if(left > right) {
                ans = Math.max(ans, maxScore(pre, k+1, j, stoneValue, dp) + right);
            }
            else if(left < right) {
                ans = Math.max(ans, maxScore(pre, i, k, stoneValue, dp) + left);
            }
            else {
                ans = Math.max(
                    maxScore(pre, i, k, stoneValue, dp), maxScore(pre, k+1, j, stoneValue, dp)
                ) + left;
            }
        }
        return dp[i][j] = ans;
    }
}