class Solution {
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for(int ele : stones) {
            sum += ele;
        }
        Integer[][] dp = new Integer[n][n];
        return getDiff(stones, 0, n-1, sum, dp);
    }

    int getDiff(int[] stones, int i, int j, int sum, Integer[][] dp) {
        if(i > j) return 0;
        if(dp[i][j] != null) return dp[i][j];

        int front = (sum - stones[i]) - getDiff(stones, i+1, j, sum-stones[i], dp);
        int end = (sum - stones[j]) - getDiff(stones, i, j-1, sum-stones[j], dp);

        return dp[i][j] = Math.max(front, end);
    }
}