class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        ArrayDeque<Integer> st = new ArrayDeque<>();
        int[] left = new int[n];
        int[] right = new int[n];

        int i = 0;
        while(i < n) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i++);
        }
        st.clear();
        i = n - 1;
        while(i >= 0) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i--);
        }

        int maxArea = 0, area = 0;
        for(int j = 0; j < n; j++) {
            int width = right[j] - left[j] - 1;
            area = heights[j] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    } 
}