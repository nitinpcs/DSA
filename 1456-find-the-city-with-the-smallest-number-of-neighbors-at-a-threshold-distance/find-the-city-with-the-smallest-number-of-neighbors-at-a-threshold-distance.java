class Solution {
    int MAX = Integer.MAX_VALUE;
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for(int[] e : dist) Arrays.fill(e, MAX);

        for(int[] e : edges) {
            dist[e[0]][e[1]] = e[2];
            dist[e[1]][e[0]] = e[2];
        }

        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                if(dist[i][k] == MAX) continue;
                for(int j=0; j<n; j++){
                    if(dist[k][j] == MAX) continue;
                    if(dist[i][k] + dist[k][j] < dist[i][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        int maxD = MAX;
        int ansNode = 0;
        for(int i=n-1; i>=0; i--){
            int cur = 0;
            for(int j=0; j<n; j++){
                if(i!=j && dist[i][j] <= distanceThreshold) cur++;
            }
            if(cur < maxD) {
                maxD = cur;
                ansNode = i;
            }
        }
        return ansNode;
    }
}