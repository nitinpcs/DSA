class Solution {
    public int twoEggDrop(int n) {
        int k = 2;
        int[] dp = new int[3];
        int cnt = 0;
        while(dp[k] < n) {
            cnt++;
            for(int i=2; i>0; i--){
                dp[i] += 1 + dp[i-1];
            }
        }
        return cnt;
    }
}