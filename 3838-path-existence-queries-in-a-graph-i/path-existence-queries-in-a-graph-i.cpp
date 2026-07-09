class Solution {
public:
    vector<bool> pathExistenceQueries(int n, vector<int>& nums, int maxDiff, vector<vector<int>>& queries) {
        vector<int> parent(n);
        for(int i = 0; i < n; i++) parent[i] = i;

        for(int i = 1; i < n ; i++) {
            if(nums[i] - nums[i-1] <= maxDiff) {
                unionSet(parent, i, i-1);
            }
        }

        vector<bool> ans(queries.size());
        int i = 0;
        for(const auto& query : queries) {
            int x = query[0];
            int y = query[1];
            if(find(parent, x) == find(parent, y)) ans[i++] = true;
            else ans[i++] = false;
        }

        return ans;
    }

    int find(vector<int> &parent, int x) {
        if(parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    void unionSet(vector<int> &parent , int x, int y) {
        parent[find(parent, x)] = find(parent, y);
    }
};