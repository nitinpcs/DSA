class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        int n = nums.length;
        int ans = 0;
        double ratio = a/(b*1.0);
        for(int i=0; i<n; i++) {
            int x=0;
            int y=0;
            for(int j=i; j<n; j++) {
                if(nums[j] % 2 == 0) x++;
                else y++;
                double temp = x/(y*1.0);
                if(temp <= ratio) ans++;
            }
        }
        return ans;
    }
}