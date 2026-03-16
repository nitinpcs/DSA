class Solution {
    class Pair{
        int node ;
        int weight;
        Pair(int node , int weight){
            this.node=node;
            this.weight=weight;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] num : times){
            int u=num[0];
            int v=num[1];
            int w=num[2];
            adj.get(u).add(new Pair(v,w));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a->a.weight));
        int[] t= new int [n+1];
        Arrays.fill(t,Integer.MAX_VALUE);
        t[k]=0;
        pq.add(new Pair(k,0));
        while(!pq.isEmpty()){
            Pair p= pq.poll();
            int nei=p.node;
            int wei=p.weight;
            if(wei>t[nei]) continue;
            for(Pair q : adj.get(nei)){
                int v=q.node;
                int w=q.weight;
                if(t[v]>t[nei]+w){
                    t[v]=t[nei]+w;
                    pq.add(new Pair(v,t[v]));
                }
            }
        }
        for(int i=1;i<t.length;i++){
            if(t[i]==Integer.MAX_VALUE){
                return -1;
            }
        }
        t[0] = 0;
        int max=Arrays.stream(t).max().getAsInt();
        return max;
    }
}