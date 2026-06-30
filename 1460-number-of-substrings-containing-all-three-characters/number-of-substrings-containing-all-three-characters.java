class Solution {
    public int numberOfSubstrings(String s) {
        int[] indices = {-1, -1, -1};
        int ans = 0;
        for(int i=0; i<s.length(); i++) {
            indices[(s.charAt(i) & 31) - 1] = i;
            ans += Math.min(indices[0], Math.min(indices[1], indices[2])) + 1;
        }
        return ans;
    }
}