class Solution {
    List<List<Integer>> adj ;
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++) adj.add(new ArrayList<>());
        for(int[] c : prerequisites) {
            int u = c[0];
            int v = c[1];
            adj.get(u).add(v);
        }
        boolean[][] isReachable = new boolean[numCourses][numCourses];
        for(int i=0; i<numCourses; i++) {
            bfs(i, numCourses, isReachable);
        }
        List<Boolean> ans = new ArrayList<>();
        for(int[] q : queries) {
            int u = q[0];
            int v = q[1];
            boolean val = isReachable[u][v];
            ans.add(val);
        }
        return ans;
    }


    void bfs(int src, int n, boolean[][] isReachable) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];

        q.add(src);
        vis[src] = true;

        while(!q.isEmpty()) {
            int t = q.poll();

            for(int v : adj.get(t)){
                if(!vis[v]) {
                    vis[v] = true;
                    isReachable[src][v] = true;
                    q.offer(v);
                }
            }
        }
    }
}