class Solution {
    public long sumAndMultiply(int n) {
        long num = 0;
        int sum = 0;
        int len = 1;
        while(n > 0) {
            int d = n % 10;
            num = d * len + num;
            if(d != 0) len *= 10;
            sum += d;
            n /= 10;
        }
        return sum * num;
    }
}

