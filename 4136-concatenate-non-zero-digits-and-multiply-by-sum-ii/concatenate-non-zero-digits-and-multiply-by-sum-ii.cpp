const int mod = 1e9 + 7;
const int max_n = 100001;
long long pow10[max_n];

int init = []() {
    pow10[0] = 1;
    for(int i = 1; i < max_n; i++) {
        pow10[i] = (pow10[i-1] * 10) % mod;
    }
    return 0;
}();

class Solution {
public:
    vector<int> sumAndMultiply(string s, vector<vector<int>>& queries) {
        int n = s.size();
        vector<int> sum(n+1);
        vector<int> cnt(n+1);
        vector<long long> num(n+1);

        for(int i = 0; i < n; i++) {
            int d = s[i] - '0';
            sum[i+1] = sum[i] + d;
            cnt[i+1] = cnt[i] + (d > 0 ? 1 : 0);
            num[i+1] = d > 0 ? (num[i] * 10 + d) % mod : num[i];
        }

        vector<int> res(queries.size());
        int i = 0;
        for(const auto& q : queries) {
            int l = q[0];
            int r = q[1] + 1;
            int diff = cnt[r] - cnt[l];
            long long val = (num[r] - ((num[l]*pow10[diff])%mod)+mod) % mod;
            long long val_sum = sum[r] - sum[l];
            res[i++] = (int)((val * val_sum) % mod);
        }

        return res;
    }
};