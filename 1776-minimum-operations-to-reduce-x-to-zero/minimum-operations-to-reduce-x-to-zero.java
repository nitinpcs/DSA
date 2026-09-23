class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int target = -x;
        for(int i : nums) target += i;
        if(target == 0) return n;
        int left = 0;
        int max = 0;
        int curr = 0;
        for(int right = 0; right < n; right++) {
            curr += nums[right];
            while(curr > target && left < right) curr -= nums[left++];
            if(curr == target) max = Math.max(max, right - left + 1);
        }
        return max == 0 ? -1 : n - max;
    }
}