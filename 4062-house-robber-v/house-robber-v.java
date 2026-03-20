class Solution {
    long[] dp;
    public long rob(int[] nums, int[] colors) {
        dp = new long[nums.length];
        Arrays.fill(dp, -1);
        
        return helper(nums, colors, 0);
    }

    long helper(int[] nums, int[] color,int idx) {
        if(idx >= nums.length) return 0;
        if(dp[idx] != -1) return dp[idx];
        long pick = nums[idx];
        if(idx+1 < nums.length) {
            if(color[idx] != color[idx+1]) pick += helper(nums, color, idx+1);
            else pick += helper(nums, color, idx+2);
        }
        long npick = helper(nums, color, idx+1);

        return dp[idx] = Math.max(pick, npick);
    }
}