class Solution {
    int[][][] dp;

    public int minimumDistance(String word) {
        int n = word.length();
        dp = new int[26][26][n];
        for (int[][] row : dp) {
            for (int[] r : row) Arrays.fill(r, -1);
        }
        int first = word.charAt(0) - 'A';

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            ans = Math.min(ans, dfs(word, first, i, 1));
        }

        return ans;
    }

    int getDist(int c1, int c2) {
        int x1 = c1 / 6, y1 = c1 % 6;
        int x2 = c2 / 6, y2 = c2 % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    int dfs(String word, int c1, int c2, int idx) {
        if (idx == word.length()) return 0;

        if (dp[c1][c2][idx] != -1) return dp[c1][c2][idx];

        int next = word.charAt(idx) - 'A';

        int cost1 = dfs(word, next, c2, idx + 1) + getDist(c1, next);

        int cost2 = dfs(word, c1, next, idx + 1) + getDist(c2, next);

        return dp[c1][c2][idx] = Math.min(cost1, cost2);
    }
}
