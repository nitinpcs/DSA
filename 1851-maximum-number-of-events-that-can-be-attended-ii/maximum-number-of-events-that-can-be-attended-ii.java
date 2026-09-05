class Solution {

    class Event{
        int start;
        int end;
        int val;
        Event(int start, int end, int val) {
            this.start = start;
            this.end = end;
            this.val = val;
        }
    }

    public int maxValue(int[][] events, int k) {
        int n = events.length;
        Event[] event = new Event[n];
        for(int i=0; i<n; i++) {
            event[i] = new Event(events[i][0], events[i][1], events[i][2]);
        }
        Arrays.sort(event, (a,b) -> a.start - b.start);

        int[][] dp = new int[n][k+1];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);

        return findMaxVal(event, k, 0, dp);
    }

    public int findMaxVal(Event[] event, int k, int idx, int[][] dp) {
        if(idx >= event.length || k == 0) {
            return 0;
        }
        if(dp[idx][k] != -1) return dp[idx][k];

        int skip = findMaxVal(event, k, idx+1, dp);

        int next = findNext(event, event[idx].end);
        int take = findMaxVal(event, k-1, next, dp) + event[idx].val;

        return dp[idx][k] = Math.max(skip, take);
    }

    public int findNext(Event[] event, int val) {
        int s = 0;
        int e = event.length - 1;
        int ans = event.length;

        while(s <= e) {
            int m = s + (e - s)/2;
            if(event[m].start > val) {
                ans = m;
                e = m - 1;
            }
            else s = m + 1;
        }

        return ans;
    }
}