class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        List<List<Integer>> l = new ArrayList<>();
        int n = quiet.length;
        for(int i=0; i<n; i++) l.add(new ArrayList<>());
        
        for(int[] rich : richer) {
            l.get(rich[1]).add(rich[0]);
        }
        
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for(int i=n-1; i>=0; i--) {
            dfs(ans, l, i, quiet);
        }
        return ans;
    }

    int dfs(int[] ans, List<List<Integer>> graph, int i, int[] q) {
        if(ans[i] != -1) return ans[i];
        int min = i;
        for(int nei : graph.get(i)) {
            int curr = dfs(ans, graph, nei, q);
            if(q[curr] < q[min]) min = curr;
        }
        return ans[i] = min;
    }
}