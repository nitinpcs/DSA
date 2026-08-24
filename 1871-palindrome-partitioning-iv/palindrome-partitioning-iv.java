class Solution {
    public boolean checkPartitioning(String s) {
        int n = s.length();

        boolean[][] pal = new boolean[n][n];
        for(int i=0 ; i<n; i++) pal[i][i] = true;

        for(int len=2; len<=n; len++) {
            for(int i=0; i+len-1 < n; i++) {
                int j = i+len-1;
                pal[i][j] = s.charAt(i) == s.charAt(j) && (len == 2 || pal[i+1][j-1]); 
            }
        }
        
        for(int i=0; i<n-2; i++) {
            if(!pal[0][i]) continue;
            for(int j=i+1; j<n-1; j++) {
                if(pal[i+1][j] && pal[j+1][n-1]) return true;
            }
        }

        return false;
    }
}