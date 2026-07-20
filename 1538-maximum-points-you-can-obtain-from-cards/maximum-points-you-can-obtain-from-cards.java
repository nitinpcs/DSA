class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for(int e : cardPoints) sum += e;
        int curr = 0;
        int window = cardPoints.length - k;
        for(int i=0; i<window; i++) {
            curr += cardPoints[i];
        }
        int ans = sum - curr;
        for(int i=window; i<cardPoints.length; i++) {
            curr += cardPoints[i];
            curr -= cardPoints[i-window];
            ans = Math.max(ans, sum-curr);
        }
        return ans;
    }
}