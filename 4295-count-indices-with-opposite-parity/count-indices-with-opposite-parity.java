class Solution {
    public int[] countOppositeParity(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        int even = 0;
        for(int i=n-2; i>=0; i--) {
            if(nums[i+1] % 2 == 0) even++;
            count[i] = even;
        }
        int[] ans = new int[n];
        for(int i=0; i<n; i++) {
            ans[i] = nums[i] % 2 == 1 ? count[i] : n - i - 1 - count[i];
        }
        return ans;
    }
}