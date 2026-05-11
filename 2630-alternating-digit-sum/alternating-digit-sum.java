class Solution {
    public int alternateDigitSum(int n) {
        boolean plus = true;
        String s = String.valueOf(n);
        int altSum = 0;
        for(char c : s.toCharArray()) {
            if(plus) altSum += c - '0';
            else altSum += '0' - c;
            plus = !plus;  
        }
        return altSum;
    }
}