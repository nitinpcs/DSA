class Solution {
    public int[] findDegrees(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] degree = new int[n];

        for(int i = 0; i < n; i++) {
            int deg = 0;
            for(int j = 0; j < m; j++) {
                deg += matrix[i][j];
            }
            degree[i] = deg;
        }

        return degree;
    }
}