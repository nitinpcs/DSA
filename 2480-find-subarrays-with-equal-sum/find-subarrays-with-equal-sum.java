class Solution {
    public boolean findSubarrays(int[] nums) {
        int n = nums.length;
        if(n <= 2) return false;
        Set<Integer> set = new HashSet<>();
        
        for(int i = 1; i < n; i++) {
            int curr = nums[i-1] + nums[i];
            if(!set.add(curr)) return true;
        }
        return false;
    }
}