class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(n <= 2) return n;
        int msb = 0;
        while(n > 0) {
            n = n >> 1;
            msb++;
        }
        return 1 << msb;
    }
}