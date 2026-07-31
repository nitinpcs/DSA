class Solution {
    int MOD = 1000000007;
    public int countTexts(String pressedKeys) {
        int[] keys = {0, 0, 3, 3, 3, 3, 3, 4, 3, 4};
        int n = pressedKeys.length();

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return count(pressedKeys, 0, dp, keys);
    }

    int count(String s, int idx, int[] dp, int[] keys) {
        if(idx >= s.length()) return 1;
        if(dp[idx] != -1) return dp[idx];
        int ways = 0;

        int key = keys[s.charAt(idx)-'0'];
        for(int i=0; i<key && idx+i < s.length() && s.charAt(idx)==s.charAt(idx+i); i++) {
            ways += count(s, idx+i+1, dp, keys);
            ways %= MOD;
        }

        return dp[idx] = ways;
    }
}