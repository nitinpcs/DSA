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

        int[] dp = new int[n];

        for(int i=0; i<n; i++) {
            if(pal[0][i]) dp[i] = 0;
            else {
                dp[i] = i;
                for(int j=i; j>=1; j--) {
                    if(pal[j][i]) {
                        dp[i] = Math.min(dp[i], dp[j-1]+1);
                    }
                }
            }
        }
        return dp[n-1];
    }
}