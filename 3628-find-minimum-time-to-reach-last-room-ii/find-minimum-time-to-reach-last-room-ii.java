class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(a.cost, b.cost));
        boolean[][] visited = new boolean[n][m];
        pq.add(new Pair(0, 0, 0, 1));
        visited[0][0] = true;
        while(!pq.isEmpty()){
            Pair temp = pq.poll();
            if(temp.x == n-1 && temp.y == m-1) return temp.cost;
            for(int i=0; i<4; i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                if(isValid(nx, ny, n, m) && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    int cnt = temp.count==1 ? 2 : 1; 
                    pq.add(new Pair(nx, ny, Math.max(0, moveTime[nx][ny]-temp.cost)+temp.count+temp.cost, cnt));
                }
            }
        }
        return -1;
    }
    boolean isValid(int x, int y, int n, int m){
        return x>=0 && x<n && y>=0 && y<m;
    }

    class Pair{
        int x, y, cost, count;
        Pair(int i, int j, int c, int cn){
            x = i;
            y = j;
            cost = c;
            count = cn;
        }
    }
}