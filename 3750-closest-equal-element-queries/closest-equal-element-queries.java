class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        List<Integer> res = new ArrayList<>();
        for(int q : queries) {
            List<Integer> cur = map.get(nums[q]);
            if(cur.size() == 1) {
                res.add(-1);
                continue;
            }
            
            int idx = Collections.binarySearch(cur, q);
            int prev = cur.get((idx-1+cur.size()) % cur.size());
            int next = cur.get((idx+1) % cur.size());
            int d1 = Math.abs(prev-q);
            int d2 = Math.abs(next-q);

            d1 = Math.min(d1, n-d1);
            d2 = Math.min(d2, n-d2);

            res.add(Math.min(d1, d2)); 
        }
        return res;
    }
}