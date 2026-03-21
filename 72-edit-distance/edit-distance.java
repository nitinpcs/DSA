class Solution {
    int[][] dp;
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        dp = new int[n+1][m+1];
        for(int i=0; i<=n; i++) Arrays.fill(dp[i], -1);

        return helper(n, m, word1, word2);
    }

    int helper(int i, int j, String word1, String word2) {
        if(i == 0) return  j;
        if(j == 0) return i;
        if(dp[i][j] != -1) return dp[i][j];
        if(word1.charAt(i-1) == word2.charAt(j-1)) {
            return dp[i][j] = helper(i-1, j-1, word1, word2);
        }

        int deletion = helper(i-1, j, word1, word2);
        int insertion = helper(i, j-1, word1, word2);
        int replace = helper(i-1, j-1, word1, word2);

        return dp[i][j] = 1 + Math.min(deletion, Math.min(insertion, replace)) ;
    }
}