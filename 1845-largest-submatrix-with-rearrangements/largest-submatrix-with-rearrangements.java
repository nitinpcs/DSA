class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] heights = new int[m];
        int maxArea = 0;
        for(int[] row : matrix) {
            for(int i = 0; i < row.length; i++) {
                heights[i] = row[i] == 1 ? heights[i] + 1 : 0;
            }
            maxArea = Math.max(maxArea, getArea(heights));
        }
        return maxArea;
    }

    int getArea(int[] heights) {
        int[] temp = heights.clone();
        Arrays.sort(temp);
        int n = heights.length;
        ArrayDeque<Integer> st = new ArrayDeque<>();
        int[] left = new int[n];
        int[] right = new int[n];
        int i = 0;
        while(i < n) {
            while(!st.isEmpty() && temp[st.peek()] >= temp[i]) {
                st.pop();
            }
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i++);
        }
        i = n-1;
        st.clear();
        while(i >= 0) {
            while(!st.isEmpty() && temp[st.peek()] >= temp[i]) {
                st.pop();
            }
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i--);
        }
        int maxArea = 0;
        int area = 0;
        for(int j=0; j<n; j++) {
            area = temp[j] * (right[j] - left[j] - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}