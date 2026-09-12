class Solution {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;
        int[][] dp = new int[n][3];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        return countMaxVal(events, 0, dp, 2);
    }

    int countMaxVal(int[][] events, int idx, int[][] dp, int cnt) {
        if(cnt == 0 || idx >= events.length) return 0;
        if(dp[idx][cnt] != -1) return dp[idx][cnt];

        int skip = countMaxVal(events, idx + 1, dp, cnt);

        int newIdx = getNext(events, events[idx][1]);
        int take = events[idx][2] + countMaxVal(events, newIdx, dp, cnt - 1);

        return dp[idx][cnt] = Math.max(skip, take);
    }

    int getNext(int[][] events, int val) {
        int lo = 0;
        int high = events.length - 1;
        int ans = events.length;

        while(lo <= high) {
            int mid = lo + ((high - lo ) >> 1 );
            if(events[mid][0] > val) {
                ans = mid;
                high = mid - 1;
            }
            else lo = mid + 1;
        }

        return ans;
    }
}