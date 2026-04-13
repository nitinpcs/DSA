class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        if(nums[start] == target) return 0;
        int d = 1;
        while(true) {
            if(start+d < nums.length && nums[start+d] == target) return d;
            if(start-d >= 0 && nums[start-d] == target) return d;
            d++;
        }
    }
}