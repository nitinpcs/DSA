class Solution {
    public int largestInteger(int n, int s) {
        if(9*n < s) return -1;
        int num = 0;
        while(s > 0 && n > 0) {
            if(s >= 9) {
                num = num*10 + 9;
                s -= 9;
                n--;
            }
            else {
                num = num*10 + s;
                s = 0;
                n--;
            }
        }
        if(n == 0) return num;
        return num * (int)Math.pow(10, n);
    }
}