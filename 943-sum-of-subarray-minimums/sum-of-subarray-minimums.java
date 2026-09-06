class Solution {
    public int sumSubarrayMins(int[] nums) {
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
        long sum = 0;
        int MOD = 1000000007;
        for(int i=0; i<n; i++) {
            int left = i - prev[i];
            int right = next[i] - i;
            sum = (sum + (long)nums[i]*left*right) % MOD;
        }

        return (int)sum;
    }
}