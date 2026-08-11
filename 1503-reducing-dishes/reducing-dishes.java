class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        Integer[][] dp = new Integer[n][n+1];
        Arrays.sort(satisfaction);
        return satisficationScore(satisfaction, 0, 0, dp);
    }

    int satisficationScore(int[] value, int i, int time, Integer[][] dp) {
        if(i >= value.length) return 0;
        if(dp[i][time] != null) return dp[i][time];

        int pick = (time+1)*value[i] + satisficationScore(value, i+1, time+1, dp);
        int notpick = satisficationScore(value, i+1, time, dp);

        return dp[i][time] = Math.max(pick, notpick);
    }
}