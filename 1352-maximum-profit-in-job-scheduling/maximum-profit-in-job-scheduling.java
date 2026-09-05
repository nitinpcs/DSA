class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for(int i=0; i<n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        
        Arrays.sort(jobs, (a,b)->a[0]-b[0]);
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        return findProfit(jobs, 0, dp);
    }

    public int findProfit(int[][] jobs, int idx, int[] dp) {
        if(idx >= jobs.length) return 0;
        if(dp[idx] != -1) return dp[idx];
        
        int skip = findProfit(jobs, idx+1, dp);
        int next = findNext(jobs, jobs[idx][1]);
        int take = jobs[idx][2] + findProfit(jobs, next, dp);
        
        return dp[idx] = Math.max(skip, take);
    }

    public int findNext(int[][] jobs, int val) {
        int s = 0;
        int e = jobs.length - 1;
        int ans = jobs.length;
        while(s <= e) {
            int m = s+(e-s)/2;
            if(jobs[m][0] >= val) {
                ans = m;
                e = m-1;
            }
            else s = m+1;
        }
        return ans;
    }
}