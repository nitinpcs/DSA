class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        int sum = nums[0];
        Set<Integer> set = new HashSet<>();
        for(int ele : nums) set.add(ele);

        for(int i=1; i<n; i++) {
            if(nums[i] == nums[i-1] + 1) {
                sum += nums[i];
            }
            else break;
        }

        while(set.contains(sum)) {
            sum++;
        }
        return sum;
    }
}