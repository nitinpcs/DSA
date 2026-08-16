class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] cnt = new int[3];
        for(int i : stones) {
            cnt[i % 3]++;
        }
        if(cnt[0] % 2 == 0) {
            return cnt[1] >= 1 && cnt[2] >= 1;
        }
        return cnt[1]-cnt[2] > 2 || cnt[2]-cnt[1] > 2;
    }
}