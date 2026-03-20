class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int zero = helper(nums, 0, dp, n-1);
        Arrays.fill(dp, -1);
        int one = helper(nums, 1, dp, n);
        
        return Math.max(zero, one);
    }

    int helper(int[] nums, int idx, int[] dp, int n) {
        if(idx >= n) return 0;
        if(dp[idx] != -1) return dp[idx];

        int pick = helper(nums, idx+2, dp, n) + nums[idx];
        int npick = helper(nums, idx+1, dp, n);

        return dp[idx] = Math.max(pick, npick);
    }
}