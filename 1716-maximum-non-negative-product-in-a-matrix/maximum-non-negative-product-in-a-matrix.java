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

        long[] result = dfs(0, 0);
        long maxProduct = result[0];

        return maxProduct < 0 ? -1 : (int)(maxProduct % MOD);
    }

    long[] dfs(int i, int j) {
        if (i == n - 1 && j == m - 1) {
            return new long[]{grid[i][j], grid[i][j]};
        }

        if (maxMemo[i][j] != null && minMemo[i][j] != null) {
            return new long[]{maxMemo[i][j], minMemo[i][j]};
        }

        long val = grid[i][j];
        long maxProd = Long.MIN_VALUE;
        long minProd = Long.MAX_VALUE;

        if (i + 1 < n) {
            long[] down = dfs(i + 1, j);
            maxProd = Math.max(maxProd, Math.max(down[0] * val, down[1] * val));
            minProd = Math.min(minProd, Math.min(down[0] * val, down[1] * val));
        }
        
        if (j + 1 < m) {
            long[] right = dfs(i, j + 1);
            maxProd = Math.max(maxProd, Math.max(right[0] * val, right[1] * val));
            minProd = Math.min(minProd, Math.min(right[0] * val, right[1] * val));
        }

        maxMemo[i][j] = maxProd;
        minMemo[i][j] = minProd;
        return new long[]{maxProd, minProd};
    }
}