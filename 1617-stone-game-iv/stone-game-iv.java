class Solution {
    public boolean winnerSquareGame(int n) {
        List<Integer> sq = new ArrayList<>();
        for(int i=1; i*i<=n; i++) {
            sq.add(i*i);
        }
        Boolean[] dp = new Boolean[n+1];
        return findWinner(n, sq, dp);
    }

    boolean findWinner(int n, List<Integer> sq, Boolean[] dp) {
        if(dp[n] != null) return dp[n];
        for(int s : sq) {
            if(s == n) return dp[n] = true;
            else if(s < n) {
                if(!findWinner(n-s, sq, dp)) return dp[n] = true;
            }
            else break;
        }
        return dp[n] = false;
    }
}