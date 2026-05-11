class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> l = new ArrayList<>();
        for(int i : nums) {
            String s = String.valueOf(i);
            for(char c : s.toCharArray()) {
                l.add(c - '0');
            }
        }

        int[] ans = new int[l.size()];
        int i = 0;
        for(int j : l) ans[i++] = j;
        return ans;
    }
}