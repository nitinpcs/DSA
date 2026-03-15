class Solution {

    int[] dx = {0, -1, 0, 1};
    int[] dy = {-1, 0, 1, 0};

    public int shortestPathAllKeys(String[] grid) {

        int n = grid.length;
        int m = grid[0].length();
        Queue<Pair> q = new LinkedList<>();
        int keys = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++){
                char c = grid[i].charAt(j);
                if(c == '@') {
                    q.offer(new Pair(i, j, 0, 0));
                }
                else if(c >= 'a' && c <= 'z') keys++;
            }
        }
        int finalmask = (1 << keys) - 1;
        boolean[][][] visited = new boolean[n][m][1 << keys];

        while(!q.isEmpty()) {
            Pair cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int mask = cur.mask;
            int steps = cur.steps;
            
            if(mask == finalmask) return steps;

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(isValid(nx, ny, n, m)) {
                    char ch = grid[nx].charAt(ny);
                    int newmask = mask;
                    if(ch == '#') continue;
                    if(ch >= 'a' && ch <= 'z') {
                        newmask |= (1 << (ch - 'a'));
                    }
                    if(ch >= 'A' && ch <= 'Z'){
                        if((mask & (1 << (ch - 'A'))) == 0) continue;
                    }

                    if(!visited[nx][ny][newmask]) {
                        visited[nx][ny][newmask] = true;
                        q.offer(new Pair(nx, ny, newmask, steps + 1));
                    }
                }
            }
        }

        return -1;
    }

    boolean isValid(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}

class Pair {
    int x, y, steps, mask;
    Pair(int i, int j, int m, int s) {
        x = i;
        y = j;
        mask = m;
        steps = s;
    }
}