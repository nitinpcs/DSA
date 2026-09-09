class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return goodSubarrays(nums, k) - goodSubarrays(nums, k-1);
    }

    public int goodSubarrays(int[] nums, int k) {
        int n = nums.length;
        int good = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        for(int right = 0; right < n; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while(map.size() > k) {
                map.put(nums[left], map.get(nums[left])-1);
                if(map.get(nums[left]) == 0) map.remove(nums[left]);
                left++;
            }

            good += right - left + 1;
        }
        return good;
    }
}