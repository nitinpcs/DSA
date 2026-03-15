class Solution {
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            int target = c - (int)(a * a);
            if (binarySearch(target)) {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int target) {
        int left = 0, right = (int)Math.sqrt(target);
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int square = mid * mid;
            if (square == target) return true;
            else if (square < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}