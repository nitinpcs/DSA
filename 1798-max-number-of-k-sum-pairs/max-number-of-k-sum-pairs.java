class Solution {
    public int maxOperations(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int pairs = 0;
        for(int i = 0; i < n; i++) {
            int rem = k - nums[i];
            if(map.containsKey(rem)) {
                pairs++;
                int val = map.get(rem);
                if(val == 1) map.remove(rem);
                else map.put(rem, val-1);
            }
            else map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return pairs;
    }
}