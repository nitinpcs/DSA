class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m-k+1][n-k+1];

        for(int i=0; i<=m-k; i++) {
            for(int j=0; j<=n-k; j++) {
                List<Integer> cur = new ArrayList<>();
                for(int p=i; p<i+k; p++){
                    for(int q=j; q<j+k; q++){
                        cur.add(grid[p][q]);
                    }
                }
                Collections.sort(cur);
                int min = Integer.MAX_VALUE;
                int prev = cur.get(0);
                for(int r = 1; r < cur.size(); r++){
                    if(cur.get(r) != prev){
                        min = Math.min(min, cur.get(r)-prev);
                    }
                    prev = cur.get(r);
                }
                ans[i][j] = min==Integer.MAX_VALUE ? 0 : min;
            }
        }
        return ans;
    }
}
