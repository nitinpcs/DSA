class Solution {
    public boolean checkValidString(String s) {
        int min = 0;
        int max = 0;
        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                min++;
                max++;
            }
            else if(ch == ')') {
                max--;
                min = Math.max(0, min - 1);
            }
            else {
                min = Math.max(0, min - 1);
                max++;
            }
            if(max < 0) return false;
        }
        return min == 0;
    }
}