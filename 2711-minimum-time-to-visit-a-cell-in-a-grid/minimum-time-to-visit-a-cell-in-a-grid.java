class Solution {
    public int minimumTime(int[][] grid) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int n = grid.length;
        int m = grid[0].length;
        if(n > 1 && m > 1 && grid[0][1] > 1 && grid[1][0] > 1) return -1; 

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time)); 
        boolean[][] visited = new boolean[n][m];
        pq.add(new Pair(0, 0, 0));
        visited[0][0] = true;

        while(!pq.isEmpty()) {
            Pair temp = pq.poll();
            if(temp.x == n-1 && temp.y == m-1) return temp.time;
            for(int i=0; i<4; i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                int nextTime = temp.time + 1;
                if(isValid(nx, ny, n, m) && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    if(grid[nx][ny] > temp.time){
                        int wait = grid[nx][ny] - nextTime;
                        if(wait % 2 == 0) nextTime = grid[nx][ny];
                        else nextTime = grid[nx][ny] + 1;
                    }
                    pq.add(new Pair(nx, ny, nextTime));
                }
            }
        }
        return -1;
    }

    boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }
}

class Pair {
    int x;
    int y;
    int time;
    Pair(int i, int j, int t) {
        x = i;
        y = j;
        time = t;
    }
}