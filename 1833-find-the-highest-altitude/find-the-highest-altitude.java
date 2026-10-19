class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int prev = 0;
        int peak = 0;
        for(int i = 0; i < n; i++) {
            int curr = prev + gain[i];
            peak = Math.max(peak, curr);
            prev = curr;
        }
        return peak;
    }
}