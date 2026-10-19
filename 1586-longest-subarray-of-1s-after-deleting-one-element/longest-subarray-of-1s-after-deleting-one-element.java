class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int left = 0;
        int zero = 0;
        int maxLen = 0;
        for(int right = 0; right < n; right++) {
            if(nums[right] == 0) zero++;
            while(zero > 1 && left < right) {
                if(nums[left] == 0) zero--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen - 1;
    }
}