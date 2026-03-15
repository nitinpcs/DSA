class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 1, right = x / 2 + 1; 
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long num = (long) mid * mid;
            if (num == x) return mid;
            else if (num < x) left = mid + 1;
            else right = mid - 1;
        }
        return right;
    }
}