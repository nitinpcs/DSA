class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int INF = Integer.MAX_VALUE;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        Arrays.fill(prefix, INF);
        Arrays.fill(suffix, INF);

        int l = 0;
        int curr = arr[0];
        for(int r = 1; r < n; r++) {
            while(curr > target) curr -= arr[l++];
            if(curr == target) {
                prefix[r] = Math.min(prefix[r - 1], r - l);
            }
            else prefix[r] = prefix[r-1];
            curr += arr[r];
        }

        curr = arr[n - 1];
        suffix[n - 1] = curr == target ? 1 : INF;
        l = n - 1;
        for(int r = n - 2; r >= 0; r--) {
            curr += arr[r];
            while(curr > target) curr -= arr[l--];
            if(curr == target) {
                suffix[r] = Math.min(suffix[r+1], l - r + 1);
            }
            else suffix[r] = suffix[r + 1];
        }

        int minLength = INF;
        for(int i = 0; i < n; i++) {
            if(prefix[i] == INF || suffix[i] == INF) continue;
            minLength = Math.min(minLength, prefix[i] + suffix[i]);
        }

        return minLength == INF ? -1 : minLength;
    }
}