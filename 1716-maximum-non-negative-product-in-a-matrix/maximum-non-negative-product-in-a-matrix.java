class Solution {
    static final int MOD = 1000000007;
    public int maxProductPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long[][] maxDp = new long[n][m];
        long[][] minDp = new long[n][m];

        maxDp[0][0] = minDp[0][0] = grid[0][0];
        for(int i=1; i<n; i++) maxDp[i][0] = minDp[i][0] = minDp[i-1][0]*grid[i][0];
        for(int j=1; j<m; j++) maxDp[0][j] = minDp[0][j] = minDp[0][j-1]*grid[0][j];

        for(int i=1; i<n; i++) {
            for(int j=1; j<m; j++) {
                long val = grid[i][j];
                long maxTop = Math.max(maxDp[i-1][j]*val, minDp[i-1][j]*val);
                long maxLeft = Math.max(maxDp[i][j-1]*val, minDp[i][j-1]*val);
                
                long minTop = Math.min(maxDp[i-1][j]*val, minDp[i-1][j]*val);
                long minLeft = Math.min(maxDp[i][j-1]*val, minDp[i][j-1]*val);

                maxDp[i][j] = Math.max(maxLeft, maxTop);
                minDp[i][j] = Math.min(minLeft, minTop);
            }
            
        }
        long res = maxDp[n-1][m-1];  
        return res < 0 ? -1 : (int)(res % MOD);
    }
}