class Solution {
    static int MOD = 1000000007;
    int[][][] memo;

    public int checkRecord(int n) {
        memo = new int[n][2][3];

        for (int i = 0; i < n; i++) {
            for (int a = 0; a < 2; a++) {
                Arrays.fill(memo[i][a], -1);
            }
        }

        return combinations(n, 0, 0, 0);
    }

    int combinations(int n, int a, int l, int i) {
        if (i == n) return 1;

        if (memo[i][a][l] != -1)
            return memo[i][a][l];

        long res = 0;

        if (a < 1)
            res += combinations(n, a + 1, 0, i + 1);

        res += combinations(n, a, 0, i + 1);

        if (l < 2)
            res += combinations(n, a, l + 1, i + 1);

        return memo[i][a][l] = (int)(res % MOD);
    }
}