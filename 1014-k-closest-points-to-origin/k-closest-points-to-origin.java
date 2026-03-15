class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> Double.compare(b.dist, a.dist));

        for(int i=0;i<points.length;i++){
            int cord[]= points[i];
            int x=cord[0];
            int y=cord[1];

            double dis= Math.sqrt((x*x)+(y*y));

            pq.add(new Pair(dis,x,y));
            if(pq.size()>k) {
                pq.poll();
            }

        }

        int ans[][]= new int[k][2];
        int n=ans.length;
        for(int i=0;i<n;i++){
            Pair triplet = pq.poll();
            int x = triplet.x;
            int y = triplet.y;

            ans[i][0]=x;
            ans[i][1]=y;
        }

        return ans;
        
    }

    class Pair {
        double dist;
        int x, y;
        Pair(double d, int i, int j) {
            dist = d;
            x = i;
            y = j;
        }
    }
}