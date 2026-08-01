class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int mask = (1 << maxChoosableInteger) - 1;
        int sum = (maxChoosableInteger*(maxChoosableInteger+1))/2;
        if(sum < desiredTotal) return false;
        if(desiredTotal < 0) return true;
        Boolean[] dp = new Boolean[1  << maxChoosableInteger];

        return whowins(maxChoosableInteger, desiredTotal, 0, mask, dp);
    }

    boolean whowins(int max, int total, int cur, int mask, Boolean[] dp) {
        if(dp[mask] != null) return dp[mask];

        for(int i=0; i<max; i++) {
            if((mask & (1<<i)) == 0) continue;
            if(cur + i+1 >= total) {
                return dp[mask] = true;
            }
            if(!whowins(max, total, cur+i+1, mask^(1<<i), dp)) return dp[mask] = true;
        }
        return dp[mask] = false;
    }
}