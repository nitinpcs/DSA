class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int MOD = 1000000007;

        int[][][] dp = new int[n][m][k];
        dp[0][0][grid[0][0]%k] = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for(int mod = 0; mod < k; mod++) {
                    int curr = dp[i][j][mod];
                    if(curr == 0) continue;

                    if(i+1 < n) {
                        int newMod = (grid[i+1][j] + mod) % k;
                        dp[i+1][j][newMod] = (dp[i+1][j][newMod] + curr) % MOD;
                    }
                    if(j+1 < m) {
                        int newMod = (grid[i][j+1] + mod) % k;
                        dp[i][j+1][newMod] = (dp[i][j+1][newMod] + curr) % MOD;
                    }
                }
            }
        }

        return dp[n-1][m-1][0];
    }
}