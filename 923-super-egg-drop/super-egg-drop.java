class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[n+1][k+1];
        int cnt = 0;

        while(dp[cnt][k] < n) {
            cnt++;
            for(int i=1; i<=k; i++){
                dp[cnt][i] = 1 + dp[cnt-1][i-1] + dp[cnt-1][i];
            }
        }
        return cnt;
    }
}