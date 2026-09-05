class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, (a,b) -> a[0]-b[0]);
        int len = rides.length;

        long[] dp = new long[len];
        Arrays.fill(dp, -1);

        return findMaxTip(rides, 0, dp);
    }

    long findMaxTip(int[][] rides, int idx, long[] dp) {
        if(idx >= rides.length) return 0;
        if(dp[idx] != -1) return dp[idx];

        long skip = findMaxTip(rides, idx+1, dp);
        int next = findNext(rides, rides[idx][1]);
        long take = rides[idx][1] - rides[idx][0] + rides[idx][2] + findMaxTip(rides, next, dp);

        return dp[idx] = Math.max(skip, take);
    }

    int findNext(int[][] rides, int val) {
        int s = 0;
        int e = rides.length - 1;
        int ans = rides.length;

        while(s <= e) {
            int m = s + (e - s)/2;
            if(rides[m][0] >= val) {
                ans = m;
                e = m - 1;
            }
            else s = m + 1;
        }

        return ans;
    }
}