class Solution {
    public int maxPathScore(int[][] grid, int cost) {
        int n = grid.length;
        int m = grid[0].length;

        int[][][] memo = new int[n][m][cost + 1];
        for(int[][] layer : memo)
            for(int[] row : layer)
                Arrays.fill(row, -1);

        int res = dfs(grid, 0, 0, 0, cost, memo);
        return res < 0 ? -1 : res;
    }

    int dfs(int[][] grid, int i, int j, int k, int cost, int[][][] memo) {
        if(k > cost) return Integer.MIN_VALUE;

        if(i == grid.length - 1 && j == grid[0].length - 1) {
            int newK = k + (grid[i][j] == 0 ? 0 : 1);
            if(newK > cost) return Integer.MIN_VALUE;
            return grid[i][j];
        }

        if(memo[i][j][k] != -1) return memo[i][j][k];

        int newK = k + (grid[i][j] == 0 ? 0 : 1);

        int down = Integer.MIN_VALUE;
        if(i + 1 < grid.length) {
            down = dfs(grid, i + 1, j, newK, cost, memo);
        }

        int right = Integer.MIN_VALUE;
        if(j + 1 < grid[0].length) {
            right = dfs(grid, i, j + 1, newK, cost, memo);
        }

        int best = Math.max(down, right);
        if(best == Integer.MIN_VALUE) return memo[i][j][k] = Integer.MIN_VALUE;

        return memo[i][j][k] = best + grid[i][j];
    }
}