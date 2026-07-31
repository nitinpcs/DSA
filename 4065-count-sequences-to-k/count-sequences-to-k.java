class Solution {
    int t2 = 0, t3 = 0, t5 = 0;
    int[][] prime;
    int[][][][] dp;
    public int countSequences(int[] nums, long k) {
        while(k % 2 == 0) {
            k /= 2;
            t2++;
        }
        while(k % 3 == 0) {
            k /= 3;
            t3++;
        }
        while(k % 5 == 0) {
            k /= 5;
            t5++;
        }
        if(k > 1) return 0;
        prime = new int[nums.length][3];
        for(int i = 0; i < nums.length; i++) {
            int x = nums[i];
            while(x % 2 == 0) {
                x /= 2;
                prime[i][0]++;
            }
            while(x % 3 == 0) {
                x /= 3;
                prime[i][1]++;
            }
            while(x % 5 == 0) {
                x /= 5;
                prime[i][2]++;
            }
        }

        dp = new int[nums.length][77][39][39];
        for(int[][][] a : dp)
            for(int[][] b : a)
                for(int[] c : b)
                    Arrays.fill(c,-1);
        return dfs(nums, 0, 0, 0, 0);
    }

    int dfs(int[] nums, int idx, int e2, int e3, int e5) {
        if(idx == nums.length) {
            return t2 == e2 && t3 == e3 && t5 == e5 ? 1 : 0;
        }
        if(dp[idx][e2+38][e3+19][e5+19] != -1) {
            return dp[idx][e2+38][e3+19][e5+19];
        }

        int count = 0;
        count = dfs(nums, idx+1, e2, e3, e5);
        count += dfs(nums, idx+1, e2+prime[idx][0], e3+prime[idx][1], e5+prime[idx][2]);
        count += dfs(nums, idx+1, e2-prime[idx][0], e3-prime[idx][1], e5-prime[idx][2]);

        return dp[idx][e2+38][e3+19][e5+19] = count;
    }
}