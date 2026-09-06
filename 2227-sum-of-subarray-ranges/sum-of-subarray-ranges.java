class Solution {
    public long subArrayRanges(int[] nums) {
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
        for(int i = n-1; i >= 0; i--) {
            while(!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }
            next[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        long min = 0;
        for(int i=0; i<n; i++) {
            min += (long)nums[i]*(i-prev[i])*(next[i]-i);
        }

        st.clear();
        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }
            prev[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();
        for(int i = n-1; i >= 0; i--) {
            while(!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }
            next[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        long max = 0;
        for(int i=0; i<n; i++) {
            max += (long)nums[i]*(i-prev[i])*(next[i]-i);
        }

        return max - min;
    }
}