class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        int[] reach = new int[n];
        reach[0] = 1;
        int[] pre = new int[n];
        for(int i=0; i<minJump; i++) pre[i] = 1;

        for(int i=minJump; i<n; i++) {
            if(s.charAt(i) == '0') {
                int l = i-maxJump;
                int r = i-minJump;
                int total = pre[r] - (l  <= 0 ? 0 : pre[l-1]);
                if(total > 0) reach[i] = 1;
            }
            pre[i] = pre[i-1] + reach[i];
        }
        return reach[n-1] == 1;
    }
}