class Solution {
    public boolean checkPartitioning(String s) {
        int n = s.length();

        boolean[][] pal = new boolean[n][n];
        for(int i=0 ; i<n; i++) pal[i][i] = true;

        for(int len=2; len<=n; len++) {
            for(int i=0; i+len-1 < n; i++) {
                int j = i+len-1;
                pal[i][j] = s.charAt(i) == s.charAt(j) && (len == 2 || pal[i+1][j-1]); 
            }
        }
        Boolean[][] dp = new Boolean[n][4];
        return check(s, 0, 3, dp, pal);
    }


    boolean check(String s, int idx, int k, Boolean[][] dp, boolean[][] pal) {
        if(k < 0) return false;
        if(idx >= s.length()) return k == 0;
        if(dp[idx][k] != null) return dp[idx][k]; 
        for(int i=idx; i<s.length(); i++) {
            if(pal[idx][i]) {
                if(check(s, i+1, k-1, dp, pal)) return dp[idx][k] = true;
            }
        }
        return dp[idx][k] = false;
    }
}