class Solution {
    public int smallestNumber(int n, int t) {
        while(true) {
            if(getProduct(n) % t == 0) return n;
            n++;
        }
    }

    int getProduct(int n) {
        int res = 1;
        while(n > 0) {
            res *= (n % 10);
            n /= 10;
        }
        return res;
    }
}