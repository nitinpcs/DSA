class Solution {
    int MIN = Integer.MIN_VALUE;
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(nums, 0, dp);
    }
    
    int helper(int[] nums, int idx, int[] dp) {
        if(idx >= nums.length) return 0;
        if(dp[idx] != -1) return dp[idx];

        int pick = helper(nums, idx+2, dp) + nums[idx];
        int npick = helper(nums, idx+1, dp);

        return dp[idx] = Math.max(pick, npick);
    }
}