class Solution {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();
        int[][] visited = new int[n][m];
        return dfs(grid, 0, 0, health-grid.get(0).get(0), visited);
    }

    public boolean dfs(List<List<Integer>> grid, int i, int j, int h, int[][] visited) {
        if(i == grid.size()-1 && j == grid.get(0).size()-1 && h>=1) {
           return true;
        }
        if(h < 1) return false;
        if(h <= visited[i][j]) return false;
        visited[i][j] = h;
        for(int k=0; k<4; k++) {
            int nr = i + dx[k];
            int ny = j + dy[k];
            if(isValid(nr, ny, grid)) {
                if(dfs(grid, nr, ny, h-grid.get(nr).get(ny), visited)) return true;
            }
        }
        return false;
    }

    boolean isValid(int i, int j, List<List<Integer>> g) {
        return i>=0 && j>=0 && i < g.size() && j < g.get(0).size();
    }
}