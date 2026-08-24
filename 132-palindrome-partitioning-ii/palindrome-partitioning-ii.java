class Solution {
    public int minCut(String s) {
        int n =  s.length();

        boolean[][] pal = new boolean[n][n];
        for(int i=0 ; i<n; i++) pal[i][i] = true;

        for(int len=2; len<=n; len++) {
            for(int i=0; i+len-1 < n; i++) {
                int j = i+len-1;
                pal[i][j] = s.charAt(i) == s.charAt(j) && (len == 2 || pal[i+1][j-1]); 
            }
        }

        int[][] dp = new int[n][n];
        for(int r=0; r<n; r++) Arrays.fill(dp[r], -1);

        return minCuts(0, n-1, pal, dp);
    }

    int minCuts(int i, int j, boolean[][] pal, int[][] dp) {
        if(i >= j || pal[i][j]) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int right = 0;
        int min = Integer.MAX_VALUE;
        for(int k=i; k<=j; k++) {
            if(!pal[i][k]) continue;
            if(dp[k+1][j] != -1) right = dp[k+1][j];
            else {
                right = minCuts(k+1, j, pal, dp);
                dp[k+1][j] = right;
            }

            min = Math.min(min, right+1);
        }
        return dp[i][j] = min;
    }
}