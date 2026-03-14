class Solution {
    boolean[][] visited;
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int left = 0;
        int right = 1000000;

        while(left <= right) {
            int mid = left + (right - left)/2;
            visited = new boolean[n][m];
            for(boolean[] row : visited) Arrays.fill(row, false);
            
            dfs(mid, 0, 0, heights);

            if(visited[n-1][m-1]){
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return left;
    }

    void dfs(int threshold, int x, int y, int[][] heights){
        if(visited[x][y]) return;
        visited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(isValid(nx, ny, heights.length, heights[0].length)) {
                int effort = Math.abs(heights[nx][ny] - heights[x][y]);
                if(effort <= threshold) {
                    dfs(threshold, nx, ny, heights);
                }
            }
        }
    }

    boolean isValid(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}