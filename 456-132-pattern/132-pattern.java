class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;

        TreeMap<Integer, Integer> seen = new TreeMap<>();
        for (int k = 2; k < n; k++) {
            seen.put(nums[k], seen.getOrDefault(nums[k], 0) + 1);
        }

        int minLeft = nums[0];

        for (int j = 1; j < n - 1; j++) {
            Integer middle = seen.higherKey(minLeft);
            if (middle != null && middle < nums[j]) {
                return true;
            }
            minLeft = Math.min(minLeft, nums[j]);

            int value = nums[j + 1];

            int freq = seen.get(value);

            if (freq == 1) {
                seen.remove(value);
            } else {
                seen.put(value, freq - 1);
            }
        }

        return false;
    }
}