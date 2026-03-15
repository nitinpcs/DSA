class Solution {
    public int sumOfSquares(int[] nums) {
        long ans = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(n % (i + 1) == 0) ans += nums[i] * nums[i];
        }

        return (int)ans;
    }
}