class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        int max = Arrays.stream(nums).max().getAsInt();
        int[] f = new int[max+1];
        for(int i : nums) f[i]++;

        if(f[max] != 2) return false;
        for(int i=1; i<max; i++) if(f[i] != 1) return false;

        return true;
    }
}