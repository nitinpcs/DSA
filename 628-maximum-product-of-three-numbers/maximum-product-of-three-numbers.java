class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int neg = 0;
        int product = 1;
        for(int i=0; i<n; i++) {
            if(nums[i] < 0) neg++;
            else break;
        }
        if(neg >= 2) {
            product *= (nums[0]*nums[1]*nums[n-1]);
            product = Math.max(product, nums[n-1]*nums[n-2]*nums[n-3]);
        }
        else {
            product = nums[n-1]*nums[n-2]*nums[n-3];
        }
        return product;
    }
}