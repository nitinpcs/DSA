class Solution {
    public int minMoves(String[] classroom, int energy) {
        int n = classroom.length;
        int m = classroom[0].length();
        int[][] id = new int[n][m];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        Queue<int[]> q = new LinkedList<>();
        int[] start = new int[4];
        int idx = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(classroom[i].charAt(j) == 'L') id[i][j] = ++idx;
                else if(classroom[i].charAt(j) == 'S') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        int mask = (1 << idx) - 1;
        start[2] = mask;
        start[3] = energy;
        q.add(start);
        int[][][] best = new int[n][m][mask + 1];
        for(int[][] r : best) for(int[] c : r) Arrays.fill(c, -1);
        best[start[0]][start[1]][start[2]] = energy;
        
        int time = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int[] temp = q.poll();
                int x = temp[0];
                int y = temp[1];
               
                int currmask = temp[2];
                int currenergy = temp[3];
                 if (currenergy < best[x][y][currmask]) {
                    continue;
                }
                if(currmask == 0) return time;

                if(currenergy == 0) continue;
                for(int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(!possible(classroom, nx, ny)) {
                        continue;
                    }
                    int newmask = currmask;
                    int newenergy = currenergy - 1;
                    char ch = classroom[nx].charAt(ny);
                    if(ch == 'R') {
                        newenergy = energy;
                    }
                    else if(ch == 'L') {
                        int bit = 1 << (id[nx][ny] - 1);
                        newmask = currmask & ~bit;
                    }
                    
                    if(best[nx][ny][newmask] >= newenergy) continue;

                    best[nx][ny][newmask] = newenergy;
                    q.add(new int[]{
                        nx, ny, newmask, newenergy
                    });
                }
            }
            time++;
        }
        return -1;
    }

    boolean possible(String[] arr, int i, int j) {
        return i >= 0 && j >= 0 && i < arr.length && j < arr[0].length() && arr[i].charAt(j) != 'X' ;
    }
}