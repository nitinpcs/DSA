class Solution {
public:
    vector<bool> pathExistenceQueries(int n, vector<int>& nums, int maxDiff, vector<vector<int>>& queries) {
        vector<int> component (n);
        int val = 0;
        component[0] = 0;
        for(int i = 1; i < n; i++) {
            if(nums[i] - nums[i-1] > maxDiff) {
                val++;
            }
            component[i] = val;
        }

        vector<bool> ans(queries.size());
        int i = 0;
        for(const auto& query : queries) {
            int u = query[0];
            int v = query[1];
            ans[i++] = component[u] == component[v]; 
        }

        return ans;
    }
};