class Solution {
    public int findGCD(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            min = nums[i] < min ? nums[i] : min;
            max = nums[i] > max ? nums[i] : max;
        }

        return gcd(max, min);
    }

    int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}