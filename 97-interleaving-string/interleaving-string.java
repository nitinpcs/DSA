class Solution {
    Boolean[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();

        if(s3.length() != n+m) return false;

        dp = new Boolean[n+1][m+1];
        return helper(0, 0, s1, s2, s3);
    }

    boolean helper(int i, int j, String s1, String s2, String s3) {
        int k = i + j;
        if(i>=s1.length() && j>=s2.length()) return true;
        if(dp[i][j] != null) return dp[i][j];
        boolean ans = false;
        if(i<s1.length() && s1.charAt(i) == s3.charAt(k)){
            ans |= helper(i+1, j, s1, s2, s3);
        }
        if(j<s2.length() && s2.charAt(j) == s3.charAt(k)){
            ans |= helper(i, j+1, s1, s2, s3);
        }

        return dp[i][j] = ans;
    }
}