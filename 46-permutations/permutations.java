class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), ans, 0);
        return ans;
    }

    void backtrack(int[] nums, List<Integer> l, List<List<Integer>> ans, int mask) {
        if(l.size() == nums.length) {
            ans.add(new ArrayList<>(l));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if((mask & (1 << i)) == 0) {
                l.add(nums[i]);
                backtrack(nums, l, ans, mask | (1 << i));
                l.remove(l.size()-1);
            }
            
        }
    }
}