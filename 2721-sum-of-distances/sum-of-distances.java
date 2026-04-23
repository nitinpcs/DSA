class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++) map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);

        for(List<Integer> group : map.values()) {
            long total = 0;
            for(int e : group) total += e;
            long prefix = 0;
            int size = group.size();
            for(int i=0; i<size; i++) {
                int idx = group.get(i);
                long left =  (long)i*idx - prefix;
                long right = total - prefix - idx - (long)idx*(size-i-1);
                ans[idx] = left + right;
                prefix += idx;
            }
        }
        return ans;
    }
}