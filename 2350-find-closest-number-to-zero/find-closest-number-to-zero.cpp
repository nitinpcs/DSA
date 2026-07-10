class Solution {
public:
    int findClosestNumber(vector<int>& nums) {
        int ans = 0;
        int minDiff = 2*1e5;
        for(int i = 0; i < nums.size(); i++) {
            int cur = std::abs(nums[i] - 0);
            if(cur < minDiff) {
                minDiff = cur;
                ans = nums[i];
            }
            else if(cur == minDiff) {
                ans = ans > nums[i] ? ans : nums[i];
            }
        }
        return ans;
    }
};