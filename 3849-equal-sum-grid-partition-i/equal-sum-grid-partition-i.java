class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long sum = 0;
        for(int[] arr : grid){
            for(int e : arr) sum += e;
        }

        if(sum % 2 != 0) return false;

        int n = grid.length;
        int m = grid[0].length;

        long[][] ans = new long[n][m];

        ans[0][0] = grid[0][0];

        for(int i = 1; i < n; i++){
            ans[i][0] = ans[i-1][0] + grid[i][0];
        }

        for(int j = 1; j < m; j++){
            ans[0][j] = ans[0][j-1] + grid[0][j];
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                ans[i][j] = grid[i][j] + ans[i-1][j] + ans[i][j-1] - ans[i-1][j-1];
            }
        }

        for(int i = 0; i < n; i++){
            if(2 * ans[i][m-1] == sum) return true;
        }
        for(int j = 0; j < m; j++){
            if(2 * ans[n-1][j] == sum) return true;
        }

        return false;
    }
}