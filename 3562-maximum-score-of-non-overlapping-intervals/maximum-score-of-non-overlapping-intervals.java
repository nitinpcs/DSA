class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        int[][] jobs = new int[n][4];
        for(int i = 0; i < n; i++) {
            jobs[i][0] = intervals.get(i).get(0);
            jobs[i][1] = intervals.get(i).get(1);
            jobs[i][2] = intervals.get(i).get(2);
            jobs[i][3] = i;
        }
        Comparator<int[]> byEndtime = (a, b) -> a[1] == b[1] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]);
        Arrays.sort(jobs, byEndtime);
        State[][] dp = new State[n+1][5];
        for(int i = 0; i <= n; i++) {
            for(int k = 0; k <= 4; k++) {
                dp[i][k] = new State(0, new ArrayList<>());
            }
        }
        for(int i = 1; i <= n; i++) {
            for(int k = 1; k <= 4; k++) {
                State skip = dp[i-1][k];
                int prev = findPrev(jobs, jobs[i-1][0], i-1);
                List<Integer> temp = new ArrayList<>(dp[prev+1][k-1].indices);
                temp.add(jobs[i-1][3]);
                Collections.sort(temp);
                long currScore = dp[prev+1][k-1].score + jobs[i-1][2];
                State take = new State(currScore, temp);

                dp[i][k] = bestPossible(skip, take);
            }
        }
        State ans = dp[n][4];
        int[] res = new int[ans.indices.size()];
        int i = 0;
        for(int idx : ans.indices) res[i++] = idx;

        return res;
    }

    int findPrev(int[][] jobs, int start, int right) {
        int left = 0;
        int ans = -1;
        while(left <= right) {
            int mid = left + ((right - left) >> 1);
            if(jobs[mid][1] < start) {
                ans = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return ans ;
    }

    State bestPossible(State a, State b) {
        if(a.score != b.score) return Long.compare(a.score, b.score) < 0 ? b : a;

        return lexicoGraphicComparison(a, b);
    }

    State lexicoGraphicComparison(State a, State b) {
        int len = Math.min(a.indices.size(), b.indices.size());
        for(int i = 0; i < len; i++) {
            int x = a.indices.get(i);
            int y = b.indices.get(i);
            if(x != y) {
                return Integer.compare(x, y) < 0 ? a : b;
            }
        }
        return Integer.compare(a.indices.size(), b.indices.size()) < 0 ? a : b;
    }
}

class State {
    long score;
    List<Integer> indices;
    State(long score, List<Integer> indices) {
        this.score = score;
        this.indices = indices;
    }
}