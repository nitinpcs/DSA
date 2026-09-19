class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        int i = 0;
        k = k % n;
        for(int start = n - k; start < n; start++) {
            res[i++] = nums[start];
        }
        for(int j = 0; j < n - k; j++) {
            res[i++] = nums[j];
        }
        for(int j = 0; j < n; j++) nums[j] = res[j];
    }
}