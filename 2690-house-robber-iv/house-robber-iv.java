class Solution {
    public int minCapability(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();

        while(min <= max) {
            int mid = min + (max - min)/2;
            if(isPossible(nums, k, mid)) {
                max = mid - 1;
            }
            else min = mid + 1;
        }
        return min;
    }

    boolean isPossible(int[] nums, int k, int threshold) {
        for(int i=0; i<nums.length; i++) {
            if(nums[i] <= threshold) {
                k--;
                i++;
            }
        }
        return  k <= 0;
    }
}