class Solution {
    public int splitArray(int[] nums, int k) {
        int start = 0;
        int end = 0;
        for(int ele : nums) {
            start = Math.max(start, ele);
            end += ele;
        }
        int ans = -1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            int count = possibleSubArray(nums, k, mid);
            if(count <= k) {
                ans = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return ans;
    }

    int possibleSubArray(int[] nums, int k, int mid) {
        int sum = 0;
        int count = 1;
        for(int ele : nums) {
            if(sum + ele <= mid) {
                sum += ele;
            }
            else {
                sum = ele;
                count++;
            }
        }
        return count;
    }
}