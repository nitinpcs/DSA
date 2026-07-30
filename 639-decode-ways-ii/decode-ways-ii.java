class Solution {
    int[] memo;
    int MOD = 1000000007;
    public int numDecodings(String s) {
        int n = s.length();
        memo = new int[n];
        Arrays.fill(memo, -1);

        return countWays(s, 0);
    }

    int countWays(String s, int i) {
        if(i >= s.length()) return 1 ;
        if(memo[i] != -1) return memo[i];

        long ways = 0;
        if(s.charAt(i) == '*') {
            ways = (ways + 9L*countWays(s, i+1)) % MOD;
        }
        else if(s.charAt(i) != '0') ways = (ways + countWays(s, i+1)) % MOD;

        if(i+1 < s.length()) {
            if(s.charAt(i) == '*' && s.charAt(i+1) == '*') {
                ways = (ways + 15L*countWays(s, i+2)) % MOD;
            }
            else if(s.charAt(i) == '*') {
                if(s.charAt(i+1) <= '6') ways = (ways + 2L*countWays(s, i+2)) % MOD;
                else ways = (ways + countWays(s, i+2)) % MOD;
            }
            else if(s.charAt(i+1) == '*') {
                if(s.charAt(i) == '1') ways = (ways + 9L*countWays(s, i+2)) % MOD;
                else if(s.charAt(i) == '2') ways = (ways + 6L*countWays(s, i+2)) % MOD; 
            }
            else {
                int temp = Integer.parseInt(s.substring(i, i+2));
                if(temp <= 26 && temp >= 10) {
                    ways = (ways + countWays(s, i+2)) % MOD;
                }
            }
        }

        return memo[i] = (int)ways;
    }
}