class Solution {
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        long[] prefix = new long[n];
        prefix[0] = nums[0];
        for(int i=1; i<n; i++) prefix[i] = prefix[i-1] + nums[i];

        Stack<Integer> st = new Stack<>();
        int[] prev = new int[n];
        int[] next = new int[n];
        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) st.pop();
            prev[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && nums[st.peek()] > nums[i]) st.pop();
            next[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long max = 0;
    
        int MOD = 1000000007;
        for(int i=0; i<n; i++) {
            int l = prev[i]+1;
            int r = next[i]-1;
            long curr = prefix[r] - (l == 0 ? 0 : prefix[l-1]);
            long temp = (long)nums[i]*curr ;
            max = Math.max(max, temp);
        }
        return (int)(max % MOD);
    }
}