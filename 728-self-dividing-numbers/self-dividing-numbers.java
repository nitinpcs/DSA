class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for(int i = left; i <= right; i++) {
            if(isSelfNumber(i)) res.add(i);
        }
        return res;
    }

    boolean isSelfNumber(int n) {
        int temp = n;
        int d = 0;
        while(temp > 0) {
            d = temp % 10;
            if(d == 0 || n % d != 0) return false;
            temp /= 10;
        }
        return true;
    }
}