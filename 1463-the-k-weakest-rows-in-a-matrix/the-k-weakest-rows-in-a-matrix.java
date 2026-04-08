class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;

        int[] ones = new int[n];
        for(int i=0; i<n; i++) {
            int cur = 0;
            for(int ele : mat[i]){
                if(ele == 1) cur++;
                else break;
            }
            ones[i] = cur;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]==b[0] ? b[1]-a[1] : b[0]-a[0]);

        for(int i=0; i<n; i++) {
            pq.add(new int[]{ones[i], i});
            if(pq.size() > k) pq.poll();
        }

        int[] ans = new int[k];
        while(!pq.isEmpty()) {
            ans[--k] = pq.poll()[1];
        }

        return ans;
    }
}