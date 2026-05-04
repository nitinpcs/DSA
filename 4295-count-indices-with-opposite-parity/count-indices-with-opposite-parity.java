class Solution {
    public int[] countOppositeParity(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int even = 0;
        for(int i=n-2; i>=0; i--) {
            if(nums[i+1] % 2 == 0) even++;
            ans[i] = nums[i] % 2 == 1 ? even : n - i - 1 - even;
        }
        return ans;
    }
}