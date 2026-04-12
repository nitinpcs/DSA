class Solution {
    public int minimumDistance(String word) {
        int n = word.length();
        int[][] dp = new int[26][26];

        for (int i = 0; i < 26; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        int first = word.charAt(0) - 'A';

        for (int j = 0; j < 26; j++) {
            dp[first][j] = 0;
        }

        for (int i = 1; i < n; i++) {
            int curr = word.charAt(i) - 'A';

            int[][] newDp = new int[26][26];
            for (int[] row : newDp) Arrays.fill(row, Integer.MAX_VALUE);

            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < 26; k++) {
                    if (dp[j][k] == Integer.MAX_VALUE) continue;

                    int cost1 = dp[j][k] + dist(j, curr);
                    newDp[curr][k] = Math.min(newDp[curr][k], cost1);

                    int cost2 = dp[j][k] + dist(k, curr);
                    newDp[j][curr] = Math.min(newDp[j][curr], cost2);
                }
            }

            dp = newDp;
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                ans = Math.min(ans, dp[i][j]);
            }
        }

        return ans;
    }

    int dist(int a, int b) {
        int x1 = a / 6, y1 = a % 6;
        int x2 = b / 6, y2 = b % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}