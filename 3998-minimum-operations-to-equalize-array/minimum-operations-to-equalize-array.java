class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        for(int i = 1; i < n; i++) {
            if(nums[i] == nums[i-1]) continue;
            return 1;
        }
        return 0;
    }
}