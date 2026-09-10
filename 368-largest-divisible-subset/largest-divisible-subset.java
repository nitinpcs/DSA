class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int[] dp = new int[n];
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        Arrays.fill(dp, -1);

        for(int i=1; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(nums[i] % nums[j] == 0) {
                    if(dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        parent[i] = j;
                    }
                }
            }
        }
        int last = 0;
        for(int i = 1; i < n; i++) {
            if(dp[i] > dp[last]) last = i;
        }

        List<Integer> ans = new ArrayList<>();
        while(last != -1) {
            ans.add(nums[last]);
            last = parent[last];
        }
        Collections.reverse(ans);

        return ans;
    }
}