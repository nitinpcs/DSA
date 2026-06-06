class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] p = new int[n];
        p[0] = nums[0];
        for(int i=1; i<n; i++) p[i] = p[i-1] + nums[i];
        int[] ans = new int[n];
        ans[0] = p[n-1] - nums[0];
        ans[n-1] = p[n-1] - nums[n-1];

        for(int i=1; i<n-1; i++) {
            ans[i] = Math.abs(p[i-1] - (p[n-1]-p[i-1]-nums[i]));
        }

        return ans;
    }
}