class Solution {
    public int[] countTasks(int[] tasks, int[] shifts) {
        int n = tasks.length;
        long[] p = new long[n];
        p[0] = tasks[0];
        for(int i=1; i<n; i++) p[i] = p[i-1] + tasks[i];

        int m = shifts.length;
        int[] ans = new int[m];
        long work = 0;
        for(int i=0; i<m; i++) {
            work += shifts[i];
            if(work >= p[n-1]) {
                work = 0;
                continue;
            }
            int last = bs(p, work);
            ans[i] = n - (last + 1);
        }
        return ans ;
    }

    int bs(long[] p, long t) {
        int s = 0, e = p.length-1;
        int ans = -1;
        while(s <= e) {
            int m = s + (e-s)/2;
            if(p[m] <= t) {
                ans = m;
                s = m+1;
            }
            else e=m-1;
        }
        return ans;
    }
}