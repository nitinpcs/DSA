class Solution {
    final int MOD = 12345;

    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int size = n * m;

        int[] arr = new int[size];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[idx++] = grid[i][j];
            }
        }

        long[] prefix = new long[size];
        long[] suffix = new long[size];

        prefix[0] = 1;
        for (int i = 1; i < size; i++) {
            prefix[i] = (prefix[i - 1] * arr[i - 1]) % MOD;
        }

        suffix[size - 1] = 1;
        for (int i = size - 2; i >= 0; i--) {
            suffix[i] = (suffix[i + 1] * arr[i + 1]) % MOD;
        }

        idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = (int)((prefix[idx] * suffix[idx]) % MOD);
                idx++;
            }
        }

        return grid;
    }
}