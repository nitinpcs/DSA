class Solution {
    int[] dp;
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        int ans = getDiff(stoneValue, 0);
        return ans > 0 ? "Alice" : ans < 0 ? "Bob" : "Tie";
    }

    int getDiff(int[] nums, int idx) {
        if(idx >= nums.length) return 0;
        if(idx == nums.length-1) return nums[idx];
        if(dp[idx] != -1) return dp[idx];

        int one = nums[idx] - getDiff(nums, idx+1);
        int two = 0;
        if(idx+1 < nums.length) {
            two = nums[idx] + nums[idx+1] - getDiff(nums, idx+2);
        }
        int three = 0;
        if(idx+2 < nums.length) {
            three = nums[idx] + nums[idx+1] + nums[idx+2] - getDiff(nums, idx+3);
        }

        return dp[idx] = Math.max(
            one, Math.max(two, three)
        );
    }
}