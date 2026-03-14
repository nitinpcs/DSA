class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(a.effort, b.effort));
        pq.add(new Pair(0, 0, 0));
        
        int[][] dist = new int[n][m];
        for(int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;
        while(!pq.isEmpty()){
            Pair temp = pq.poll();

            if(temp.effort > dist[temp.x][temp.y]) continue;
            if(temp.x == n-1 && temp.y == m-1) return temp.effort;
            
            for(int i=0; i<4; i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                if(isValid(nx, ny, n, m)){
                    int newEffort = Math.max(temp.effort, Math.abs(heights[nx][ny] - heights[temp.x][temp.y])); 
                   
                    if (newEffort < dist[nx][ny]) {
                        dist[nx][ny] = newEffort;
                        pq.offer(new Pair(nx, ny, newEffort));
                    }
                }
            }
        }
        return 0;
    }

    boolean isValid(int x, int y, int n, int m){
        return x>=0 && x<n && y>=0 && y<m;
    }

    class Pair{
        int x, y, effort;
        Pair(int i, int j, int eff){
            x = i;
            y = j;
            effort = eff;
        }
    }
}