class Solution {
    public long elevatorRequests(int n, int start, int[] requests) {
        int m = requests.length;

        Arrays.sort(requests);

        long INF = Long.MAX_VALUE / 4;

        long[][] dpL = new long[m][m];
        long[][] dpR = new long[m][m];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dpL[i], INF);
            Arrays.fill(dpR[i], INF);
        }

        for (int i = 0; i < m; i++) {
            long cost = (long) Math.abs(start - requests[i]) * m;
            dpL[i][i] = cost;
            dpR[i][i] = cost;
        }

        for (int len = 1; len <= m; len++) {

            int remaining = m - len;

            for (int l = 0; l + len - 1 < m; l++) {

                int r = l + len - 1;

                if (l > 0) {
                    long cost1 =
                        dpL[l][r]
                        + (long) (requests[l] - requests[l - 1]) * remaining;

                    dpL[l - 1][r] =
                        Math.min(dpL[l - 1][r], cost1);

                    long cost2 =
                        dpR[l][r]
                        + (long) (requests[r] - requests[l - 1]) * remaining;

                    dpL[l - 1][r] =
                        Math.min(dpL[l - 1][r], cost2);
                }

                if (r + 1 < m) {
                    long cost1 =
                        dpL[l][r]
                        + (long) (requests[r + 1] - requests[l]) * remaining;

                    dpR[l][r + 1] =
                        Math.min(dpR[l][r + 1], cost1);

                    long cost2 =
                        dpR[l][r]
                        + (long) (requests[r + 1] - requests[r]) * remaining;

                    dpR[l][r + 1] =
                        Math.min(dpR[l][r + 1], cost2);
                }
            }
        }

        return Math.min(dpL[0][m - 1], dpR[0][m - 1]);
    }
}