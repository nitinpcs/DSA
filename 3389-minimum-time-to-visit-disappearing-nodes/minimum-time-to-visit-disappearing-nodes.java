class Solution {
    int MAX = Integer.MAX_VALUE;
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];
            adj.get(u).add(new int[]{v , w});
            adj.get(v).add(new int[]{u, w});
        }
        int[] dist = new int[n];
        Arrays.fill(dist, MAX);
        dist[0] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.wt, b.wt));
        
        pq.offer(new Pair(0, 0));
        while(!pq.isEmpty()) {
            Pair temp = pq.poll();
            int u = temp.node;
            int d = temp.wt;
            if(d > dist[u]) continue;
            for(int[] nei : adj.get(u)) {
                int v = nei[0];
                int nd = nei[1] + d;
                if(nd < dist[v] && nd < disappear[v]) {
                    dist[v] = nd;
                    pq.offer(new Pair(v, nd));
                }
            }
        }
        for(int i = 0; i < n; i++) {
            if(dist[i] == MAX) {
                dist[i] = -1;
            }
        }
        return dist;
    }
}

class Pair{
    int node, wt;
    Pair(int n, int w) {
        node = n;
        wt = w;
    }
}