class Solution {
    public int validSubarraySize(int[] nums, int threshold) {
        int n = nums.length;
        int[] prev = new int[n];
        int[] next = new int[n];

        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            prev[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        for(int i = n - 1; i >= 0; i--) {
            while(!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }
            next[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        for(int i=0; i<n; i++) {
            int len = next[i] - prev[i] - 1;
            
            if(nums[i] > threshold/len) return len;
        }

        return -1;
    }
}