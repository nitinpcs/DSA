class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;

        for(int i = n-1; i >= 1; i--) {
            if(nums[i] > nums[i-1]) {
                idx = i-1;
                break;
            }
        }
        if(idx == -1) {
            Arrays.sort(nums);
            return;
        }
        else{
            int max = Integer.MAX_VALUE;
            int temp_i = -1;
            for(int j = idx+1; j < n; j++){
                if(nums[j] > nums[idx]){
                    if(nums[j] < max){
                        max = nums[j];
                        temp_i = j;
                    }
                }
            }
            int curr = nums[temp_i];
            nums[temp_i] = nums[idx];
            nums[idx] = curr;
        }
        Arrays.sort(nums, idx+1, n);
    }
}