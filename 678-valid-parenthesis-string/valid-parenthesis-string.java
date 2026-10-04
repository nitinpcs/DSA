class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n+1][n+1];
        dp[0][0] = true;

        for(int i = 0; i < n; i++) {
            for(int bal = 0; bal <= n; bal++) {
                if(!dp[i][bal]) continue;

                char ch = s.charAt(i);
                if(ch == '(') {
                    dp[i+1][bal+1] = true;
                }
                else if(ch == ')') {
                    if(bal > 0) dp[i+1][bal-1] = true;
                }
                else {
                    dp[i+1][bal+1] = true;
                    dp[i+1][bal] = true;
                    if(bal > 0) dp[i+1][bal-1] = true;
                }
            }
        }
        return dp[n][0];
    }
}