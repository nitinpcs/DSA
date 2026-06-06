class Solution {
    public int valueAfterKSeconds(int n, int k) {
        int[] a = new int[n];
        Arrays.fill(a, 1);
        while(k-- > 0) {
            for(int i=1; i<n; i++) a[i] = (a[i-1] + a[i]) % 1000000007 ;
        }
        return a[n-1] ;
    }
}