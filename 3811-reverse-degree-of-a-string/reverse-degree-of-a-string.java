class Solution {
    public int reverseDegree(String s) {
        int total = 0;
        for(int i = 0; i < s.length(); i++) {
            total += (i + 1)*(123 - s.charAt(i));
        }
        return total;
    }
}