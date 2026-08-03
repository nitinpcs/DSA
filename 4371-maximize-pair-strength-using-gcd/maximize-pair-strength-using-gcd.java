class Solution {
    public long maxPairStrength(int[] nums) {
        long ans = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                long g = gcd(nums[i], nums[j]);

                long strength = (1L * nums[i] * nums[j]) / (g * g);

                ans = Math.max(ans, strength);
            }
        }

        return ans;
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}