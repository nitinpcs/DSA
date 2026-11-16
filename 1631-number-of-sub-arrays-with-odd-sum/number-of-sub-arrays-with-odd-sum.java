class Solution {
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int MOD = 1000000007;
        int[] f = new int[2];
        f[0] = 1;
        int curr = 0;
        int res = 0;
        for(int i = 0; i < n; i++) {
            curr += arr[i];
            res = (res + f[1 - (curr%2)]) % MOD;
            f[curr%2]++;
        }
        return res;
    }
}