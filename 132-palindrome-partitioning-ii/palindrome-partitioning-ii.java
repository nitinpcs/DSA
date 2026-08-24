class Solution {
    public int minCut(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return cuts(s, 0, dp) ;
    }

    public boolean isPal(String s) {
        int i=0, j=s.length()-1;

        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    int cuts(String s, int idx, int[] dp) {
        if(idx >= s.length()) return -1;
        if(dp[idx] != -1) return dp[idx];
        int min = Integer.MAX_VALUE;
        for(int i=idx; i<s.length(); i++) {
            if(isPal(s.substring(idx, i+1))) {
                min = Math.min(min, 1+cuts(s, i+1, dp));
            }
        } 
        return dp[idx] = min;
    }
}