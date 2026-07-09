class Solution {

    static int MOD = 1000000007;
    static int MAX = 100001;
    static long[] pow10 = new long[MAX];

    static {
        pow10[0] = 1;
        for(int i=1; i<MAX; i++) {
            pow10[i] = (pow10[i-1] * 10) % MOD;
        }
    }

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        int[] cnt = new int[n+1];
        int[] sum = new int[n+1];
        long[] num = new long[n+1];

        for(int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            sum[i+1] = d + sum[i];
            cnt[i+1] = d > 0 ? cnt[i]+1 : cnt[i];
            num[i+1] = d > 0 ? (num[i]* 10 + d) % MOD : num[i];
        }

        int[] res = new int[queries.length];
        int i = 0;
        for(int[] q : queries) {
            int l = q[0];
            int r = q[1] + 1;
            int diff = cnt[r] - cnt[l];
            long val = (num[r] - ((num[l] * pow10[diff]) % MOD) + MOD) % MOD;
            long val_sum = sum[r] - sum[l];
            res[i++] = (int)((val * val_sum) % MOD);
        }

        return res;
    }
}