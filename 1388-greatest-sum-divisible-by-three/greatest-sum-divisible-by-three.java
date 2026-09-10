class Solution {

    static final int MAX = Integer.MIN_VALUE;

    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][3];

        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return countMax(nums, 0, 0, dp);
    }

    public int countMax(int[] nums, int mod, int i, int[][] dp) {
        if(i >= nums.length) {
            return mod == 0 ? 0 : MAX;
        }
        if(dp[i][mod] != -1) return dp[i][mod];

        int skip = countMax(nums, mod, i+1, dp);
        int newMod = (mod + nums[i]) % 3;
        int take = countMax(nums, newMod, i+1, dp);

        if(take != MAX) take += nums[i];

        return dp[i][mod] = Math.max(skip, take);
    }
}