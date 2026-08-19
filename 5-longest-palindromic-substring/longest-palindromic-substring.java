class Solution {
    int start = 0;
    int maxLen = 1;
    public String longestPalindrome(String s) {
        for(int i=0; i<s.length(); i++) {
            expand(i, i, s);
            expand(i, i+1, s);
        }
        return s.substring(start, start+maxLen);
    }

    void expand(int l,  int r, String s) {
        int len = 1;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            len = r-l+1;
            if(len > maxLen) {
                start = l;
                maxLen = len;
            }
            l--;
            r++;
        }
    }
}