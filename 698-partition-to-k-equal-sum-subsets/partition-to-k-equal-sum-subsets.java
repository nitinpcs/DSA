class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        for(int ele : nums) sum += ele;
        if(sum % k != 0) return false;

        Boolean[] dp = new Boolean[1<<n];
        return canPartition(nums, (1<<n)-1, 0, sum/k, dp);
    }

    boolean canPartition(int[] nums, int mask, int curr, int target, Boolean[] dp) {
        if(mask == 0) return true;
        if(dp[mask] != null) return dp[mask];

        for(int i=0; i<nums.length; i++) {
            if((mask & (1<<i)) == 0) continue;
            if(curr + nums[i] > target) continue;
            int newsum = (curr + nums[i]) % target;

            if(canPartition(nums, mask^(1<<i), newsum, target, dp)) return dp[mask] = true;
        }
        return dp[mask] = false;
    }
}