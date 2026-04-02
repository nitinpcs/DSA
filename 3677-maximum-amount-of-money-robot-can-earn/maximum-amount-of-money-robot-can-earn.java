class Solution {
    Integer[][][] dp;

    public int maximumAmount(int[][] coins) {
        int n = coins.length;
        int m = coins[0].length;
        dp = new Integer[n][m][3];

        return dfs(coins, 2, 0, 0);
    }

    int dfs(int[][] coins, int k, int x, int y) {
        int n = coins.length;
        int m = coins[0].length;

        if (x >= n || y >= m) return Integer.MIN_VALUE;

        if (x == n - 1 && y == m - 1) {
            if (coins[x][y] < 0 && k > 0) return 0;
            return coins[x][y];
        }

        if (dp[x][y][k] != null) return dp[x][y][k];

        int down = dfs(coins, k, x + 1, y);
        int right = dfs(coins, k, x, y + 1);

        int res = Integer.MIN_VALUE;

        if (down != Integer.MIN_VALUE) {
            if (coins[x][y] < 0) {
                if (k > 0)
                    res = Math.max(res, Math.max(
                        dfs(coins, k - 1, x + 1, y),
                        down + coins[x][y]
                    ));
                else
                    res = Math.max(res, down + coins[x][y]);
            } else {
                res = Math.max(res, down + coins[x][y]);
            }
        }

        if (right != Integer.MIN_VALUE) {
            if (coins[x][y] < 0) {
                if (k > 0)
                    res = Math.max(res, Math.max(
                        dfs(coins, k - 1, x, y + 1),
                        right + coins[x][y]
                    ));
                else
                    res = Math.max(res, right + coins[x][y]);
            } else {
                res = Math.max(res, right + coins[x][y]);
            }
        }

        return dp[x][y][k] = res;
    }
}