class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int start = -1;
        for(int i = 0; i < n; i++) {
            if(nums[i] == 0) {
                start = i;
                break;
            }
        }
        if(start == -1) return;
        for(int i = start+1; i < n; i++) {
            if(nums[i] != 0) {
                nums[start] = nums[i];
                nums[i] = 0;
                start++;
            }
        }
    }
}