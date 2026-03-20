class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] row : dp) Arrays.fill(row, -1);

        return helper(word1, word2, dp, n, m);
    }

    int helper(String word1, String word2, int[][] dp, int i, int j) {
        if(i == 0) return j;
        if(j == 0) return i;
        if(dp[i][j] != -1) return dp[i][j];

        if(word1.charAt(i-1) == word2.charAt(j-1)) {
            return dp[i][j] = helper(word1, word2, dp, i-1, j-1);
        }

        int n1 = helper(word1, word2, dp, i-1, j-1);
        int n2 = helper(word1, word2, dp, i-1, j);
        int n3 = helper(word1, word2, dp, i, j-1);

        return dp[i][j] = Math.min(n1, Math.min(n2, n3)) + 1;
    }
}