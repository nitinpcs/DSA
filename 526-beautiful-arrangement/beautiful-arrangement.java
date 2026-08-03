class Solution {
    public int countArrangement(int n) {
        return helper(n, 1, (1<<n)-1);
    }
    public int helper(int n, int idx, int mask){
        if(idx > n){
            return 1;
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            if((mask & (1 << i)) != 0 && (idx % (i+1) == 0 || (i+1) % idx == 0)){
                count += helper(n, idx + 1, mask ^ (1<<i));
            }
        }
        return count;
    }
}