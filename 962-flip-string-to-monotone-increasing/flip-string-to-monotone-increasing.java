class Solution {
    int[][] dp;
    public int minFlipsMonoIncr(String s) {
        dp = new int[s.length()][2];
        for(int i=0; i<s.length(); i++) Arrays.fill(dp[i], -1);
        return flips(s, 0, 0);
    }

    int flips(String s, int idx, int last) {
        if(idx >= s.length()) return 0;
        if(dp[idx][last] != -1) return dp[idx][last];
        int makeZero = Integer.MAX_VALUE;
        int curr = s.charAt(idx) - '0';
        if(last == 0) {
            int cost = curr == 0 ? 0 : 1;
            makeZero = cost + flips(s, idx+1 , 0);
        }
        
        int cost = curr == 1 ? 0 : 1;
        int makeOne = cost + flips(s, idx+1, 1);

        return dp[idx][last] = Math.min(makeZero, makeOne);
    }
}