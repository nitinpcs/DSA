class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int[] f = new int[26];
        int l = 0;
        int max = 0;
        for(int r = 0; r < n; r++) {
            f[s.charAt(r)-'a']++;
            while(l < n && f[s.charAt(r)-'a'] > 2) {
                f[s.charAt(l)-'a']--;
                l++;
            }
            max = Math.max(max, r-l+1);
        }
        return max;
    }
}