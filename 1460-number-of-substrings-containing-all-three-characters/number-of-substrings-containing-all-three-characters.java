class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] freq = new int[3];

        int ans = 0;
        int l = 0;
        for(int r = 0; r  < n; r++) {
            freq[s.charAt(r) - 'a']++;
            while(hasAllThree(freq)) {
                ans += n - r;
                freq[s.charAt(l) - 'a']--;
                l++;
            }
        }
        return ans;
    }
    boolean hasAllThree(int[] x) {
        return x[0] > 0 && x[1] > 0 && x[2] > 0;
    }
}