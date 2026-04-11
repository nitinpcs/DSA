class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        if(n < 3) return -1;
        Integer[] idx = new Integer[n];
        for(int i=0; i<n; i++) idx[i] = i;
        Arrays.sort(idx, (a,b) -> nums[a] == nums[b] ? a-b : nums[a] - nums[b]);

        int min = 2*n;
        for(int i=0; i<n-2; i++) {
            if(nums[idx[i]] == nums[idx[i+1]] && nums[idx[i+1]] == nums[idx[i+2]]) {
                min = Math.min(min, 2*(idx[i+2]-idx[i]));
            }
        }
        return min == 2*n ? -1 : min;
    }
}