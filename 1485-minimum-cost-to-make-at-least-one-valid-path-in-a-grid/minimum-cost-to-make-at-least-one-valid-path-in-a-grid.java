class Solution {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

    public int minCost(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] dist = new int[n][m];

        for(int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);

        Deque<int[]> dq = new ArrayDeque<>();

        dq.offerFirst(new int[]{0,0});
        dist[0][0] = 0;

        while(!dq.isEmpty()){

            int[] cur = dq.pollFirst();
            int x = cur[0];
            int y = cur[1];

            for(int i=0;i<4;i++){

                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];

                if(nx<0 || ny<0 || nx>=n || ny>=m)
                    continue;

                int cost = (grid[x][y] == i+1) ? 0 : 1;

                if(dist[x][y] + cost < dist[nx][ny]){

                    dist[nx][ny] = dist[x][y] + cost;

                    if(cost == 0)
                        dq.offerFirst(new int[]{nx,ny});
                    else
                        dq.offerLast(new int[]{nx,ny});
                }
            }
        }

        return dist[n-1][m-1];
    }
}