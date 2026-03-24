class Solution {
    final int MOD = 12345;
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        long[][] prefix = new long[n][m];
        prefix[0][0] = 1;
        for(int i=1; i<m; i++){
            prefix[0][i] = (prefix[0][i-1]*grid[0][i-1]) % MOD;
        }
        for(int i=1; i<n; i++){
            for(int j=0; j<m; j++){
                if(j==0){
                    prefix[i][j] = (prefix[i-1][m-1]*grid[i-1][m-1]) % MOD;
                }
                else{
                    prefix[i][j] = (prefix[i][j-1]*grid[i][j-1]) % MOD;
                }
            }
        }

        long[][] suffix = new long[n][m];
        suffix[n-1][m-1] = 1;
        for(int i=m-2; i>=0; i--){
            suffix[n-1][i] = (suffix[n-1][i+1]*grid[n-1][i+1]) % MOD;
        }
        for(int i=n-2; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                if(j==m-1){
                    suffix[i][j] = (suffix[i+1][0]*grid[i+1][0]) % MOD;
                }
                else{
                    suffix[i][j] = (suffix[i][j+1]*grid[i][j+1]) % MOD;
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                grid[i][j] = (int)((prefix[i][j] * suffix[i][j]) % MOD);
            }
        }

        return grid;
    }
}