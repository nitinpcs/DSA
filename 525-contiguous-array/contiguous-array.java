class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int maxLen = 0;
        for(int i = 0; i < n; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if(count == 0) maxLen = i+1;
            if(map.containsKey(count)) {
                maxLen = Math.max(maxLen, i - map.get(count));
            }
            else {
                map.put(count, i);
            }
        }
        return maxLen;
    }
}