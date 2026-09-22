class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int mask = (1 << n) - 1;
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][mask+1];
        for(int i=0; i<n; i++) {
            q.add(new int[]{i, 1 << i});
            vis[i][1 << i] = true;
        }
        int steps = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int[] t = q.poll();
                int node = t[0];
                int state = t[1];
                if(state == mask) return steps;
                for(int nei : graph[node]) {
                    int newMask = state | (1 << nei);
                    if(vis[nei][newMask]) continue;
                    q.add(new int[]{nei, newMask});
                    vis[nei][newMask] = true;
                }
            }
            steps++;
        }
        return -1;
    }
}
