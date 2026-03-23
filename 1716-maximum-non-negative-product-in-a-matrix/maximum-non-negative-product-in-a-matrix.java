class Solution {
    static final int MOD = 1000000007;
    int n, m;
    int[][] grid;
    Long[][] maxMemo;
    Long[][] minMemo;

    public int maxProductPath(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        m = grid[0].length;
        maxMemo = new Long[n][m];
        minMemo = new Long[n][m];

        long[] result = dfs(n - 1, m - 1);
        long maxProduct = result[0];

        return maxProduct < 0 ? -1 : (int)(maxProduct % MOD);
    }

    long[] dfs(int i, int j) {
        if (i == 0 && j == 0) {
            return new long[]{grid[0][0], grid[0][0]};
        }

        if (maxMemo[i][j] != null && minMemo[i][j] != null) {
            return new long[]{maxMemo[i][j], minMemo[i][j]};
        }

        long val = grid[i][j];
        long maxProd = Long.MIN_VALUE;
        long minProd = Long.MAX_VALUE;

        if (i > 0) {
            long[] top = dfs(i - 1, j);
            maxProd = Math.max(top[0] * val, top[1] * val);
            minProd = Math.min(top[0] * val, top[1] * val);
        }

        if (j > 0) {
            long[] left = dfs(i, j - 1);
            maxProd = Math.max(maxProd, Math.max(left[0] * val, left[1] * val));
            minProd = Math.min(minProd, Math.min(left[0] * val, left[1] * val));
        }

        maxMemo[i][j] = maxProd;
        minMemo[i][j] = minProd;
        return new long[]{maxProd, minProd};
    }
}