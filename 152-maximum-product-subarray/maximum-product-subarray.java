class Solution {
    public int maxProduct(int[] nums) {
        int maxEnding = nums[0];
        int minEnding = nums[0];
        int result = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < 0) {
                int temp = maxEnding;
                maxEnding = minEnding;
                minEnding = temp;
            }
            maxEnding = Math.max(nums[i], maxEnding * nums[i]);
            minEnding = Math.min(nums[i], minEnding * nums[i]);
            result = Math.max(result, maxEnding);
        }
        return result;
    }
}