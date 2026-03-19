class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] sum = new int[n][m];     
        int[][] xCount = new int[n][m];  
        sum[0][0] = grid[0][0] == 'X' ? 1 : grid[0][0] == 'Y' ? -1 : 0;
        xCount[0][0] = grid[0][0] == 'X' ? 1 : 0;

        for (int i = 1; i < n; i++) {
            int val = grid[i][0] == 'X' ? 1 : grid[i][0] == 'Y' ? -1 : 0;
            sum[i][0] = sum[i - 1][0] + val;
            xCount[i][0] = xCount[i - 1][0] + (grid[i][0] == 'X' ? 1 : 0);
        }

        for (int j = 1; j < m; j++) {
            int val = grid[0][j] == 'X' ? 1 : grid[0][j] == 'Y' ? -1 : 0;
            sum[0][j] = sum[0][j - 1] + val;
            xCount[0][j] = xCount[0][j - 1] + (grid[0][j] == 'X' ? 1 : 0);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int val = grid[i][j] == 'X' ? 1 : grid[i][j] == 'Y' ? -1 : 0;

                sum[i][j] = sum[i - 1][j] + sum[i][j - 1]
                          - sum[i - 1][j - 1] + val;

                xCount[i][j] = xCount[i - 1][j] + xCount[i][j - 1]
                             - xCount[i - 1][j - 1]
                             + (grid[i][j] == 'X' ? 1 : 0);
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (sum[i][j] == 0 && xCount[i][j] > 0) {
                    ans++;
                }
            }
        }

        return ans;
    }
}