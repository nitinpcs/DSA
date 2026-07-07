class Solution {
    public long sumAndMultiply(int n) {
        String s = String.valueOf(n);
        long num = 0;
        int sum = 0;
        for(int i=0; i<s.length(); i++) {
            int rem = s.charAt(i) - '0';
            if(rem > 0) {
                num = num*10 + rem;
                sum += rem;
            }
        }
        return num * sum ;
    }
}