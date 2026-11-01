class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(nums[0] == nums[n-1]) return 0;
        
        int def = nums[n-1] - nums[0];
        int count = def;
        for(int i = 1; i < n - 1; i++) {
            int temp = Math.abs(nums[i] - (nums[n-1]-def));
            count += temp;
        }

        return count;
    }
}