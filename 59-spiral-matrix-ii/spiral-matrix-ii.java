class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        int curr = 1;
        int top = 0, left = 0;
        int bottom = n-1, right = n-1;

        while(top <= bottom && left <= right) {
            for(int i=left; i<=right; i++) mat[top][i] = curr++;
            top++;
            for(int i=top; i<=bottom; i++) mat[i][right] = curr++;
            right--;
            if(top <= bottom) {
                for(int i=right; i>=left; i--) mat[bottom][i] = curr++;
                bottom--;
            }
            
            if(left <= right) {
                for(int i=bottom; i>=top; i--) mat[i][left] = curr++;
                left++;
            }
        }

        return mat;
    }
}