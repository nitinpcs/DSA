class Solution {
    public int maxProduct(int[] nums) {
        int max = 1;
        int min = 1;
        int res = Integer.MIN_VALUE;

        for(int e : nums) {
            int nmax = Math.max(e, Math.max(e*max, e*min));
            int nmin = Math.min(e, Math.min(e*max, e*min));

            res = Math.max(res, nmax);
            max = nmax;
            min = nmin;
        }
        return res;
    }
}