class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n+1];
        for(int i=1; i<=n; i++) prefixSum[i] = prefixSum[i-1] + nums[i-1];

        int[] res = new int[n];

        for(int i=0; i<n; i++) {
            int left = i*nums[i] - prefixSum[i];
            int right = prefixSum[n] - prefixSum[i+1] - (n-i-1)*nums[i] ;  
            res[i] = left + right ;
        }
        return res;
    }
}