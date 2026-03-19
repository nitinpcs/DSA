class Solution {
    int MOD = 1000000007;
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < roads.length; i++){
            int u = roads[i][0];
            int v = roads[i][1];
            int w = roads[i][2];
            adj.get(u).add(new int[]{v , w});
            adj.get(v).add(new int[]{u, w});
        }
        long MAX = Long.MAX_VALUE;
        long[] dist = new long[n];
        Arrays.fill(dist, MAX);
        dist[0] = 0L;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Long.compare(a.weight, b.weight));
        pq.offer(new Pair(0, 0L));
        long[] ways = new long[n];
        ways[0] = 1L;
        while(!pq.isEmpty()) {
            Pair temp = pq.poll();
            int node = temp.node;
            if(temp.weight > dist[node]) continue;
            for(int[] nei : adj.get(node)){
                long nw = nei[1] + temp.weight;
                if(nw < dist[nei[0]]) {
                    dist[nei[0]] = nw;
                    ways[nei[0]] = ways[node];
                    pq.offer(new Pair(nei[0], dist[nei[0]]));
                }
                else if(nw == dist[nei[0]]){
                    ways[nei[0]] = (ways[nei[0]] + ways[node]) % MOD;
                }
            }
        }
        return (int)ways[n-1];        
    }
}

class Pair{
        int node;
        long weight;
        Pair(int node, long weight){
            this.node = node;
            this.weight = weight;
        }
    }
