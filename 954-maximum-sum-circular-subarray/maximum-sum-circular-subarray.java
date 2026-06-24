class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max = max(nums);
        int min = min(nums);
        int total = 0;
        for(int i : nums) total += i;
        if(min == total) return max;
        return Math.max(max, total-min); 
    }

    public int max(int[] nums) {
        int curmax = nums[0];
        int sum = nums[0];
        for(int i=1; i<nums.length; i++) {
            sum = Math.max(nums[i], sum+nums[i]);
            curmax = Math.max(curmax, sum);
        }
        return curmax;
    }
    public int min(int[] nums) {
        int curmin = nums[0];
        int sum = nums[0];
        for(int i=1; i<nums.length; i++) {
            sum = Math.min(nums[i], sum+nums[i]);
            curmin = Math.min(curmin, sum);
        }
        return curmin;
    }
}
