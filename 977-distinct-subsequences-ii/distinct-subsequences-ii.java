class Solution {
    public int distinctSubseqII(String s) {
        int n = s.length();
        long[] dp = new long[26];

        long total = 0;
        int MOD = 1000000007;

        for(int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';
            long newSeq = (total + 1) % MOD;
            total = (total + newSeq - dp[ch] + MOD) % MOD;
            dp[ch] = newSeq;
        }
        return (int)total;
    }
}