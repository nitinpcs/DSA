class Solution {
    public int[] countTasks(int[] tasks, int[] shifts) {
        int n = tasks.length;
        long[] p = new long[n];
        p[0] = tasks[0];
        for(int i=1; i<n; i++) p[i] = p[i-1] + tasks[i];
        long work = 0;
        int[] ans = new int[shifts.length];
        for(int i=0; i<shifts.length; i++) {
            work += shifts[i];
            if(work >= p[n-1]) {
                work = 0;
                continue;
            }
            int completed = bs(p, work);
            ans[i] = n - completed;
        }
        return ans ;
    }

    int bs(long[] p, long t) {
        int s = 0;
        int e = p.length - 1;
        int ans = -1;
        while(s <= e) {
            int m = s + (e-s)/2;
            if(p[m] > t) {
                ans = m;
                e = m-1;
            }
            else s = m+1;
        }
        return ans ;
    }
}