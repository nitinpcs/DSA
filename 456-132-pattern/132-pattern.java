class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        ArrayDeque<Integer> st = new ArrayDeque<>();
        int third = Integer.MIN_VALUE;
        for(int i = n-1; i>=0; i--) {
            if(nums[i] < third) return true;
            while(!st.isEmpty() && nums[i] > st.peek()) {
                third = st.pop();
            }
            st.push(nums[i]);
        }
        return false;
    }
}