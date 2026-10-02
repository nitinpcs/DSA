class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        if(n % k != 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
        Arrays.sort(nums);

        for(int i = 0; i < n; i++) {
            if(map.containsKey(nums[i])) {
                int val = map.get(nums[i]);
                for(int j = nums[i] + 1; j < nums[i] + k; j++) {
                    if(!map.containsKey(j)) return false;
                    int f = map.get(j);
                    if(f == 1) map.remove(j);
                    else map.put(j, f - 1);
                }
                if(val == 1) map.remove(nums[i]);
                else {
                    map.put(nums[i], val-1);
                    i--;
                }
            }
        }
        return true;
    }
}