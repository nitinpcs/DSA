class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        if(n < 3) return -1;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int min = 2*n;
        for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            ArrayList<Integer> temp = entry.getValue();
            if(temp.size() < 3) continue;

            for(int i=0; i<temp.size()-2; i++) {
                min = Math.min(min, 2*(temp.get(i+2) - temp.get(i)));
            }
        }

        return min == 2*n ? -1 : min;
    }
}