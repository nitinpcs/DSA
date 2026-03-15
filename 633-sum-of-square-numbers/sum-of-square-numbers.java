class Solution {
    public boolean judgeSquareSum(int c) {
        int l = 0;
        int r = (int)Math.sqrt(c);

        while(l <= r) {
            long num = (long)l*l + (long)r*r;
            if(num == c) return true;
            else if(num < c) l++;
            else r--;
        }
        return false;
    }
}