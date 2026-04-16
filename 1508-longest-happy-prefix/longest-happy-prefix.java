class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        int[] lps = new int[n];

        int pre = 0;
        int suf = 1;
        while(suf < n) {
            if(s.charAt(pre) == s.charAt(suf)) {
                lps[suf++] = ++pre; 
            }
            else {
                if(pre == 0) {
                    lps[suf++] = 0;
                }
                else {
                    pre = lps[pre - 1];
                }
            }
        }
        return s.substring(0, lps[n-1]);
    }
}