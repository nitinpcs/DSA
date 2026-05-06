class Solution {
    public int smallestRepunitDivByK(int k) {
        if(k % 2 == 0 || k % 5 == 0) return -1;
        Set<Long> set = new  HashSet<>();
        int len = 1;
        long rem = 1 % k;
        while(rem != 0 && !set.contains(rem)) {
            set.add(rem);
            rem = (rem*10 + 1) % k;
            len++;
        }
        return rem==0 ? len : -1;
    }
}