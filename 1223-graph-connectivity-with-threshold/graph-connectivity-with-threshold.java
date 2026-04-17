class Solution {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        UnionFind uf = new UnionFind(n + 1);
        for (int d = threshold + 1; d < n; d++)
            for (int i = d; i <= n - d; i+= d)
                uf.union(i, i + d);       
        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries)
            ans.add (uf.find(query[0]) == uf.find(query[1]));        
        return ans;
    }

    class UnionFind {
        private int[] parent;  
        private int[] rank;  
         
        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int p) {;
            if(parent[p] != p) {
                parent[p] = find(parent[p]);
            }
            return parent[p];
        }

        void union(int p, int q) {
            int rootP = find(p), rootQ = find(q);
            if (rootP == rootQ) return;
            if (rank[rootP] < rank[rootQ])
                parent[rootP] = rootQ;
            else if (rank[rootP] > rank[rootQ])
                parent[rootQ] = rootP;
            else {
                parent[rootQ] = rootP;
                rank[rootP]++;
            }
        }
    }
}