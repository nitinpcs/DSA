class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int MOD = 1000000007;
        for(int[] q : queries) {
            for(int i=q[0]; i<=q[1]; i+=q[2]) {
                nums[i] = (int)((1L*nums[i] * q[3]) % MOD);
            }
        }
        int xor = 0;
        for(int ele : nums) xor ^= ele;

        return xor;
    }
}