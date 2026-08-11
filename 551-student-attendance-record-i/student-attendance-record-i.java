class Solution {
    public boolean checkRecord(String s) {
        int late = 0;
        int absent = 0;
        for(char ch : s.toCharArray()) {
            if(ch == 'L') {
                late++;
                if(late >= 3) return false;
            }
            else {
                if(ch == 'A') {
                    absent++;
                    if(absent >= 2) return false;
                }
                late = 0;
            }
        }
        return true;
    }
}