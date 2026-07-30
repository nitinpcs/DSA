class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];

        dp[0] = 1;
        char c = s.charAt(0);
        dp[1] = s.charAt(0)=='0' ? 0 : 1;

        for(int i=2; i<=n; i++) {
            char c1 = s.charAt(i-1);
            char c0 = s.charAt(i-2);

            if(c1 != '0') dp[i] = dp[i-1];
            int val = (c0 - '0') * 10 + (c1 - '0');
            if(val>=10 && val <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}