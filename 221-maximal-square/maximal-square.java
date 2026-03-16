class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int max = 0;

        int[][] mat = new int[n][m];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                mat[i][j] = matrix[i][j] - '0';
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(mat[i][j] != 0 && isValid(i, j-1, n, m) && isValid(i-1, j, n, m) && isValid(i-1, j-1, n, m)){
                    mat[i][j] = 1 + Math.min(mat[i-1][j], Math.min(mat[i][j-1], mat[i-1][j-1]));
                    
                }
                max = Math.max(max, mat[i][j]);
            }
            
        }
        return max * max;
    }

    boolean isValid(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
 }