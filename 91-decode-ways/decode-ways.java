class Solution {
    int[] memo;
    public int numDecodings(String s) {
        int n = s.length();
        memo = new int[n];
        Arrays.fill(memo, -1);

        countWays(s, 0);
        return memo[0]==-1 ? 0 : memo[0];
    }

    boolean isValid(String s) {
        int n = Integer.parseInt(s);
        if(n > 26) return false;
        return true;
    }

    int countWays(String s, int idx) {
        if(idx >= s.length()) return 1;
        if(memo[idx] != -1) return memo[idx];

        if(s.charAt(idx) == '0') return 0;
        int ways = countWays(s, idx+1);
        if(idx+1 < s.length() && isValid(s.substring(idx, idx+2))) {
            ways += countWays(s, idx+2);
        }

        return memo[idx] = ways;
    }
}